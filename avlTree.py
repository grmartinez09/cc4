class TreeNode:
    def __init__(self, key):
        self.key = key
        self.height = 1
        self.left = None
        self.right = None

class AVLTree:
    def __init__(self):
        self.root = None

    def height(self, node):
        if node is None:
            return 0
        return node.height

    def update_height(self, node):
        node.height = 1 + max(self.height(node.left), self.height(node.right))

    def balance_factor(self, node):
        return self.height(node.left) - self.height(node.right)

    def rotate_left(self, z):
        y = z.right
        T2 = y.left

        y.left = z
        z.right = T2

        self.update_height(z)
        self.update_height(y)

        return y

    def rotate_right(self, y):
        x = y.left
        T2 = x.right

        x.right = y
        y.left = T2

        self.update_height(y)
        self.update_height(x)

        return x

    def insert(self, root, key):
        if root is None:
            return TreeNode(key)

        if key < root.key:
            root.left = self.insert(root.left, key)
        else:
            root.right = self.insert(root.right, key)

        self.update_height(root)

        balance = self.balance_factor(root)

        if balance > 1:
            if key < root.left.key:
                return self.rotate_right(root)
            else:
                root.left = self.rotate_left(root.left)
                return self.rotate_right(root)
        if balance < -1:
            if key > root.right.key:
                return self.rotate_left(root)
            else:
                root.right = self.rotate_right(root.right)
                return self.rotate_left(root)

        return root

    def insert_key(self, key):
        self.root = self.insert(self.root, key)

    def inorder_traversal(self, root, result):
        if root:
            self.inorder_traversal(root.left, result)
            result.append(root.key)
            self.inorder_traversal(root.right, result)

    def get_sorted_array(self):
        result = []
        self.inorder_traversal(self.root, result)
        return result

def AVL_prog():
    avl_tree = AVLTree()
    actionChoice_S = 0
    while actionChoice_S != 3:
        print("1. Insert\n2. Delete\n3. Quit")
        actionChoice_S = int(input("Enter your choice: "))
        if actionChoice_S == 1:
            item = int(input("Enter the value to insert into the AVL: "))
            avl_tree.insert_key(item)
            print("Your current AVL is: ", avl_tree.get_sorted_array())
        elif actionChoice_S == 2:
            item = int(input("Enter the value to delete from the AVL: "))
            # TODO: Implement deletion in AVLTree and call it here
            print("Deletion not implemented yet.")
        elif actionChoice_S == 3:
            print("Exiting...")
        else:
            print("Invalid choice. Please choose either '1', '2' or, '3'.")

# Call the function to run the program
AVL_prog()