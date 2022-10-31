import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Expression extends BinaryTree {
    private static final String operators = "+-*/^";
    private static final int[] priority = {3, 3, 5, 5, 7};

    public Expression(Expression e) {
        root = copy(e.root);
    }

    public Expression(List<String> infix) {
        List<String> postfix = infix2Postfix(infix);
        Stack<Node> s = new Stack<>();

        for (int i = 0; i < postfix.size(); i++) {
            String token = postfix.get(i);

            if (!isOperator(token)) {
                s.push(new Node(token, null, null));
            } else {
                Node right = s.pop();
                Node left = s.pop();
                s.push(new Node(token, left, right));
            }
        }

        root = s.pop();
    }

    public static List<String> infix2Postfix(List<String> infix) {
        List<String> postfix = new ArrayList<String>(infix.size());
        Stack<String> s = new Stack<>();
        for (int i = 0; i < infix.size(); ++i) {
            String token = (String) infix.get(i);
            if (!isOperator(token)) {
                postfix.add(token);
            } else {
                int p = priority(token);
                while (!s.isEmpty() && priority((String) s.peek()) >= p) {
                    postfix.add(s.pop());
                }
                s.push(token);
            }
        }
        while (!s.isEmpty()) postfix.add(s.pop());
        return postfix;
    }

    private static boolean isOperator(String x) {
        return operators.contains(x);
    }

    private static int priority(String x) {
        return priority[operators.indexOf(x)];
    }
}
