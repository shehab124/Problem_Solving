class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> result = new ArrayList<>();

        int maxCandies = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] >= maxCandies)
                maxCandies = candies[i];
        }

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxCandies)
                result.add(true);
            else
                result.add(false);
        }

        return result;
    }
}