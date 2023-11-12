class RandomizedSet {
        HashSet<Integer> set;
    public RandomizedSet() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        if(set.contains(val))
            return false;
        set.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(set.contains(val))
        {
            set.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        ArrayList<Integer> arr = new ArrayList<>(set);
        int size = arr.size();
        int index = (int)(Math.random()*size);
        return arr.get(index);
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */