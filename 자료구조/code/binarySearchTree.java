public class binarySearchTree {
	
	public class Node {
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.setData(data);
			setLeft(null);
			setRight(null);
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}
	
	public Node root;
	public binarySearchTree() {
		this.root = null;
	}
	
	//Ž�� ����
	public boolean find(int id){
		Node current = root;
		while(current!=null){
			//���� ���� ã�� ���� ������
			if(current.getData()==id){
				return true;
				//ã�� ���� ���� ��庸�� ������
			} else if(current.getData()>id){
				current = current.getLeft();
				//ã�� ���� ���� ��庸�� ũ��
			} else{
				current = current.getRight();
			}
		}
		return false;
	}
	//���� ����
	public boolean delete(int id){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(current.getData()!=id){
			parent = current;
			if(current.getData()>id){
				isLeftChild = true;
				current = current.getLeft();
			}else{
				isLeftChild = false;
				current = current.getRight();
			}
			if(current==null){
				return false;
			}
		}
		//Case 1: �ڽĳ�尡 ���� ���
		if(current.getLeft()==null && current.getRight()==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild==true){
				parent.setLeft(null);
			}else{
				parent.setRight(null);
			}
		}
		//Case 2 : �ϳ��� �ڽ��� ���� ���
		else if(current.getRight()==null){
			if(current==root){
				root = current.getLeft();
			}else if(isLeftChild){
				parent.setLeft(current.getLeft());
			}else{
				parent.setRight(current.getLeft());
			}
		} else if(current.getLeft()==null){
			if(current==root){
				root = current.getRight();
			}else if(isLeftChild){
				parent.setLeft(current.getRight());
			}else{
				parent.setRight(current.getRight());
			}
		}
		//Case 3 : �ΰ��� �ڽ��� ���� ���
		else if(current.getLeft()!=null && current.getRight()!=null){
			// ������ ����Ʈ���� �ּҰ��� ã��
			Node successor = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.setLeft(successor);
			}else{
				parent.setRight(successor);
			}			
			successor.setLeft(current.getLeft());
		}		
		return true;		
	}

	public Node getSuccessor(Node deleleNode){
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.getRight();
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.getLeft();
		}
		if(successsor!=deleleNode.getRight()){
			successsorParent.setLeft(successsor.getRight());
			successsor.setRight(deleleNode.getRight());
		}
		return successsor;
	}

	//���� ����
	public void insert(int id){
		Node newNode = new Node(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id < current.getData()){				
				current = current.getLeft();
				if(current==null){
					parent.setLeft(newNode);
					return;
				}
			}else{
				current = current.getRight();
				if(current==null){
					parent.setRight(newNode);
					return;
				}
			}
		}
	}
	
	public void display(Node root){
		if(root!=null){
			display(root.getLeft());
			System.out.print(" " + root.getData());
			display(root.getRight());
		}
	}

	public static void main(String[] args) {
		
		binarySearchTree b = new binarySearchTree();
		//Ʈ���� ��带 ����
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		
		System.out.println("Ʈ������ ��� : ");
		b.display(b.root);
		System.out.println("");
		System.out.println("����Ʈ������ 4�� Ž�� : " + b.find(4));
		System.out.println("����Ʈ������ 2�� ���� : " + b.delete(2));		
		b.display(b.root);
		System.out.println("\n����Ʈ������ 4�� ���� : " + b.delete(4));		
		b.display(b.root);
		System.out.println("\n����Ʈ������ 10�� ���� : " + b.delete(10));		
		b.display(b.root);
	}

}
