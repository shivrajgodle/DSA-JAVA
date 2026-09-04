package org.example.DSA.tree;

public class InOrder {
    static class TreeNode{
        char data;
        TreeNode left;
        TreeNode right;

        TreeNode(char data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void inOrderNodeTraversal(TreeNode node){
        if(node == null){
            return;
        }
        
        inOrderNodeTraversal(node.left);
        System.out.print(node.data+", ");
        inOrderNodeTraversal(node.right);
    }

    public static TreeNode createNewNode(char data){
        return new TreeNode(data);
    }

    void main(){
        TreeNode root = createNewNode('R');
        TreeNode nodeA = createNewNode('A');
        TreeNode nodeB = createNewNode('B');
        TreeNode nodeC = createNewNode('C');
        TreeNode nodeD = createNewNode('D');
        TreeNode nodeE = createNewNode('E');
        TreeNode nodeF = createNewNode('F');
        TreeNode nodeG = createNewNode('G');

        root.left = nodeA;
        root.right = nodeB;

        nodeA.left = nodeC;
        nodeA.right = nodeD;

        nodeB.left = nodeE;
        nodeB.right = nodeF;

        nodeF.left = nodeG;
        System.out.println("PreOrder Traversal:");
        inOrderNodeTraversal(root);
    }

}
