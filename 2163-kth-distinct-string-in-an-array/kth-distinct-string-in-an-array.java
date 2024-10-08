class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++)
        {
            if(map.containsKey(arr[i]))
            {
                map.compute(arr[i], (key, value) -> value + 1);
            }
            else
                map.put(arr[i], 1);
        }
        int index = 1;

        for(int i = 0; i < arr.length; i++)
        {
            if(map.get(arr[i]) == 1) {
                if (index == k)
                    return arr[i];
                else
                    index++;
            }
        }
        return "";
    }
}