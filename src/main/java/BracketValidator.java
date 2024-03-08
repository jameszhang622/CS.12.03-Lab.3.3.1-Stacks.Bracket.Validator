import java.util.Stack;

public class BracketValidator {

    // Method called checkValidParentheses that returns a boolean indicating whether a string of brackets is valid or not.
    public static boolean checkValidParentheses(String input) {
        // Obtain an array of the brackets (each element is a single bracket).
        String[] brackets = new String[input.length()];
        int j = 0;
        for(int i=0; i < input.length(); i++){
            brackets[j++] = input.substring(i, i+1);
        }
        // Create a stack.
        Stack<String> stack = new Stack<String>();

        // Iterate over the array of brackets.
        // Obtain the reversed version of bracket.
        // Check if the bracket is an opening bracket. If it is, push it onto the stack.
        // If the stack is empty or if the popped bracket is not equal to the reverse bracket of the current bracket, return false as this must mean that the input is invalid.
        // If the stack is empty after we have finished iterating over the array of brackets, then return true as this must mean that the input is valid. If the stack is not empty, this must mean that the input is invalid.

        for(int i=0; i < brackets.length; i++){
            if(isLeftBracket(brackets[i])){
                stack.push(brackets[i]);
            } else{
                if (stack.empty() || !stack.peek().equals(getReversedBracket(brackets[i]))){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }

    // Private helper method called isLeftBracket that returns a boolean value to indicate whether the bracket is a left (opening) bracket.
    private static boolean isLeftBracket(String bracket) {
        return bracket.equals("(") || bracket.equals("{") || bracket.equals("[");
    }

    // Private helper method called getReversedBracket that returns a String which is the reverse version of the bracket passed to the method.
    private static String getReversedBracket(String bracket) {
        if(bracket.equals("(")) return ")";
        if(bracket.equals(")")) return "(";
        if(bracket.equals("{")) return "}";
        if(bracket.equals("}")) return "{";
        if(bracket.equals("[")) return "]";
        if(bracket.equals("]")) return "[";
        else return null;
    }
}