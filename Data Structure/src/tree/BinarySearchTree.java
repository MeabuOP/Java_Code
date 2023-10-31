package tree;

import stack.LinkedListBasedStack;
import stack.StackADT;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements TreeADT<T> {

    protected int nodeCount = 0;

    protected Node root = null;

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public boolean contains(T elem) {
        return contains(root, elem);
    }

    @Override
    public boolean add(T elem) {
        if (contains(elem)) {
            return false;
        }

        root = add(root, elem);
        nodeCount++;
        return true;
    }

    @Override
    public boolean remove(T elem) {
        if (!contains(elem)) {
            return false;
        }
        root = remove(root, elem);
        nodeCount--;
        return true;
    }

    @Override
    public Iterator<T> traverse(TreeTraverseType type) {
        return switch (type) {
            case PRE_ORDER ->
                preOrderTraverse();
            case IN_ORDER ->
                inOderTraverse();
            case POST_ORDER ->
                postOrderTraverse();
            case LEVEL_ORDER ->
                levelOrderTraverse();
            default ->
                null;
        };
    }

    private Iterator<T> levelOrderTraverse() {
        return null;
    }

    private Iterator<T> postOrderTraverse() {
        return null;
    }

    private Iterator<T> inOderTraverse() {
        final int expectedCount = nodeCount;
        StackADT<Node> stack = new LinkedListBasedStack();
        stack.push(root);

        return new Iterator<T>() {
            Node trav = root;

            @Override
            public boolean hasNext() {
                if (expectedCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                while (trav != null && trav.getLeft() != null) {
                    stack.push(trav.getLeft());
                    trav = trav.getLeft();
                }

                Node node = stack.pop();

                if (node.getRight() != null) {
                    stack.push(node.getRight());
                    trav = node.getRight();
                }
                return (T) node.getData();
            }
        };
    }

    private Iterator<T> preOrderTraverse() {
        final int expectedCount = nodeCount;
        StackADT<Node> stack = new LinkedListBasedStack();
        stack.push(root);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedCount != nodeCount) {
                    throw new ConcurrentModificationException();
                }

                Node node = stack.pop();

                if (node.getRight() != null) {
                    stack.push(node.getRight());
                }
                if (node.getLeft() != null) {
                    stack.push(node.getLeft());
                }
                return (T) node.getData();
            }
        };
    }
    // PRIVATE

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    private boolean contains(Node node, T elem) {
        if (node == null) {
            return false;
        }

        int result = elem.compareTo((T) node.getData());

        if (result < 0) {
            return contains(node.getLeft(), elem);
        } else if (result > 0) {
            return contains(node.getRight(), elem);
        } else {
            return true;
        }
    }

    private Node add(Node node, T elem) {
        if (node == null) {
            node = new Node(elem, null, null);
        } else {
            if (elem.compareTo((T) node.getData()) > 0) {
                node.setRight(add(node.getRight(), elem));
            } else {
                node.setLeft(add(node.getLeft(), elem));
            }
        }
        return node;
    }

    //Copy
    private Node remove(Node node, T elem) {
        if (node == null) {
            return node;  // Node not found, nothing to remove.
        }

        int result = elem.compareTo((T)node.getData());
        if (result > 0) {
            node.setRight(remove(node.getRight(), elem));
        } else if (result < 0) {
            node.setLeft(remove(node.getLeft(), elem));
        } else {
            // Case 1: No child
            if (node.getLeft() == null && node.getRight() == null) {
                node = null;
            }
            // Case 2: One child
            else if (node.getLeft() == null) {
                node = node.getRight();
            }
            else if (node.getRight() == null) {
                node = node.getLeft();
            }
            else {
            // Case 3: Two children
            // Nhỏ nhất nhánh phải || Lớn nhất nhánh trái
            T temp = minRight(node.getRight());
            node.setData(temp);
            node.setRight(remove(node.getRight(), temp));
            }
        }
        return node;
    }

    private T minRight(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return (T) node.getData();
    }

    private T maxLeft(Node node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return (T) node.getData();
    }
}

// Delete by merging, merge right subtree into right-most node of left subtree,return node.left to update root
/* 
public void delete(T info) {
    root = delete (root.info);
}

public TreeNode<T> delete(TreeNode<T> node, T info) {

    // if this node is null, we have reached the end of the tree
    // so the node is not in the tree.
    if (node == null) {
        return node; // or handle as required

    // if this is not the node to delete;
    // recursively call this on the node's correct child
    else if (info.compareTo(node.info) <0) {
        node.left = delete(node.left, info);
        return node;
    } else {
        node.right = delete(node.right, info);
        return node;
    }

    // if this is the node to delete:
    else if (node.info.equals(info)) {
        // to delete it, we must return a sub-tree without it.

        if (node.left == null) 
            // this node is a leaf node, or
            // node.right contains only child.
            // either way, return node.right
            return node.right;

        if (node.right == null) 
            // node.left contains only child
            return node.left;

        // else node has 2 children, so delete by merging:
        // first, find its direct predecessor:
        TreeNode<T> tmp = node.left;
        while (tmp.right != null)
            tmp = tmp.right;
        // then append the node's right sub-tree
        // to its direct predecessor:
        tmp.right = node.right;
        // lastly, replace the node by its left sub-tree:
        return node.left;
    }
}
*/