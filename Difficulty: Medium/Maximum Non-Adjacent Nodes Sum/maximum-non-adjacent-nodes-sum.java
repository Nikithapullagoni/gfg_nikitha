/*
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    // Main function
    public int getMaxSum(Node root) {
        int[] result = solve(root);
        // Return max of include and exclude for root
        return Math.max(result[0], result[1]);
    }

    // Helper function returns [include, exclude]
    private int[] solve(Node node) {
        if (node == null) return new int[]{0, 0};

        int[] left = solve(node.left);
        int[] right = solve(node.right);

        // include current node
        int include = node.data + left[1] + right[1];

        // exclude current node
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{include, exclude};
    }
}
