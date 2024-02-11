
class RecentCounter {
    public Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        if(queue.isEmpty())
        {
            queue.add(t);
            return 1;
        }

        int peek = queue.peek();
        int maxValue = peek + 3000;
        if(t <= maxValue)
        {
            queue.add(t);
            return queue.size();
        }
        else
        {
            while (t > maxValue && !queue.isEmpty())
            {
                queue.remove();
                if(!queue.isEmpty())
                {
                    peek = queue.peek();
                    maxValue = peek + 3000;   
                }
                else
                    break;
            }
            
            queue.add(t);
            return queue.size();
        }
    }
}