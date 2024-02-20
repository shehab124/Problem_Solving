class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> dire = new LinkedList<>();
        Queue<Integer> radiant = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'D')
                dire.add(i);
            else
                radiant.add(i);
        }

        int lastIndex = senate.length();
        while (!dire.isEmpty() && !radiant.isEmpty()) {
            int d = dire.poll();
            int r = radiant.poll();

            if (d < r) {
                dire.add(lastIndex);
            } else {
                radiant.add(lastIndex);
            }
            lastIndex++;
        }

        if (dire.isEmpty())
            return "Radiant";
        else
            return "Dire";
    }
}