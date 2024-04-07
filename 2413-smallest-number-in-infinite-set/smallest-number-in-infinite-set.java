class SmallestInfiniteSet {

    Queue<Integer> queue;
    Map<Integer, Integer> map;

    public SmallestInfiniteSet() {
        queue = new PriorityQueue<>();
        map = new HashMap<>();

        for (int i = 1; i <= 1000; i++) {
            queue.offer(i);
            map.put(i, 1);
        }
    }

    public int popSmallest() {

        int popped = queue.poll();
        map.replace(popped, 0);
        return popped;
    }

    public void addBack(int num) {
        if (map.get(num) == 0) {
            queue.add(num);
            map.replace(num, 1);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */