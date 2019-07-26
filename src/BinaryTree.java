import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
    Node root;

    BinaryTree(Node root) {
        this.root = root;
    }

    public Node newNode(T data) {
        Node newNode = new Node(data);
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    //using a queue because of its FIFO nature. Whatever we visit first we discard first
    //O(n) time complexity
    void performBFS() {
        if(this.root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        //start searching through the nodes until the queue is empty
        while(!queue.isEmpty()) {
            Node currentNode = queue.peek();
            System.out.println(currentNode.getData());
            if(currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if(currentNode.right != null) {
                queue.add(currentNode.right);
            }
            queue.remove();
        }
    }

    void performDFS() {
        if(this.root == null) {
            return;
        }

        printValue(root);
    }

    //Preorder
    private void printValue(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.getData());
        printValue(node.left);

        printValue(node.right);
    }

}

class Node<T>{
    private T data;
    Node left;
    Node right;
    Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
