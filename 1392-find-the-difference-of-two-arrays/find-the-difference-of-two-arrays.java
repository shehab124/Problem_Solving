class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums1.length || i < nums2.length; i++) {
            if (i < nums1.length)
                map1.put(nums1[i], nums1[i]);
            if (i < nums2.length)
                map2.put(nums2[i], nums2[i]);
        }

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int key = entry.getKey();

            if (!map2.containsKey(key))
                result1.add(key);
        }

        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            int key = entry.getKey();

            if (!map1.containsKey(key))
                result2.add(key);
        }

        res.add(result1);
        res.add(result2);
        return res;
    }
}