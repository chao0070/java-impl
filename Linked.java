
public class Linked<T> {
    Node <T> head;
    class Node<T> {
        T obj;
        Node<T> next;
        public Node(T obj) {
            this.obj = obj;
            this.next = null;
        }
    }

    public void push(T new_data) {
        Node<T> new_node = new Node<>(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void append(T new_data) {
        Node<T> new_node = new Node<>(new_data);
        new_node = null;
        if (head == null) {
            head = new_node;
            return;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new_node;
    }

    public void printList() {
        Node tNode = head;
        System.out.print("[ ");
        while (tNode != null) {
            System.out.print(tNode.obj);
            System.out.print(", ");
            tNode = tNode.next;
        }
        System.out.print(" ]\n");
    } 

    public static void main(String[] args) {
        Linked<Integer> l = new Linked<>();

        l.push(10);
        l.push(20);

        l.printList();
    }
}