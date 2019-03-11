package com.bridgelabz.AddressBook;

import java.util.Scanner;

import com.bridgelabz.AddressBook.*;

public class CustomLinkedList<T> {
	public Node1<T> head;

	/*
	 * tail of the type Node<T> is declared private to achieve encapsulation
	 */
	public Node1<T> tail;

	/**
	 * Constructos to initialize the instance variable head
	 */
	public CustomLinkedList() {
		head = null;
	}

	/**
	 * static object is created for Scanner class to avoid multiple object
	 * creations of the same class.
	 */
	static Scanner s = new Scanner(System.in);

	/**
	 * static function to read integers input from the user
	 * 
	 * @return integer values that are read
	 */
	public static int userInt() {
		return s.nextInt();
	}

	/**
	 * static function to read double input from the user
	 * 
	 * @return double values that are read
	 */
	public static double userDouble() {
		return s.nextDouble();
	}

	/**
	 * static function to read boolean input from the user
	 * 
	 * @return boolean values that are read
	 */
	public static boolean userBoolean() {
		return s.nextBoolean();
	}

	/**
	 * static function to read string input from the user
	 * 
	 * @return strings that are read
	 */
	public static String userString() {
		return s.next();
	}

	/**
	 * non-static function to check if the list is empty or not
	 * 
	 * @return true if list is empty else false
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Function to add the elements to the linked list
	 * 
	 * @param data
	 *            the element that is to be added
	 */
	public void add(T data) {
		Node1<T> nd = new Node1<T>();

		// Function call to set the data present in Node class
		// of com.bridgelabz.datastructureprograms
		nd.setData(data);

		System.out.println("Adding: " + data);
		if (isEmpty()) {
			head = nd;
			tail = nd;
		} else {

			// Function call to set the data present in Node class
			// of com.bridgelabz.datastructureprograms
			tail.setNext(nd);
			tail = nd;
		}
	}

	/**
	 * Function to search the entered element in the list
	 * 
	 * @param data
	 *            the element that is to be searched
	 * @return true if present else false
	 */
	public boolean search(T data) {
		Node1<T> temp = head;

		// Function call to get the link present in Node class
		// of com.bridgelabz.datastructureprograms
		while (temp.getNext() != null) {

			// Function call to get the data present in Node class
			// of com.bridgelabz.datastructureprograms
			if (data.equals(temp.getData())) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

	/**
	 * Function that gives the index of a specified element
	 * 
	 * @param data
	 *            the data whose index is to be found
	 * @return the index of the specified element
	 */
	public int index(T data) {
		Node1<T> curr = head;
		int count = 0;
		while (curr != null) {
			if (curr.getData().equals(data)) {
				curr.getNext();
				return count;
			}
			count++;
			curr = curr.getNext();
		}
		assert (false);
		return 0;
	}

	/**
	 * Function to remove the element of the specified index
	 * 
	 * @param index
	 *            the index of an element which is needed to be deleted
	 */
	public void remove(int index) {
		if (isEmpty())
			return;
		Node1<T> temp = head;
		if (index == 0) {
			head = temp.getNext();
			return;
		}
		for (int i = 0; temp != null && i < index - 1; i++) {
			temp = temp.getNext();
		}
		if (temp == null || temp.getNext() == null)
			return;
		Node1<T> next = temp.getNext().getNext();

		temp.setNext(next);
	}




    public void getLinkedList() {
        Node1<T> tmp = head;
        while (true) {
            if (tmp == null) {
                break;
            }
            if(tmp.getData()!=null)
            {
            System.out.print(tmp.getData()+"\t\t\t\t");
            }
            tmp = tmp.getNext();
        }
    }
	
	/**
	 * Function that returns the size of the linked list
	 * 
	 * @return
	 */
	public int size() {
		Node1<T> tnode = head;
		int len = 0;
		while (tnode != null) {
			len++;
			tnode = tnode.getNext();
		}
		return len;
	}

	/**
	 * Function that converts the list into String array
	 * 
	 * @param array
	 *            the array that is empty
	 * @return the array of strings
	 */
	public String[] convArray(String[] array) {
		Node1<T> tnode = head;
		int i = 0;
		while (tnode != null) {
			array[i] = String.valueOf(tnode.getData());
			tnode = tnode.getNext();
			i++;
		}
		return array;
	}

	/**
	 * Function to convert the array of strings to array of integers
	 * 
	 * @param arr
	 *            the array of strings that is needed to be converted
	 * @return the array of integer
	 */
	public int[] convertIntArray(String[] arr) {
		int[] arrInt = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arrInt[i] = Integer.valueOf(arr[i]);
		}
		return arrInt;
	}

	/**
	 * Function that sorts the given array in ascending order
	 * 
	 * @param array
	 *            the array of integers that is needed to be sorted
	 * @return array of integers that is sorted
	 */
	public int[] sort(int[] array) {
		int temp;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}

	/**
	 * Function that prints all the elements present in the linked list
	 */
	public void printList() {
		Node1<T> tnode = head;
		while (tnode != null) {
			System.out.print(tnode.getData() + " ");
			tnode = tnode.getNext();
		}
		
		

}

	public Object[] convertArray(CustomLinkedList<T> list, int size) {
		Node1<T> nd2 = list.head;
		Object [] str=new Object[size];
		int i=0;
		while (true) {
			if (nd2 == null) {
				
				break;
			}
			if(nd2.getData()!=null)
			{
				str[i++]=(Object) nd2.getData();
				
			}
			nd2 = nd2.getNext();
		}
		return str;
	
		
	
	}
	public T getElement(int index) {
		Node1<T> n = head;
		int count = 0;
		while(n!=null)
		{
			if(count == index)
				return n.data;
			count ++;
			n = n.next;
		}
		return null;
}
	public void delete(String companyName)
	{
		Node1<T> n = head;
		Node1<T> prev = head;
		if(n.data.equals(companyName)) {
			head = n.next;
			return;
		}
		while(n.next!=null)
		{			
			if(companyName.equals(n.data))
			{
				prev.next= n.next;
				return;
			}
			prev = n;
			n=n.next;
		}
		prev.next= null;
}

}
