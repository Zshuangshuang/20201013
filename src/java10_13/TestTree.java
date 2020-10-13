package java10_13;

/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-13
 * Time:18:53
 **/

class Node{
    public char val;
    public Node left;
    public Node right;

    public Node(char val){
        this.val = val;
    }

}
public class TestTree {

    public static Node buildTree(){
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left =b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        g.right = h;
        c.right = f;
        return a;
    }

    public static void prevOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.val+"  ");
        prevOrder(root.left);
        prevOrder(root.right);
    }
    public static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+"  ");
        inOrder(root.right);
    }
    public static void pastOrder(Node root){
        if (root == null){
            return;
        }
        pastOrder(root.left);
        pastOrder(root.right);
        System.out.print(root.val+"  ");
    }
    public static int size(Node root){
        if (root == null){
            return 0;
        }
        return 1+size(root.left)+size(root.right);
    }
    public static int leaveSize(Node root){
        if (root == null){
            return 0;
        }
        if (root.right == null && root.left == null){
            return 1;
        }
        return leaveSize(root.left)+leaveSize(root.right);
    }
    public static int kLevelSize(Node root,int k){
        if (k < 1){
            return 0;
        }
        if (k == 1){
            return 1;
        }
        return kLevelSize(root.left,k-1)+kLevelSize(root.right,k-1);
    }
    public static Node find(Node root,char key){
        if (root == null){
            return null;
        }
        if (root.val == key){
            return root;
        }
        Node result = find(root.left,key);
        if (result != null){
            return result;
        }
        return find(root.right,key);
    }
    public static void main(String[] args) {
        Node root = buildTree();
        prevOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        pastOrder(root);
        System.out.println();
        System.out.println(leaveSize(root));
    }
}
