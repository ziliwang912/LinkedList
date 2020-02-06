/**
 * LinkedList Class
 * 
 * @param <E> permits all elements (including null)
 */

public class LinkedList<E> {
    private Node<E> head;

    /**
     * Constructs an empty list
     */
    public LinkedList() {
        head = null;
    }

    /**
     * @return true if this list is empty
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Adds element to the end of this list
     * @param element 
     */
    public void add(E element) {
        if (head == null) {
            head = new Node<E>(element, null);
        } else {
            Node<E> tmp = head;
            
            while (tmp.next != null) {
                tmp = tmp.next;
            }

            tmp.next = new Node<E>(element, null);
        }
    }

    /**
     * @param index
     * @return the element at the specified position in this list
     */
    public E get(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        if (tmp == null) {
            throw new IndexOutOfBoundsException();
        }

        return tmp.element;
    }

    /**
     * @param index
     * @return the element at the specified position in this list
     */
    public E remove(int index) {
        if (isEmpty() || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            E tmp = head.element;
            head = head.next;
            return tmp;
        } 

        Node<E> curr = head;
        Node<E> prev = null;

        for (int i = 0; i < index; i++) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;

        return curr.element;
 

    }

    /**
     * Removes all elements in this list
     */
    public void clear() {
        head = null;
    }

    /**
     * @return the number of elements in this list
     */
    public int size() {
        if (head == null) {
            return 0;
        } else if (head.next == null) {
            return 1;
        } else {
            int size = 1;
            Node<E> tmp = head;

            while (tmp.next != null) {
                size++;
                tmp = tmp.next;
            }

            return size;
        }
    }

    /**
     * Returns a string reprentation of this list from first to last element
     */
    public String toString() {
        StringBuffer result = new StringBuffer();
        Node<E> tmp = head;
        while (tmp != null) {
            result.append(tmp.element + " ");
            tmp = tmp.next;
        } 
        return result.toString();
    }

    /**
     * Node Class
     * 
     * @param <E> permits all elements (including null)
     */
    private static class Node<E> {
        private E element;
        private Node<E> next;
        
        /**
         * Constructs a node with 
         * @param element
         * @param next
         */
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        } 
    }

	public static void main(String args[]) {      
        LinkedList<Integer> myList = new LinkedList<>();
        System.out.println(myList.isEmpty());   // true
        myList.add(100);
        System.out.println(myList.toString());
        System.out.println("Size = " + myList.size());  
        myList.remove(0);
        myList.add(-23);
        myList.add(17);
        myList.add(100);
        System.out.println("myList: " + myList.toString());
        System.out.println("Size = " + myList.size());  
        myList.remove(1);
        System.out.println("myList: " + myList.toString());
        System.out.println("Size = " + myList.size());  
        myList.remove(0);
        myList.remove(0); 
        System.out.println("Size = " + myList.size()); 
        /*
        System.out.println("Size = " + myList.size()); 
        myList.remove(0);
        System.out.println(myList.isEmpty());   // true
        myList.add(-23);
        myList.add(17);
        myList.add(100);
        System.out.println("Size = " + myList.size());      // 3
        System.out.println("myList: " + myList.toString());  // -23 17 100
        
        myList.remove();
        myList.remove();
        System.out.println(myList.size());      // 1
        System.out.println(myList.toString());  // 100
        */ 
	}
}

