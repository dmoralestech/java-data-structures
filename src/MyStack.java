import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * User: dmorales
 * Date: 7/03/14
 * Time: 1:03 PM
 */
public class MyStack<Item> implements Iterable<Item> {
    private int N;
    private Node<Item> first;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public MyStack() {
        first  = null;
        N = 0;
    }


    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }


    public void push(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Node<Item> oldFirst = first;
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }


   public String toString() {
       StringBuilder s = new StringBuilder();
       for (Item item : this) {
           s.append(item + " ");
       }
       return s.toString();
   }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        s.push("a");
        s.push("b");
        s.push("c");
        s.push("d");
        s.push("e");
    }
}
