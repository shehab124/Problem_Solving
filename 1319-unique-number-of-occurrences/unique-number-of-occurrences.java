class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            if (map.containsKey(arr[i]))
                map.replace(arr[i], map.get(arr[i]), map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }

        for (int value : map.values()) {
            if (!set.add(value)) {
                return false;
            }
        }

        return true;
    }
}