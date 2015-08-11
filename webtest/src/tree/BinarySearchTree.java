package tree;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
	private class BinaryNode<AnyType> {
		AnyType data;
		BinaryNode<AnyType> left ;
		BinaryNode<AnyType> right;
		public BinaryNode(AnyType data){
			this(data,null,null);
		}
		public BinaryNode(AnyType data,BinaryNode<AnyType> left,BinaryNode<AnyType> right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	BinaryNode<AnyType> root;
	
	public BinarySearchTree(){
		root = null;
	}
	//make the tree empty
	public void makeEmpty(){
		root = null;
	}
	//return the boolean value is the tree empty
	public boolean isEmpty(){
		return root == null;
	}
	
	public boolean contains(AnyType x){
		return contains(x,root);
	}
	
	public AnyType findMin(){
		if(isEmpty()){
			throw new RuntimeException("树为空");
		}
		return findMin(root).data;
	}
	
	public AnyType findMax(){
		if(isEmpty()){
			throw new RuntimeException("树为空");
		}
		return findMax(root).data;
	}
	
	public void insert(AnyType x){
		root = insert(x,root);
	}
	
	public void remove(AnyType x){
		root = remove(x,root);
	}
	
	public void printTree(){
		
	}
	
	
	
	
	
	
	
	
	private BinaryNode<AnyType> remove(AnyType x,BinaryNode<AnyType> t) {
		if(t == null){
			return t;
		}
		int compareResult = x.compareTo(t.data);
		if(compareResult < 0){
			t.left = remove(x,t.left);
		}else if(compareResult > 0){
			t.right = remove(x,t.right);
		}else if(t.left != null && t.right != null){//two childern
			t.data = findMin(t.right).data;
			t.right = remove(t.data,t.right);
		}else{//one child
			t = (t.left == null	) ? t.left : t.right;
		}
		return t;
	}
	private BinaryNode<AnyType> insert(AnyType x,BinaryNode<AnyType> t) {
		if(t == null){
			return new BinaryNode<AnyType>(x);
		}
		int compareResult = x.compareTo(t.data);
		if(compareResult < 0){
			t.left = insert(x,t.left);
		}else if(compareResult > 0){
			t.right = insert(x,t.right);
		}else{
			//do nothing
		}
		return t;
	}
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
		if(t == null){
			return null;
		}else if(t.right == null){
			return t;
		}
		return findMax(t.right);
	}
	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
		if(t == null){
			return null;
		}else if(t.left == null){
			return t;
		}
		return findMin(t.left);
	}
	private boolean contains(AnyType x, BinaryNode<AnyType> t) {
		if(t == null){
			return false;
		}
		int compareResult = x.compareTo(t.data);
		if(compareResult < 0){
			return contains(x,t.left);
		}
		else if(compareResult > 0){
			return contains(x,t.right);
		}
		else{
			return true;
		}
	}
}
