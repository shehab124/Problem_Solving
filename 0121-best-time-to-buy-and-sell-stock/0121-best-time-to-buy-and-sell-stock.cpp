class Solution
{
    public:
        int maxProfit(vector<int> &prices)
        {
            int profit = 0;
            int maxP = 0;
            int buy = 0, sell = 1;

            while (sell < prices.size())
            {
                if (prices[buy] < prices[sell])
                {
                    profit = prices[sell] - prices[buy];
                    maxP = max(profit, maxP);
                }
                else
                    buy = sell;
                sell++;
            }
            return maxP;
        }
};