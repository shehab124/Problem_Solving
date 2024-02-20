class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int[] result;

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0)
                stack.add(asteroids[i]);
            else {
                boolean flag = false;
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() <= Math.abs(asteroids[i])) {
                    int popped = stack.pop();
                    if (popped == Math.abs(asteroids[i])) {
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    continue;
                if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() < 0))
                    stack.add(asteroids[i]);
            }
        }

        int stackSize = stack.size();
        result = new int[stackSize];

        for (int i = stackSize - 1; i >= 0; i--)
            result[i] = stack.pop();

        return result;
    }
}