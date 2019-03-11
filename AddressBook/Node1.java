package com.bridgelabz.AddressBook;

public class Node1<T>implements Comparable<T> {
	public T data;
	  public Node1<T> next;
     public  Node1<T> prev;
	
	/**
	 * Constructors to initialize the instance variables
	 */
	public Node1(){
		next=null;
		data=null;
	}
	
	/**
	 * Parameterized Constructors to initialize instance and 
	 * local variables
	 * 
	 * @param data the data to store in the node of a linked list
	 * @param next the address of the next node
	 */
	public Node1(T data, Node1<T> next){
		this.data=data;
		this.next=next;
	}
	
	/**
	 * Parameterized Constructors to initialise the data
	 * 
	 * @param data the data to store in the node of a linked list 
	 */
	public Node1(T data){
		this.data=data;
	}
	
	/**
	 * Getter method to get the data
	 * 
	 * @return
	 */
	public T getData(){
		return data;
	}
	
	/**
	 * Setter method to set the data
	 * 
	 * @param data the data to be set
	 */
	public void setData(T data){
		this.data=data;
	}
	
	/**
	 * Getter method to get the link of the next node
	 * 
	 * @return the link of the next node
	 */
	public Node1<T> getNext(){
		return next;
	}
	
	/**
	 * Setter Method to set the link of the next node
	 * 
	 * @param next the link that has the address of the next node
	 */
	public void setNext(Node1<T> next){
		this.next=next;
	}
	
	
	/**
	 * Getter Method to get the address of the previous node
	 * 
	 * @return the address of the previous node
	 */
	public Node1<T> getPrev(){
		return prev;
	}
	
	/**
	 * Setter Method to get the address of the previous node
	 * 
	 * @return the address of the previous node
	 */
	public void setPrev(Node1<T> prev){
		this.prev=prev;
	}
	
	/**
	 * Overriding the compareTo() method of the Comparable 
	 * interface 
	 * 
	 * @param object the instance of a class that needs to be compared 
	 * 		  with the variables.
	 *@return 0 if equal else 1 
	 */
	@Override
	public int compareTo(T obj) {
		if(obj ==this.data){
			return 0;
		} else {
			return 1;
		}
}

}
