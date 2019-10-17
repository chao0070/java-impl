import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;

class TreeNode implements Iterable<TreeNode> {
	int value;
	TreeNode left;
	TreeNode right;
	public TreeNode(int value) {
		this.value = value;
	}

	@Override
	public BSTIterator iterator() {
		return new BSTIterator(this);
	}
}

class BSTIterator implements Iterator<TreeNode> {
	Stack<TreeNode> st;

	public BSTIterator(TreeNode root) {
		st = new Stack<TreeNode>();
		TreeNode curr = root;
		while (curr !=  null) {
			st.push(curr);
			curr = curr.left;
		}
	}

	public boolean hasNext() {
		return !st.empty();
	}

	public TreeNode next() {
		TreeNode curr = st.pop();
		TreeNode temp = curr.right;
		while(temp != null) {
			st.push(temp);
			temp = temp.left;
		}
		return curr;
	}

	public void remove() {
		return;
	}
}

class TreeIterator implements Iterator<TreeNode> {
	TreeNode curr;
	Stack<TreeNode> st;

	public TreeIterator(TreeNode root) {
		st = new Stack<TreeNode>();
		st.push(root);
	}

	public boolean hasNext() {
		return !st.empty();
	}

	public TreeNode next() {
		if (st.empty()) {
			return null;
		}
		curr = st.pop();
		TreeNode temp = curr.right;
		if (temp != null) {
			st.push(temp);
		}
		temp = curr.left;
		if (temp != null) {
			st.push(temp);
		}
		return curr;
	}

	public void remove() {

	}
}


public class TreeTest {
	public static Collection<Integer> preOrder(TreeNode root) {
		Collection<Integer> traversal = new ArrayList<Integer>();
		if (root == null) {
			return traversal;
		}

		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);

		while (!s.isEmpty()) {
			TreeNode top = s.peek();
			s.pop();

			traversal.add(top.value);
			if (top.right != null) {
				s.push(top.right);
			}

			if (top.left != null) {
				s.push(top.left);
			}
		}
		return traversal;
	}

	public static Collection<Integer> inOrder(TreeNode root) {
		Collection<Integer> traversal = new ArrayList<Integer> ();
		if (root == null) {
			return traversal;
		}

		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null) {
			s.push(p);
			p = p.left;
		}

		while (!s.isEmpty()) {
			p = s.pop();
			traversal.add(p.value);
			p = p.right;
			while (p != null) {
				s.push(p);
				p = p.left;
			}
		}

		return traversal;
	}

	public static LinkedList<LinkedList<Integer>> levelOrder(TreeNode root) {
		LinkedList<LinkedList<Integer>> ll = new LinkedList<LinkedList<Integer>>();
		if (root == null) {
			return ll;
		}

		LinkedList<TreeNode> currLevel = new LinkedList<TreeNode>();
		LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();

		LinkedList<Integer> nodeVals = new LinkedList<>();
		currLevel.offer(root);

		while (!currLevel.isEmpty()) {
			TreeNode curr = currLevel.poll();
			nodeVals.offer(curr.value);
			if (curr.left != null) {
				nextLevel.add(curr.left);
			}
			if (curr.right != null) {
				nextLevel.add(curr.right);
			}
			if (currLevel.isEmpty()) {
				LinkedList<TreeNode> temp = currLevel;
				currLevel = nextLevel;
				nextLevel = temp;

				ll.add(nodeVals);
				nodeVals = new LinkedList<Integer>();
			}
		}

		return ll;
	}

	public static LinkedList<LinkedList<Integer>> zigzag(TreeNode root) {
		LinkedList<LinkedList<Integer>> ll = new LinkedList<LinkedList<Integer>>();
		if (root == null) {
			return ll;
		}

		LinkedList<TreeNode> currLevel = new LinkedList<TreeNode>();
		LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();

		LinkedList<Integer> nodeVals = new LinkedList<>();
		currLevel.offer(root);

		while (!currLevel.isEmpty()) {
			TreeNode curr = currLevel.poll();
			nodeVals.offer(curr.value);
			if (curr.left != null) {
				nextLevel.add(curr.left);
			}
			if (curr.right != null) {
				nextLevel.add(curr.right);
			}
			if (currLevel.isEmpty()) {
				LinkedList<TreeNode> temp = currLevel;
				currLevel = nextLevel;
				nextLevel = temp;

				ll.add(nodeVals);
				nodeVals = new LinkedList<Integer>();
			}
		}

		return ll;
	}



	/*
			1
		2		3
	4		5		6

		      	    1
		  2    		     3
	     4       5 		 6       7
	8	9 10   11     12   13 14    15



	*/


	public static void main(String[] args) {
		// TreeNode root = new TreeNode(4);
		// root.left = new TreeNode(2);
		// root.right = new TreeNode(5);
		// root.left.left = new TreeNode(1);
		// root.left.right = new TreeNode(3);
		// root.right.right = new TreeNode(6);

		// // Collection<Integer> c = inOrder(root);
		// // c.stream().forEach(x -> System.out.println(x));

		// // LinkedList<LinkedList<Integer>> lt = levelOrder(root);
		// // lt.stream().forEach(x -> {
		// // 	x.stream().forEach(y -> System.out.print(y + " "));
		// // 	System.out.println("");
		// // });

		// BSTIterator ti = root.iterator();
		// while (ti.hasNext()) {
		// 	TreeNode tn = ti.next();
		// 	System.out.println(tn.value);
		// }

		PriorityQueue<Node> pq = new PriorityQueue<>();
		Node n1 = new Node(1);
		n1.val2 = 2;

		pq.add(n1);

		Node n2 = new Node(1);
		n2.val2 = 3;

		System.out.println(pq.remove(n2));
	}
}

class Node {
	int val1;
	int val2;

	public Node(int v1) {
		val1 = v1;
	}

	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || o.getClass() != this.getClass())  return false;
		Node n = (Node) o;
		if (n.val1 != this.val1) return false;
		return true;
	}
}