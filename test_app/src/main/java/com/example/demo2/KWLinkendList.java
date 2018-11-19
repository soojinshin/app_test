package com.example.demo2;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class KWLinkendList<E> {

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	//이너클래스 static(클래스 안에 존재) head,tail 사용불가
	private static class Node<T>{
		public T data;
		public Node<T> next;
		public Node<T> previous;
		
		public Node(T item) {
			data = item;
			next = null;
		}

	}
	

	private class KWListIterator implements ListIterator<E>{

		private Node<E> nextItem;
		
		private Node<E> lasItemReturned;
		
		private int index;
		
		
		public KWListIterator(int i) {
			if(i <0|| i> size){
				throw new IndexOutOfBoundsException();
			}
			
			lasItemReturned = null;
			
			if(i==size){
				index = size;
				nextItem = null;
			}else{
				nextItem = head;
				for(index=0;index<i;index++){
					nextItem = nextItem.next;
				}
				
			}
			
			
			
			
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return nextItem != null;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			
			lasItemReturned  = nextItem;
			nextItem =  nextItem.next;
			index++;
			
			return lasItemReturned.data;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return (nextItem == null && size != 0)|| nextItem.previous != null;
		}

		@Override
		public E previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void set(E e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void add(E e) {
			// TODO Auto-generated method stub
			
			//노드가 하나도 없는경우
			if(head == null){
				head = new Node<E>(e);
				tail = head;
			//맨앞
			}else if(nextItem == head){
				Node<E> newNode = new Node<E>(e);
				newNode.next = nextItem;
				newNode.previous = newNode;
				head = newNode;
				
			//마지막 노드	
			}else if(nextItem == null){
				Node<E> newNode = new Node<E>(e);
				tail.next = newNode;
				newNode.previous = tail;
				tail = newNode;
				
			//중간삽입
			}else{
				Node<E> newNode = new Node<E>(e);
				newNode.previous = nextItem.previous;
				nextItem.previous.next = newNode;
				newNode.next = nextItem;
				nextItem.previous = newNode;
			}
			
			size++;
			index++;
			
		}
		
	}
	
	
	public int indexOf(E item){
		return 0;
	}
	
	public void add(int index, E item){
		listIterator(index).add(item);
	}
	
	public E get(int index){
		return listIterator(index).next();
	}
	
	
	public E remove(int index){
		if(index<0|| index>=size){
			throw new IndexOutOfBoundsException();
		}
		
		ListIterator<E> iter = listIterator(index);
		E result = iter.next();
		iter.remove();
		
		
		return result;
		
	}
	

	
	public Iterator<E> iterator(){
		return new KWListIterator(0);
		
	}
	
	public ListIterator<E> listIterator(){
		
		return new KWListIterator(0);
	}
	
	public ListIterator<E> listIterator(int index){
		
		return new KWListIterator(index);
	}
	
}
