package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import linkedLists.LinkedList;
//

public class SLFLList<E> 
implements LinkedList<E>
{

	private SNode<E> first, last; 
	int length = 0; 

	public SLFLList() {
		first = last = null; 
	}


	public void addFirstNode(Node<E> nuevo) {
		((SNode<E>)nuevo).setNext(first);
		first=(SNode<E>) nuevo;
		length++; 
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		if(target.equals(last)){
			last=(SNode<E>)nuevo;
		}
		((SNode<E>) nuevo).setNext(((SNode<E>) target).getNext()); 
		((SNode<E>) target).setNext((SNode<E>) nuevo); 
		length++; 

	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		if (target.equals(first))
			this.addFirstNode(nuevo); 
		else { 
			Node<E> prevNode = getNodeBefore(target);  
			this.addNodeAfter(prevNode, nuevo); 
		}
		length++; 

	}

	public Node<E> getFirstNode() throws NodeOutOfBoundsException {
		return first;
	}

	public Node<E> getLastNode() throws NodeOutOfBoundsException {
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NodeOutOfBoundsException {
		if (last==first && last==target){
			throw new NodeOutOfBoundsException("This node do not exist. The target is the last"); 
		}
		else if (target==last)
			throw new NodeOutOfBoundsException("This node do not exist. The target is the last"); 
		else {
			SNode<E> beforet = ((SNode<E>)target).getNext(); 
			return beforet; 


		}
		//CHECK THIS

	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NodeOutOfBoundsException {
		if (last==first && last==target){
			throw new NodeOutOfBoundsException("This node do not exist. The target is the last"); 
		}
		else if (target==first) 
			throw new NodeOutOfBoundsException("This node do not exist. The target is the first");
		else { 
			SNode<E> prev = first; 
			while (prev != null && prev.getNext() != target) 
				prev = prev.getNext();  
			return prev; 
		}
	}

	public int length() {
		return length;
	}

	public void removeNode(Node<E> target) {
		if (last==first && last==target){
			last=first=null;
		}
		else if(target==first){
			first=first.getNext();
		}

		else {
			SNode<E> prev = (SNode<E>)getNodeBefore(target);
			if(target==last){
				last=prev;
			}

			prev.setNext(((SNode<E>)target).getNext());
		}
		((SNode<E>)target).setElement(null);
		((SNode<E>)target).setNext(null);	
		length--;
	}

	public Node<E> createNewNode() {
		return new SNode<E>();
	}


	///////////////////////////////////////////////////
	// private and static inner class that defines the 
	// type of node that this list implementation uses
	private static class SNode<T> implements Node<T> {
		private T element; 
		private SNode<T> next; 
		public SNode() { 
			element = null; 
			next = null; 
		}
		public SNode(T data, SNode<T> next) { 
			this.element = data; 
			this.next = next; 
		}
		public SNode(T data)  { 
			this.element = data; 
			next = null; 
		}
		public T getElement() {
			return element;
		}
		public void setElement(T data) {
			this.element = data;
		}
		public SNode<T> getNext() {
			return next;
		}
		public void setNext(SNode<T> next) {
			this.next = next;
		}
	}

}
