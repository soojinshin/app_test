package com.example.demo;

public class MySingleLinkedList<T> {

	public Node<T> head;
	public int size;
	
	public MySingleLinkedList() {
		head = null;
		size = 0;
	}
	
	public void addFirst(T item){
		Node<T> newNode = new Node<T>(item); 
		
		//극단적인 경우까지 생각해야함
		
		newNode.next = head;
		head = newNode;
		size++;			
	
	}
	
	public void addAfter(Node<T> before, T item){
		
		Node<T> temp = new Node<T>(item);
		
		temp.next = before.next;
		before.next = temp;
		size++;
		
		
	}
	
	
	
	public void add(int index, T item){
		
		
	}
	
	
	public void remove(int index){
		
	}
	
	//삭제할 노드의 주소만으로 삭제를 하기엔 어려움

	public T removeFirst(){
		
		if(head != null){
			T temp = head.data;
			head = head.next;
			size--;
			return temp;
		}else{
			size--;
			return null;
		}
		
	}
	
	
	public void removeAfter(Node<T> before){
		
		if(before.next != null){
			before.next = before.next.next;
		}
		size--;
		
	}
	
	
	
	public int indexOf(T item){
		
		return -1;
	}
	
	public T get(int index){
		
		return null;
		
	}
	
	public static void main(String[] args) {
		
		MySingleLinkedList<String> list = new MySingleLinkedList<>();
		
		list.add(0, "Sat");
		list.add(1, "Mon");
		list.add(1, "Fri");
		list.add(2, "Sun");
		
		String str = list.get(0);
		list.remove(2);
		
		int pos = list.indexOf("Fri");
		
	}
	
}
