package com.example.demo2;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Heap {

	int [] data;
	int size;
	
	public Heap() {
		data = new int[100];
		size = 1;
	}
	
	
	public void insert(int num){
		
		data[size] = num;
		int pointer = size;
		size++;
		

		while(data[pointer] > data[pointer/2]){
			if(pointer == 1){break;}
			int temp = data[pointer/2];
			
			data[pointer/2] = data[pointer];
			data[pointer] = temp;
			
			pointer = pointer/2;
			
		}
			
	
		
		
	}
	
	
	public void remove(){

		int pointer = 1;
		data[pointer] =  data[size-1];
		data[size-1] = 0;
		size--;
		

		while(true){
			
			System.out.println("dddd"+pointer);
			int temp = data[pointer];

			if(data[pointer] > data[pointer*2] && data[pointer] > data[pointer*2+1]){
				break;
				
			}else if(data[pointer*2] > data[pointer*2+1]){
		
				data[pointer] = data[pointer*2];
				data[pointer*2] = temp;
				pointer = pointer*2;
					
			}else{
				data[pointer] = data[pointer*2+1];
				data[pointer*2+1] = temp;
				pointer = pointer*2+1;
			}
	
			
		}
		

	}
	
	
	
}
