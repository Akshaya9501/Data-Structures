import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    class Node {
        int data;
        Node leftNode;
        Node rightNode;
    }

    public Node createNode(int val) {
        Node n = new Node();
        n.data = val;
        n.rightNode = null;
        n.leftNode = null;
        return n;
    }

    Node n;

    public Node insert(Node n, int val) {
        if (n == null) {
            return createNode(val);
        }
        if (val < n.data) {
            n.leftNode = insert(n.leftNode, val);
        } else if (val > n.data) {
            n.rightNode = insert(n.rightNode, val);
        }
        return n;
    }

    public Node delete(Node n, int val) {
        if (n == null) {
            return null;
        } else if (val < n.data) {
            n.leftNode = delete(n.leftNode, val);
        } else if (val > n.data) {
            n.rightNode = delete(n.rightNode, val);
        } else {
            if (n.leftNode == null || n.rightNode == null) {
                Node temp = null;
                temp = n.leftNode == null ? n.rightNode : n.leftNode;
                if (temp == null) {
                    return null;
                } else {
                    return temp;
                }
            } else {
                Node successor = getSuccessor(n);
                n.data = successor.data;
                n.rightNode = delete(n.rightNode, n.data);
                return n;
            }
        }
        return n;
    }

    public Node getSuccessor(Node n) {
        if (n == null) {
            return null;
        }
        Node temp = n.rightNode;
        while (temp != null) {
            temp = temp.leftNode;
        }
        return temp;
    }

    public void inorder(Node n) {
        if (n == null) {
            return;
        }
        inorder(n.leftNode);
        System.out.println(n.data);
        inorder(n.rightNode);
    }

    public void preorder(Node n) {
        if (n == null) {
            return;
        }
        System.out.println(n.data);
        preorder(n.leftNode);
        preorder(n.rightNode);
    }

    public void postorder(Node n) {
        if (n == null) {
            return;
        }
        postorder(n.leftNode);
        postorder(n.rightNode);
        System.out.println(n.data);
    }

    public boolean ifPresent(Node n, int val) {
        if (n == null) {
            return false;
        }
        boolean ifpresent = false;
        if (val < n.data) {
            n = n.leftNode;
        } else if (val > n.data) {
            n = n.rightNode;
        } else {
            ifpresent = true;
        }
        return ifpresent;
    }

    public Node getParent(Node n, int val) {
        if (n == null) {
            return null;
        }
        Node getParentNode = null;
        while (n != null) {
            if (val < n.data) {
                getParentNode = n;
                n = n.rightNode;
            } else if (val > n.data) {
                getParentNode = n;
                n = n.leftNode;
            } else {
                break;
            }
        }
        return getParentNode;
    }

    public Node getSibling(Node n, int val) {
        if (n == null || n.data == val) {
            return null;
        }
        Node getParent = null;
        while (n != null) {
            if (val < n.data) {
                getParent = n;
                n = n.leftNode;
            } else if (val > n.data) {
                getParent = n;
                n = n.rightNode;
            } else {
                break;
            }
        }
        if (getParent.leftNode != null && val == getParent.leftNode.data) {
            return getParent.rightNode;
        } else if (getParent.rightNode != null && val == getParent.rightNode.data) {
            return getParent.leftNode;
        }
        return null;
    }

    public int getMin(Node n) {
        if (n == null) {
            System.out.println("Tree is empty");
            return -1;
        }
        while (n.leftNode != null) {
            n = n.leftNode;
        }
        return n.data;
    }

    public int getMax(Node n) {
        if (n == null) {
            System.out.println("Tree is empty");
            return -1;
        }
        while (n.rightNode != null) {
            n = n.rightNode;
        }
        return n.data;
    }

    public boolean ifSumExists(Node n, int sum) {
        List<Integer> list = new ArrayList<>();
        inorder(n, list);
        return checkIfpairExistsUtil(sum, list);
    }

    public void inorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.leftNode, list);
        list.add(node.data);
        inorder(node.rightNode, list);
    }

    public boolean checkIfpairExistsUtil(int sum, List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int currentSum = list.get(start) + list.get(end);
            if (currentSum == sum) {
                return true;
            } else if (currentSum < sum) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

    static int count = 0;

    public Node kthSmallest(Node n, int val) {
        if (n == null) {
            return null;
        }
        Node left = kthSmallest(n.leftNode, val);

        if (left != null) {
            return left;
        }
        count++;
        if (count == val) {
            return n;
        }
        return kthSmallest(n.rightNode, val);
    }

    static int count1 = 0;

    public Node kthLargest(Node n, int k) {
        if (n == null) {
            return null;
        }
        Node kthLargest = kthLargest(n.rightNode, k);
        if (kthLargest != null) {
            return kthLargest;
        }
        count1++;
        if (count1 == k) {
            return n;
        }

        return kthLargest(n.leftNode, k);
    }

    public boolean checkIfTwoBSTHasSameElements(Node n1, Node n2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(n1, list1);
        inorder(n2, list2);
        return (list1.equals(list2));
    }

    public static void main(String[] args) {
        BinarySearchTree bs = new BinarySearchTree();
        Node n = null;
        n = bs.insert(n, 2);

        n = bs.insert(n, 6);

        n = bs.insert(n, 7);

        n = bs.insert(n, 8);
        n = bs.insert(n, 15);
        n = bs.insert(n, 20);
        Node n1 = null;
        n1 = bs.insert(n1, 15);
        n1=bs.insert(n1,5);
        //bs.delete(n, 5);
        bs.preorder(n);

        bs.postorder(n);
        bs.inorder(n);
        System.out.println(bs.ifPresent(n, 8));
        System.out.println("Parent" + bs.getParent(n, 5));
        Node sibling = bs.getSibling(n, 8);
        if (sibling == null) {
            System.out.println("No Sibling");
        } else {
            System.out.println("Sibling is" + sibling);
        }
        System.out.println("Minimum node is" + bs.getMin(n));
        System.out.println("Maximum node is" + bs.getMax(n));
        Node kthSmallest = bs.kthSmallest(n, 3);
        if (kthSmallest == null) {
            System.out.println("Tree is empty");
        } else {
            System.out.println(kthSmallest.data);
        }
        Node kthLargest = bs.kthLargest(n, 3);
        if (kthLargest == null) {
            System.out.println("Tree is empty");
        } else {
            System.out.println(kthLargest.data);
        }
        if (bs.checkIfTwoBSTHasSameElements(n, n1)) {
            System.out.println("Two trees have same elements");
        } else {
            System.out.println("Two trees does not have same elements");
        }
    }
}
