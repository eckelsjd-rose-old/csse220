package sll.algorithms;

import sll.ILinkedList;
import sll.IListNode;
import sll.SinglyLinkedList;

// DONE: complete sll.SinglyLinkedList first, then use it to complete these problems.
public class Algorithms {
	/**
	 * 
	 * Write a function that takes an array of integers and returns a linked
	 * list. The linked list should contain only the integers in the original
	 * list that begin with the number 1.
	 * 
	 * So arraylistOf1s({123,456,1, 21}) yields [123, 1]
	 */
	public static SinglyLinkedList arraylistOf1s(int[] integers) {
		SinglyLinkedList newList = new SinglyLinkedList();
		for (int i = 0; i < integers.length; i++) {
			String currentInteger = Integer.toString(integers[i]);
			if (currentInteger.charAt(0) == '1') {
				newList.add(integers[i]);
			}
		}
		return newList;
	}

	/**
	 * Takes a list of numbers in sorted (ascending) order and a number to add.
	 * 
	 * Adds the number in the correct place in the sorted list.
	 * 
	 * so insertIntoSorted([1,5,9],6) yields [1,5,6,9]
	 * 
	 */
	public static void insertIntoSorted(ILinkedList list, int number) {
		IListNode current = list.getFirst();
		int index = 0;
		while (current != null) {
			if (current.getElement() >= number) {
				list.insertAtIndex(index, number);
				return;
			}
			index++;
			current = current.getNext();
		}
		list.add(number);
	}

	/**
	 * Takes a linked list and removes all numbers longer than 3 digits from the
	 * list.
	 * 
	 * So removeLongNumbers([1,1000,3,99999,999]) yields [1, 3, 999]
	 */
	public static void removeLongNumbers(ILinkedList list) {
		IListNode current = list.getFirst();
		while (current != null) {
			String num = Integer.toString(current.getElement());
			if (num.length() > 3) {
				list.remove(current.getElement());
			}
			current = current.getNext();
		}
	}

	/**
	 * Returns whether the given linked list is sorted in increasing order.
	 * 
	 * So checkSorted([1,2,3]) yields true. checkSorted ([1,3,2]) yields false.
	 * checkSorted ([]) yields true.
	 */
	public static boolean checkSorted(ILinkedList list) {
		if (list.size() <= 1) {
			return true;
		}
		IListNode prev = list.getFirst();
		IListNode current = prev.getNext();
		while (current != null) {
			if (prev.getElement() > current.getElement()) {
				return false;
			}
			prev = current;
			current = current.getNext();
		}
		return true;
	}

	/**
	 * Duplicates all elements of the list.
	 * 
	 * So doubleList([1, 2, 3]) yields [1, 1, 2, 2, 3, 3].
	 */
	public static void doubleList(ILinkedList list) {
		IListNode current = list.getFirst();
		int index = 0;
		while (current != null) {
			list.insertAtIndex(index, current.getElement());
			index = index + 2;
			current = current.getNext();
		}
		return;
	}

	/**
	 * Returns whether the list represents a Fibonacci sequence.
	 * 
	 * Recall: fib(i) = fib(i-1) + fib(i-2)
	 * 
	 * [0,1] is too short to be a fibonacci sequence. [1,2,3] is a fibonacci
	 * sequence because 3 = 2 + 1. [0,1,1] is a fibonacci sequence because 1 = 1
	 * + 0. [1,4,5,9,14] is a fibonacci sequence.
	 */
	public static boolean isFibonacciSequence(ILinkedList list) {
		if (list.size() < 3) {
			return false;
		}
		IListNode prev = list.getFirst();
		IListNode current = prev.getNext();
		while (current.getNext() != null) {
			if (prev.getElement() + current.getElement() != current.getNext().getElement()) {
				return false;
			}
			prev = current;
			current = current.getNext();
		}
		return true;
	}

	/**
	 * Gets the value of the ith node.
	 * 
	 * If i==0, return the value of the given node.
	 * 
	 * If you are passed an invalid index you should throw an
	 * IndexOutOfBoundsException.
	 * 
	 */
	public static Integer recursiveGet(int index, IListNode iListNode) throws IndexOutOfBoundsException {
		if (index < 0 || iListNode == null) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			return iListNode.getElement();
		}
		return recursiveGet(index - 1, iListNode.getNext());
	}

}
