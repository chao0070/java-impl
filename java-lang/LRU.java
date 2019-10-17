import java.io.*;
import java.util.*;
import java.lang.*;

class Node<T> {
	T t;
	Node<T> next;
	Node<T> prev;

	public Node(T t) {
		this.t = t;
		this.next = null;
		this.prev = null;
	}
}

// class LinkedList<T> {
// 	Node<T> head;
// 	Node<T> tail;

// 	public LinkedList() {
// 		this.head = null;
// 		this.tail = null;
// 	}

// 	public void add(T t) {
// 		Node<T> n = new Node<T>(t);
// 		if (this.tail == null) {
// 			this.tail = n;
// 			if (this.head == null) {
// 				this.head = n;
// 			}
// 		} else {
// 			Node<T> temp = this.tail;
// 			temp.next = n;
// 			n.prev = temp;
// 			this.tail = n;
// 		}
// 		return;
// 	}

// 	public T remove() {
// 		if (head == null) {
// 			return null;
// 		} else {
// 			Node<T> temp = head;
// 			if (head.next == null) {
// 				head = null;
// 				tail = null;
// 			} else {
// 				head = head.next;
// 				head.prev = null;
// 			}
// 			return temp.t;
// 		}

// 	}

// 	public boolean isEmpty() {
// 		return (head == null && tail == null);
// 	}
// }

class LRUCache<K, V> {
	Map<K, Node<K, V>> cacheMap;
	Node<K, V> head;
	Node<K, V> tail;
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cacheMap = new HashMap<K, Node<K, V>>();
	}

	public V get(K k) {
		Node<K, V> n = cacheMap.get(k);
		if (n != null) {
			remove(n);
			addHead(n);
			return n.v;
		}
		return null;
	}

	public void put(K k, V v) {
		Node<K, V> n = cacheMap.get(k);
		if (n != null) {
			remove(n);
			n.v = v;
		} else {
			if (cacheMap.size() == capacity) {
				cacheMap.remove(tail.k);
				removeTail();
			}
			n = new Node(k, v);
			cacheMap.put(k, n);
		}
		addHead(n);
	}

	private void remove(Node<K, V> n) {
		Node<K,V> prev, next;
		prev = n.prev;
		next = n.next;

		n.prev = null;
		n.next = null;

		if (prev == null && next == null) {
			head = null;
			tail = null;
			return;
		}
		if (prev != null && next != null) {
			prev.next = next;
			next.prev = prev;
			return;
		}
		if (prev != null) {
			tail = prev;
			prev.next = null;
			return;
		}
		if (next != null) {
			head = next;
			next.prev = null;
			return;
		}
	}

	private void addHead(Node<K, V> n) {
		if (head == null) {
			head = n;
			tail = n;
		} else {
			n.next = head;
			head.prev = n;
			head = n;
		}
	}

	private void removeTail() {
		if (tail != null) {
			Node<K, V> temp = tail;
			tail = tail.prev;
			if (tail == null) {
				head = null;
				return;
			}
			tail.next = null;
		}
	}

	class Node<K, V> {
		K k;
		V v;
		Node<K, V> next;
		Node<K, V> prev;

		public Node(K k, V v) {
			this.k = k;
			this.v = v;
			this.next = null;
			this.prev = null;
		}
	}

}

public class LRU {


	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();

		ll.add("This");
		ll.add("is");
		ll.add("Sparta");

		System.out.println(ll.remove());
		System.out.println(ll.remove());
		System.out.println(ll.remove());

		if (ll.isEmpty()) {
			System.out.println("Empty");
		}
	}

}