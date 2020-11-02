package project3GIVE_TO_STUDENTS;

import java.io.Serializable;
import java.util.Random;

public class MyDoubleWithOutTailLinkedList implements Serializable {

	private DNode top;

	public MyDoubleWithOutTailLinkedList() {
		top = null;
	}

	// This method has been provided and you are not permitted to modify
	public int size() {
		if (top == null)
			return 0;

		int total = 0;
		DNode temp = top;
		while (temp != null) {
			total++;
			temp = temp.getNext();
		}

		int totalBack = 0;
		temp = top;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		while (temp != null) {
			totalBack++;
			temp = temp.getPrev();
		}

		if (total != totalBack) {
			throw new RuntimeException("next links " + total + " do not match prev links " + totalBack);
		}

		return total;

	}

	// This method has been provided and you are not permitted to modify
	public void clear () {
		Random rand = new Random();
		while (size() > 0) {
			int number = rand.nextInt(size());
			remove(number);
		}
	}

	/******************************************************************
	 *
	 * Your task is to complete this method.  Have the following
	 * ordering:
	 * Sort by Games first (ordered by dueDate), then by Consoles second
	 * (ordered by dueDate).
	 * Once you have Task 2 completed, sort by the renter's name if the
	 * dueDates are equal to complete Task 3.
	 *
	 */
	public void add(Rental s) {
		DNode temp = top;

		// no list
		if (top == null) {
			top = new DNode(s, null,null);
			return;
		}

		// s is a Game, and s goes on top
		if (s instanceof Game && top.getData().getDueBack().after(s.dueBack)) {
			top = new DNode(s, top, null);
			top.getNext().setPrev(top);
			return;
		}

		// TODO: More code goes here.

		return;
	}

	/******************************************************************
	 *
	 * Your task is to complete this method.
	 */
	public Rental remove(int index) {
		// TODO: More code goes here.

		return null;
	}

	/******************************************************************
	 *
	 * Your task is to complete this method.
	 */
	public Rental get(int index) {
		// TODO: More code goes here.

		if (top == null)
			return null;

		return top.getData();
	}

	public void display() {
		DNode temp = top;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}

	public String toString() {
		return "DLL {" +
				"top=" + top +
				", size=" + size() +
				'}';
	}

}