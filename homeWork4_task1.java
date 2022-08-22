class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> dictBrackets = new HashMap<>();
        dictBrackets.put('(', ')');
        dictBrackets.put('{', '}');
        dictBrackets.put('[', ']');

        Deque<Character> stack = new ArrayDeque<>();
        boolean flag = true;
        int i = 0;

        while ((flag == true) && (i < s.length())) {
            if (dictBrackets.containsKey(s.charAt(i))) { //открывающую скобку добавляем в стек
                stack.add(s.charAt(i));
            } else if ((!stack.isEmpty()) && (dictBrackets.get(stack.getLast()) == s.charAt(i))) {
                stack.pollLast();
            } else {
                flag = false;
            }
            i++;
        }
        if (!stack.isEmpty()){
            flag = false;
        }
        return flag;
    
    }
}
