class Solution {
private:
    template <typename K, typename V>
K findKeyByValue(const std::unordered_map<K, V>& myMap, const V& valueToFind) {
    for (const auto& pair : myMap) {
        if (pair.second == valueToFind) {
            return pair.first; // Return the key when the value is found
        }
    }
    return NULL;
}

public:
    bool isIsomorphic(string s, string t) 
    {
        unordered_map<char, char> umap;

    for(int i = 0; i < s.size(); i++)
    {
        if(umap.count(s[i]) == 0 )
        {
            if(!findKeyByValue(umap, t[i]))
                umap[s[i]] = t[i];
            else
                return false;
        }
        else
        {
            if(t[i] != umap[s[i]])
                return false;
        }
    }
    return true;   
    }
};