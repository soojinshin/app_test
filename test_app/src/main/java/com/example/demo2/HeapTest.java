package com.example.demo2;

public class HeapTest {

	
	public static void main(String[] args) {
		
		Heap heap = new Heap();
		
		heap.insert(6);
		heap.insert(3);
		heap.insert(5);
		heap.insert(2);
		heap.insert(1);
		heap.insert(4);
		//heap.insert(23);
	
		
		for(int i=0; i<heap.data.length;i++){
			System.out.println("순서:"+i+"데이터:"+heap.data[i]);
		}
		
		
		heap.remove();
		
		for(int i=0; i<heap.data.length;i++){
			System.out.println("순서:"+i+"데이터:"+heap.data[i]);
		}
		
		
	}
	
	
}
