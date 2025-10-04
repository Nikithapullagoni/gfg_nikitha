import java.util.*;

class Solution {
    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        helper(s, target, 0, 0, 0, "", res);
        Collections.sort(res); // GFG expects lexicographical order
        return res;
    }

    private void helper(String s, int target, int index, long currVal, long lastOperand, String expr, ArrayList<String> res) {
        // If we've reached the end of the string
        if (index == s.length()) {
            if (currVal == target) res.add(expr);
            return;
        }

        // Try all possible partitions
        for (int i = index; i < s.length(); i++) {
            // Skip numbers with leading zeros
            if (i != index && s.charAt(index) == '0') break;

            String part = s.substring(index, i + 1);
            long currNum = Long.parseLong(part);

            // First number: start expression directly
            if (index == 0) {
                helper(s, target, i + 1, currNum, currNum, part, res);
            } else {
                // Addition
                helper(s, target, i + 1, currVal + currNum, currNum, expr + "+" + part, res);
                // Subtraction
                helper(s, target, i + 1, currVal - currNum, -currNum, expr + "-" + part, res);
                // Multiplication — handle operator precedence
                helper(s, target, i + 1, currVal - lastOperand + lastOperand * currNum, lastOperand * currNum, expr + "*" + part, res);
            }
        }
    }
}
