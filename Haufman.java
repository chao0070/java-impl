import java.util.*;
import java.util.stream.*;

public class Haufman {
    static class Node {
        char c;
        int freq;
        Node left = null, right = null;
        @Override
        public String toString() {
            return c + " " + String.valueOf(freq);
        }
        public Node(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
        public Node() {
        }
    }

    static class NodeComparator implements Comparator<Node> {
        public int compare(Node n1, Node n2) {
            return (n1.freq - n2.freq);
        }
    }

    static Node createHaufManNode(PriorityQueue<Node> pq) {
        int size = pq.size();
        if (size == 1) {
            return pq.peek();
        }
        Node first, second;
        first = pq.poll();
        second = pq.poll();
        while (first != null && second != null) {
            Node temp = new Node();
            temp.left = first;
            temp.right = second;
            temp.freq = first.freq + second.freq;
            temp.c = '-';
            pq.add(temp);
            first = pq.poll();
            second = pq.poll();
        }
        return first;
    }

    static void printCode(Node n, String s) {
        if (n  == null)
            return;
        if (n.left == null && n.right == null) {
            System.out.println(n.c + " " + s);
        }
        if (n.left != null) {
            printCode(n.left, s + "0");
        }
        if (n.right != null) {
            printCode(n.right, s + "1");
        }
        return;

    }

    public static void main(String[] args) {
        // number of characters. 
        int n = 6; 
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
        int[] charfreq = { 5, 9, 12, 13, 16, 45 }; 

        PriorityQueue<Node> pq = new PriorityQueue<Node>(n, new NodeComparator());
        // IntStream.range(0, n).forEach(x -> {
        //     Node nd = new Node();
        //     nd.c = charArray[x];
        //     nd.freq = charfreq[x];
        //     pq.offer(nd);
        // });
        IntStream.range(0, n).mapToObj(x -> new Node(charArray[x], charfreq[x])).forEach(x -> pq.offer(x));
       

        // pq.stream().forEach(x -> System.out.println(x));
        Node hn = createHaufManNode(pq);
        printCode(hn, "");



  
    }

}
