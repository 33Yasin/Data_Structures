public class BinarySearchTree {


    private TreeNode root;

    public BinarySearchTree(){
        root = null;
    }

    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    private TreeNode insertRecursive(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }

        if(val < root.val)
            root.left = insertRecursive(root.left, val);
        else if(val > root.val)
            root.right = insertRecursive(root.right, val);
        return root;
    }

    public boolean search(int val){
        return searchRecursive(root, val);
    }

    private boolean searchRecursive(TreeNode root, int val) {
        if(root == null)
            return false;

        if(root.val == val)
            return true;

        if(val < root.val)
            return searchRecursive(root.left, val);
        else
            return  searchRecursive(root.right, val);
    }


    public void inorder(){
        inorderRecursive(root);
    }

    private void inorderRecursive(TreeNode root){
        if(root != null) {
            inorderRecursive(root.left);
            System.out.print(root.val + " ");
            inorderRecursive(root.right);
        }
    }


    public void preorder(){
        preorderRecursive(root);
    }

    private void preorderRecursive(TreeNode root) {
        if(root != null) {
            System.out.print(root.val + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }

    public void postorder(){
        postorderRecursive(root);
    }

    private void postorderRecursive(TreeNode root) {
        if(root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.val + " ");
        }
    }


    class TreeNode{
        int val;
        TreeNode left,right;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder traversal:");
        bst.inorder();
        System.out.println("\nPreorder traversal:");
        bst.preorder();
        System.out.println("\nPostorder traversal:");
        bst.postorder();

        int searchKey = 25;
        System.out.println("\nSearch for " + searchKey + ": " + (bst.search(searchKey) ? "Found" : "Not found"));
    }

}
