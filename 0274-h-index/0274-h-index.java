class Solution {

    public int hIndex(int[] citations) {
        Integer[] cits = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            cits[i] = citations[i];
        }
        Comparator<Integer> descendingComparator = Comparator.reverseOrder();
        Arrays.sort(cits, descendingComparator);
        int h = 0;

        while(cits[h] > h) {
            h++;
            if(h == citations.length)
                return citations.length;
        }
        return h;
    }
}
