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

    Node rebalance (Node z) {
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
            if (node.left == null || node.right == null) {
                Node temp = null;
                if (node.left == null) temp = node.right;
                else temp = node.left;
                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node == null) return node;
        return rebalance(node);
    }

    Node find(int key) {
        Node n = root;
        while (n != null) {
            if (key < n.key) {
                n = n.left;
            } else if (key > n.key) {
                n = n.right;
            } else {
                return n;
            }
        }
        return null;
    }
}