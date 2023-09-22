class Solution {
    public boolean wordPattern(String pattern, String s) 
    {
        String words[] = s.split(" ");
		Map<Character, String> map = new HashMap<>();
        
        if(words.length != pattern.length())
			return false;

		for(int i = 0; i < words.length; i++)
		{
			if( !map.containsKey(pattern.charAt(i)) )
			{
				if(!map.containsValue(words[i]))
					map.put(pattern.charAt(i), words[i]);
				else
					return false;
			}
			else
			{
				if(!words[i].equals(map.get(pattern.charAt(i)))) 
					return false;
			}
		}
		return true;
    }
}