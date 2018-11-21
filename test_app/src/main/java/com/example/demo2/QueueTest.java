package com.example.demo2;

public class QueueTest {

	int front;
	int rear;
	int queueSize;
	Object [] queueArr;
	
	
	
	public static void main(String[] args) {
		
		QueueTest qt = new QueueTest();
		
		qt.queueCreate(5);
		qt.queueAdd("A");
		qt.queueAdd("B");
		qt.queueAdd("C");
		qt.queueAdd("D");
		
		qt.queueDelete();
		qt.queueDelete();
		qt.queueDelete();
		qt.queueAdd("E");
		
		for(int i=0; i<qt.queueSize; i++){
			System.out.println("값"+qt.queueArr[i]);
		}
		
	}
	
	
	
	
	public void queueCreate(int size){
		
		queueArr = new Object[size];
		queueSize = size;
		front = 0;
		rear = 0;
	
	}
	
	
	public void queueAdd(String text){
		
		if(isFull()){
			
			queueArr[rear] = text;
			rear++;
			
		}
		
	}
	
	public void queueDelete(){
		
		if(!isEmpty()){
			
			queueArr[front] = null;
			front++;
		
		}
		
	}
	
	
	public boolean isEmpty(){
		
		if(rear == 0){
			return true;
			
		}else{
			System.out.println("IS EMPTY");
			return false;
		}
		
	}
	
	public boolean isFull(){
		
		if(rear < queueSize-1 ){
			return true;
		}else{
			System.out.println("IS FULL");
			return false;
		}
		
		
		
	}
	
	
}
