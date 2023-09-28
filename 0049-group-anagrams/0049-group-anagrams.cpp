class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
    vector<vector<string>> result;
    int size = 0;
    unordered_map<string, int> umap; // sorted string, index in vector
    string sorted;
    int j = 0;
    
    for(int i = 0; i < strs.size(); i++)
    {
        sorted = strs[i];
        sort(sorted.begin(), sorted.end());
        
        if(umap.count(sorted) > 0)
        {
            int index = umap[sorted];
            string s = strs[i];
            //result[umap[sorted]].push_back(strs[i]);
            result[index].push_back(s);
        }
        else
        {
            size++;
            result.resize(size);
            umap[sorted] = j;
            result[j].push_back(strs[i]);
            j++;
        }
    }
    return result;
    }
};