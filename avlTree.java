class Node {
    int key, height;
    Node left, right;
    Node(int d) {
        key = d;
        height = 1;
    }
}

public class avlTree {
    private Node root;

    void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    int height(Node n) {
        if (n == null) return 0;
        return n.height;
    }

    int getBalance(Node n) {
        if (n == null) return 0;
        return height(n.left) - height(n.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node t = x.right;
        x.right = y;
        y.left = t;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node t = y.left;
        y.left = x;
        x.right = t;
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.left.left) >= height(z.left.right)) {
                return rightRotate(z);
            } else {
                z.left = leftRotate(z.left);
                return rightRotate(z);
            }
        } else if (balance < -1) {
            if (height(z.right.right) >= height(z.right.left)) {
                return leftRotate(z);
            } else {
                z.right = rightRotate(z.right);
                return leftRotate(z);
            }
        }
        return z;
    }

    Node insert(Node n, int key) {
        if (n == null) return new Node(key);
        if (key < n.key) {
            n.left = insert(n.left, key);
        } else if (key > n.key) {
            n.right = insert(n.right, key);
        } else {
            return n;
        }
        return rebalance(n);
    }

    Node delete(Node node, int key) {
        if (node == null) return node;
        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            // Implement the delete logic here
            // ...
        }
        return rebalance(node);
    }

    // Other methods (e.g., search, traversal) can be added here

    public static void main(String[] args) {
        // Example usage
        avlTree tree = new avlTree();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        // ...
    }
}