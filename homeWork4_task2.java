class Solution {
    public String simplifyPath(String path) {
        String[] tempArr = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String item : tempArr) {
            if (item.equals("..") && !stack.isEmpty()) {
                stack.pollLast(); //удаляем из стека
            } else if (!(item.equals("")) && (!item.equals(".")) && (!item.equals(".."))) {
                stack.add(item);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder newPath = new StringBuilder();
        while (!stack.isEmpty()) {
            newPath.insert(0, ("/" + stack.pollLast()));
        }
        return newPath.toString();
    }
}
