class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) 
    {
        unordered_map<char, int> umap;

    for(int i = 0; i < magazine.size(); i++)
        umap[magazine[i]]++;
    
    for(int i = 0; i < ransomNote.size(); i++)
    {
        if(umap.count(ransomNote[i]) > 0)
        {
            if(umap[ransomNote[i]] > 0)
                umap[ransomNote[i]]--;
            else
                return false;
        }
        else
            return false;

    }
    return true;
    }
};