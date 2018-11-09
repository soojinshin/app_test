package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	
	@RequestMapping("/test")
	public String test(){
		
		return "main";
		
	}
	
	@RequestMapping("/getIndexInfo")
	@ResponseBody
	public List<IndexDTO> getIndexInfo(Model model){
		
		String indexUrl;
		Double standardIndex;
		Double standardGap;
		List<IndexDTO> list = new ArrayList<>();
		

		//s&p
		indexUrl = "https://finance.naver.com/world/sise.nhn?symbol=SPI@SPX";
		standardIndex = 2885.57;
		standardGap = standardIndex/100;
		IndexDTO spIndexDTO = getIndexGap(indexUrl, standardIndex, standardGap);
		spIndexDTO.setIndexName("S&P");
		list.add(spIndexDTO);
		
		//니케이
		indexUrl = "https://finance.naver.com/world/sise.nhn?symbol=NII@NI225";
		standardIndex = 23783.72;
		standardGap = standardIndex/100;
		IndexDTO niiIndexDTO = getIndexGap(indexUrl, standardIndex, standardGap);
		niiIndexDTO.setIndexName("NIKKEI");
		list.add(niiIndexDTO);
		
		//홍콩
		indexUrl = "https://finance.naver.com/world/sise.nhn?symbol=HSI@HSCE";
		standardIndex = 10530.32;
		standardGap = standardIndex/100;
		IndexDTO hsiIndexDTO = getIndexGap(indexUrl, standardIndex, standardGap);
		hsiIndexDTO.setIndexName("HSCEI");
		list.add(hsiIndexDTO);
		
		return list;

		
	}
	
	
	
	@RequestMapping("/getHtml")
	public IndexDTO getIndexGap(String indexUrl,Double standardIndex,Double standardGap){
		
		
		//Double standardIndex = 23783.72;
		//Double standardGap = 237.8372;
		Double nowIndex;
		Double realGap = 0.0;
		IndexDTO indexDTO = new IndexDTO();
		
		
		try {
			//URL targetUrl = new URL("https://finance.naver.com/world/sise.nhn?symbol=NII@NI225");
			
			URL targetUrl = new URL(indexUrl);
			
			URLConnection conn = targetUrl.openConnection();
			
			conn.setDoOutput(true);
			BufferedReader br =  new BufferedReader(new InputStreamReader(targetUrl.openStream(), "utf-8"));
			
			String inputline;
			String buffer = "";

			while((inputline = br.readLine()) != null){			
				buffer += inputline.trim();
			}
			
			br.close();
			Document doc = Jsoup.parse(buffer);
			Elements el = doc.getElementsByClass("tb_td2");
			
			List<String> list = new ArrayList<>();
			
			for(int i=0; i< el.size(); i++ ){
				Element span = el.get(i);
				String text = span.select("span").text().toString();
				text = text.replaceAll("\\,", "");
				list.add(text);	
			}
			
			nowIndex = Double.parseDouble(list.get(1));
			Double indexGap = standardIndex - nowIndex;
			realGap = indexGap/standardGap;
			realGap = Math.round((100 - realGap)*1000)/1000.0;
			

			indexDTO.setNowIndex(nowIndex);
			indexDTO.setRealGap(realGap);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return indexDTO;
		
		
	}
	
	
	
	
	
	@RequestMapping("/jsonTest")
	@ResponseBody
	public List<TestDTO> jsonTest() throws Exception{
	
		List<TestDTO> list = new ArrayList<TestDTO>();
	/*	JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		*/

		
		for(int i=0; i<10; i++){
			
			
			TestDTO testDTO = new TestDTO();
			
			testDTO.setName("name"+i);
			testDTO.setText("text"+i);
	
			list.add(testDTO);
	
			
		}
		
		
	/*	jsonArr.put(list);
		jsonObj.put("sendList", jsonArr);
		

		return jsonObj;
		*/
		return list;
		
		
	}
}
