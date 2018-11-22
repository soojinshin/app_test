package com.example.demo2;

public class PostfixTest {

	
	public static void main(String[] args) {
		
		PostfixTest pt = new PostfixTest();
		
		pt.postFix("(A+B)*(C+D)");
		
	}
	
	
	
	
	public void postFix(String text){
	/*	text = text.replace("(", "");
		text = text.replace(")", "");
		*/
		
		String [] strArr = new String[text.length()];
		
		System.out.println(text);
		
		strArr = text.split("");
		
		StackTest stack = new StackTest();
		
		String printStr = "";
		
		
		stack.stackCreate(strArr.length);
		
		for(String str : strArr){
			
			System.out.println("현재순서 텍스트"+str);
			
			if(str.equals("+")||str.equals("-")){
				if(stack.stackArr[stack.top].equals("/")||stack.stackArr[stack.top].equals("*")){
					printStr = printStr + str + stack.stackArr[stack.top];
					stack.pop();
				}else{
					stack.push(str);
					
				}
			}else if(str.equals("/")||str.equals("*")){
				if(stack.stackArr[stack.top].equals("+")||stack.stackArr[stack.top].equals("-")){
					printStr = printStr + str + stack.stackArr[stack.top];
					stack.pop();
				}else{
					stack.push(str);
				}
			}else if(str.equals("(")){
				stack.push(str);
	
			}else{
				printStr = printStr + str ;
			}
	
		}
		
		if(!stack.isEmpty()){
			
			for(Object str : stack.stackArr){
				printStr = printStr + str;
			}
		}
		
		System.out.println("변환값:"+printStr);
	
	}
	
	
	
	
	
}
