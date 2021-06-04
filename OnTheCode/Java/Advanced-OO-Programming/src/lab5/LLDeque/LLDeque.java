package lab5.LLDeque;

public class LLDeque<T> {

    private class Node {
        Node prev;
        T item;
        Node next;

        Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    /**
     * @return the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * @return true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     ***************************
     * DO NOT MODIFY CODE ABOVE
     ***************************
     */


    // LAB EXERCISE 5.1 EMPTY CONSTRUCTOR

    /**
     * Creates an empty deque.
     */
    public LLDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
		size = 0;
    }


    // LAB EXERCISE 5.2 ADD TO FRONT

    /**
     * Adds an item of type T to the front of the deque.
     * @param item is a type T object added to the deque.
     */
    public void addFirst(T item) {
        Node add = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = add;
        sentinel.next = add;
        size++;
    }


    // LAB EXERCISE 5.3 PRINT ITEMS

    /**
     * Prints the items in the deque from first to last,
     * separated by a space, ended with a new line.
     */
    public void printDeque() {
        String out = "";
        Node current = sentinel;
        while (!current.next.equals(sentinel)) {
            out += current.next.item + " ";
            current = current.next;
        }
        if (!(out.length() == 0)) out = out.substring(0, out.length() - 1);

        System.out.println(out);
    }


    // LAB EXERCISE 5.4 ITERATIVE GET ITEM

    /**
     * Gets the item at the given index.
     * If no such item exists, returns null.
     * Does not mutate the deque.
     * @param index is an index where 0 is the front.
     * @return the ith item of the deque, null if it does not exist.
     */
    public T iterGet(int index) {
		if (index < 0 || index >= size) return null;
        Node result = sentinel.next;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }

		return result.item;
    }


    // EXERCISE 5.1 ADD TO BACK

    /**
     * Adds an item of type T to the back of the deque.
     * @param item is a type T object added to the deque.
     */
    public void addLast(T item) {
        Node add = new Node(sentinel.prev, item, sentinel);
		sentinel.prev.next = add;
		sentinel.prev = add;

		size++;
    }


    // EXERCISE 5.2 DELETE FRONT

    /**
     * Deletes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     * @return the first item of the deque, null if it does not exist.
     */
    public T delFirst() {
		if (sentinel.next.equals(sentinel)) return null;

        Node del = sentinel.next;
        sentinel.next = del.next;
        del.next.prev = sentinel;

		size--;

		return del.item;
    }


    // EXERCISE 5.3 DELETE BACK

    /**
     * Deletes and returns the item at the back  of the deque.
     * If no such item exists, returns null.
     * @return the last item of the deque, null if it does not exist.
     */
    public T delLast() {
		if (sentinel.prev.equals(sentinel)) return null;

        Node del = sentinel.prev;
        del.prev.next = sentinel;
        sentinel.prev = del.prev;

        size--;
		
		return del.item;
    }


    // EXERCISE 5.4 RECURSIVE GET ITEM

    /**
     * Gets the item at the given index.
     * If no such item exists, returns null.
     * Does not mutate the deque.
     * @param index is an index where 0 is the front.
     * @return the ith item of the deque, null if it does not exist.
     */
    public T recGet(int index) {
		return recGetHelper(sentinel, index);
    }

    private T recGetHelper(Node current, int index) {
        if (current.next.equals(sentinel) || index < 0) return null;
        if (index == 0) return current.next.item;
        return recGetHelper(current.next, index - 1);
    }
	

    public static void main(String[] args) {
        LLDeque<String> deque = new LLDeque<>();
        deque.addFirst("b");
        deque.addFirst("a");
        deque.printDeque();
    }

}
