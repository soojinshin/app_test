package com.example.demo2;

public class Node {

	private char data;
	private Node leftChild;
	private Node rightSibling;
	
	public Node(char data) {
		// TODO Auto-generated constructor stub
		this.setData(data); 
	}
	
	public char getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Node getRightSibling() {
		return rightSibling;
	}
	public void setRightSibling(Node rightSibling) {
		this.rightSibling = rightSibling;
	}

	
	
	
	
}
