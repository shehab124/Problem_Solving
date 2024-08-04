class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < target.length; i++) {
            if (map.containsKey(target[i]))
                map.put(target[i], map.get(target[i]) + 1);
            else
                map.put(target[i], 1);

            if (map2.containsKey(arr[i]))
                map2.put(arr[i], map2.get(arr[i]) + 1);
            else
                map2.put(arr[i], 1);
        }

        return map2.equals(map);
    }
}