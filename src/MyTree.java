/**
 * Created by lenskart on 24/02/2017.
 * check if a smaller tree is inside a big tree
 */
class TreeNode {

    TreeNode leftChild;
    TreeNode rightChild;
    int data;

    public TreeNode(int data) {
        this.data = data;
    }
}


public class MyTree {
    boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null)
            return true;
        return subTree(t1, t2);
    }

    private boolean subTree(TreeNode t1, TreeNode t2) {

        if (t1 == null)
            return false;
        else if (t1.data == t2.data) {
            return matchTree(t1, t2);
        } else {
            return subTree(t1.leftChild, t2) || subTree(t1.rightChild, t2);
        }
    }

    private boolean matchTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        else if (t1 == null || t2 == null)
            return false;
        else if (t1.data == t2.data) {
            return matchTree(t1.leftChild, t2.leftChild) && matchTree(t1.rightChild, t2.rightChild);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        MyTree myTree = new MyTree();
        TreeNode treeNode = new TreeNode(1);
        treeNode.leftChild = new TreeNode(2);
        treeNode.rightChild = new TreeNode(3);
        treeNode.leftChild.leftChild = new TreeNode(4);
        treeNode.leftChild.rightChild = new TreeNode(5);
        treeNode.rightChild.leftChild = new TreeNode(6);
        treeNode.rightChild.rightChild = new TreeNode(7);


        /*
         treeNode
              1
            2   3
          4  5 6 7
         */

        /*
        treeNode1
              3
            6  7
         */

        TreeNode treeNode1 = new TreeNode(3);
        treeNode1.leftChild = new TreeNode(6);
        treeNode1.rightChild = new TreeNode(7);
        boolean test = myTree.containsTree(treeNode, treeNode1);
        System.out.println("tree matched: " + test);
    }
}



