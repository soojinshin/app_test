package com.example.demo2;




public class StackTest {

	 int top;
	 int stackSize;
	 Object [] stackArr;
	
	/*public static void main(String[] args) {
		
		StackTest st = new StackTest();

		st.stackCreate(5);
		st.push(1);
		st.push(2);
		//st.pop();
		st.push(3);
		st.push(4);
		//st.pop();
		st.push(5);
		st.push(6);
		st.push(6);
		
		for(int i=0; i< stackSize; i++){
		
			System.out.println("스택구성값:"+stackArr[i]);
		}
		
	}*/
	
	public void stackCreate(int size){
		
		stackSize = size;
		top = -1;
		
		stackArr =  new Object[stackSize];
		
	}
	
	public boolean isFull(){
		
		
		if(top+1 == stackSize){
			return true;
		}else{
			return false;
		}
		
	}
	
	public boolean isEmpty(){
		
		if(top == -1){
			return true;
		}else{
			return false;
		}
		
	}
	public void push(String str){

		if(!isFull()){
			stackArr[top+1] = str;
			top++;
		}else{
			System.out.println("stack is Full!");
		}
		
	}
	
	
	public void pop(){
		
		if(!isEmpty()){
			stackArr[top] = null;
			top--;
		}else{
			System.out.println("stack is Empty!");
		}
		
		
	}
}
