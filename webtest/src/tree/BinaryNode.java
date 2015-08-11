package tree;

public class BinaryNode<T extends Comparable<? extends T>> {
	T data;
	BinaryNode<T> left ;
	BinaryNode<T> right;
	public BinaryNode(T data){
		this(data,null,null);
	}
	public BinaryNode(T data,BinaryNode<T> left,BinaryNode<T> right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
