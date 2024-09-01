package Tree;
import java.util.*;
public class InPrePosLevelOrderTraversal {
static class Node 
{
    int data;
    Node right;
    Node left;
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
static class BinarySearchTree
{
    static Node root = null;
    void create(int num)
    {
        Node newnode = new Node(num);
        if(root == null)
            root = newnode;
        else 
        {
            Node tptr = null;
            Node temp = null;
            for(tptr = root ; tptr != null ; temp = tptr , tptr = (num > tptr.data)?tptr.right:tptr.left);
            if(temp.data > num)
                temp.left = newnode;
            else 
                temp.right = newnode;
        }
    }
    void inorder(Node tptr)
    {
        if(tptr != null)
        {
            inorder(tptr.left);
            System.out.print(tptr.data+" ");
            inorder(tptr.right);
        }
    }
    void preorder(Node tptr)
    {
        if(tptr != null)
        {
          
            preorder(tptr.left);
            preorder(tptr.right);
            System.out.print(tptr.data+" ");
        }
    }
    void postorder(Node tptr)
    {
        if(tptr != null)
        {
            System.out.print(tptr.data+" ");
            postorder(tptr.left);
            postorder(tptr.right);
           
        }
    }
    int find_height(Node tptr)
    {
        if(tptr == null)
            return 0;
        else 
        {
            int left_height = find_height(tptr.left);
            int right_height = find_height(tptr.right);
            if(left_height > right_height)
                return left_height + 1;
            else 
                return right_height + 1;
        }
        // return Math.max(find_height(tptr.left) , find_height(tptr.right)) + 1;
    }
    void levelorder(Node tptr,int level)
    {
        if(tptr == null)
            return;
        if(level == 1)
            System.out.print(tptr.data+" ");
        else 
        {
            levelorder(tptr.left, level-1);
            levelorder(tptr.right, level-1);
        }
    }
    void LevelOrderTraversal(Node tptr)
    {
        ArrayList<Node> ref = new ArrayList<>();
        int front = -1;
        int rear = -1;
        while(front < ref.size())
        {
            if(rear == -1)
            {
                ref.add(tptr);
                System.out.print(tptr.data+" ");
                front++;
                rear++;
            }
            else 
            {
                if(ref.get(front).left != null)
                {
                    ref.add(ref.get(front).left);
                    rear++;
                    System.out.print(ref.get(rear).data+" ");
                }
                if(ref.get(front).right != null)
                {
                    ref.add(ref.get(front).right);
                    rear++;
                    System.out.print(ref.get(rear).data+" ");
                }
                front++;
            }
        }
    }
    void display()
    {
        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        int height = find_height(root);
        System.out.println(height);
        for(int level = 1 ; level <= height ; level++)
            levelorder(root,level);
        System.out.println();
        LevelOrderTraversal(root);
    }
}
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        while(true)
        {
            int num = input.nextInt();
            if(num == -1) break;
            tree.create(num);
        }
        tree.display();
        input.close();
    }
}


//5 8 9 3 7 1 4 2 6 -1