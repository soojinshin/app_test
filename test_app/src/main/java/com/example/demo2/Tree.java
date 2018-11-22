package com.example.demo2;

//왼쪽 자식, 오른쪽 형제표현법
public class Tree {

	public static void add(Node parent, Node child){
		
		
		if(parent.getLeftChild() == null){
			parent.setLeftChild(child);
		}else{
			Node leftChild = parent.getLeftChild();
			
			while(leftChild.getRightSibling() != null){
				leftChild = leftChild.getRightSibling();
			}
			
			leftChild.setRightSibling(child);
			
		}
		
	}
	
	
	public static void printLevel(Node node,int level){
		
		int depth = 1;
		Node tempChild = node;
		Node tempParent = node;
		
		
		//레벨에 도달할때까지 반복
		//해당 레벨의 노드가 존재시
		//데이터 출력하고 형제노드로 이동
		//부모 노드의 형제노드가 존재한다면
		//그 노드의 자식 노드들도 출력	
		//깊이와 레벨이 맞지 않으면 부모노드 저장	
		//한단계 아래로 내려감
		
		while(depth <= level){
			
			if(depth == level){
				
				while(tempChild != null){
					System.out.println("데이터:"+tempChild.getData());
					tempChild = tempChild.getRightSibling();
				}
				
				if(tempParent.getRightSibling() != null){
					tempParent = tempParent.getRightSibling();
					tempChild = tempParent.getLeftChild();
				}else{
					break;
				}
				
				
			}else{
				tempParent = tempChild;
				tempChild = tempChild.getLeftChild();
				depth++;
			}
			
		}
	
		
		
		
	}
	
	public static void printTree(Node node, int depth){
		
		
		System.out.println(node.getData());
		
		if(node.getLeftChild() != null){
			printTree(node.getLeftChild(),depth+1);
		}
		
		if(node.getRightSibling() != null){
			printTree(node.getRightSibling(),depth);
		}
		
		
	}
	
}
