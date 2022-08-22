import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

public class PostfixRecord {

    public static void main(String[] args) {
        String infixString = "(6+10-4)^2/(1+1*2)+1";
        String postfixString = inPostfixRecord(infixString);
        System.out.println("постфиксная запись:" + postfixString);
        System.out.println("результат = " + evalPostfixRecord(postfixString));
    }

    public static String inPostfixRecord(String expression) {

        HashMap<Character, Integer> priority = new HashMap<>(); // операторы и их приоритет
        priority.put('+', 3);
        priority.put('-', 3);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('^', 1);

        Deque<Character> stack = new ArrayDeque<>(); // стек для операторов

        StringBuilder postfix = new StringBuilder(); // постф.запись.

        for (char item : expression.toCharArray()) {

            if (Character.isDigit(item)) {
                postfix.append(item);
            }
            if (item == '(') {
                stack.add(item);
            }
            if (item == ')') {
                while (stack.getLast() != '(') {
                    postfix.append(' ');
                    postfix.append(stack.pollLast());
                }
                stack.pollLast();
            }
            if (priority.containsKey(item)) {
                while ((!stack.isEmpty()) && (priority.getOrDefault(stack.getLast(), 4) <= priority.get(item))) {
                    postfix.append(' ');
                    postfix.append(stack.pollLast());
                }
                stack.add(item);
                postfix.append(' ');
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(' ');
            postfix.append(stack.pollLast());
        }
        return postfix.toString();
    }

    public static int evalPostfixRecord(String postfix) {
        String[] tokens = postfix.split(" ");

        HashSet<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        operators.add("^");
        int currRes = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (String item : tokens) {
            if (operators.contains(item)) {
                int operandSecond = stack.pollLast();
                int operandFirst = stack.pollLast();
                currRes = calculer(operandFirst, operandSecond, item);
                stack.add(currRes);
            } else {
                stack.add(Integer.valueOf(item));
            }
        }
        return stack.poll();
    }

    public static int calculer(int first, int second, String operator) {
        int result = 0;
        switch (operator) {
        case "+":
            result = first + second;
            break;
        case "-":
            result = first - second;
            break;
        case "*":
            result = first * second;
            break;
        case "/":
            result = first / second;
            break;
        case "^":
            result = (int) Math.pow(first, second);
            break;
        default:
            result = 0;
        }
        return result;
    }
}
