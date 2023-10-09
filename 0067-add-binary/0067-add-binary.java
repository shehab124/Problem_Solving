class Solution {
    public String addBinary(String a, String b) 
    {

        StringBuilder result = new StringBuilder();
        boolean carry = false;

        if(a.length() < b.length())
        {
            int size = b.length() - a.length();
            for(int i = 0; i < size; i++)
                a = "0" + a;
        }
        if(a.length() > b.length())
        {
            int size = a.length() - b.length();
            for(int i = 0; i < size; i++)
                b = "0" + b;
        }

        for(int i = a.length() - 1 ; i >= 0; i--)
        {
            // 0+0+0
            if(a.charAt(i) == '0' && b.charAt(i) == '0' && carry == false)
                result.append('0');
            // 1+0+0
            else if(a.charAt(i) == '0' && b.charAt(i) == '0' && carry == true)
            {
                result.append('1');
                carry = false;
            }
            else if( (a.charAt(i) == '1' && b.charAt(i) == '0' && carry == false) || (a.charAt(i) == '0' && b.charAt(i) == '1' && carry == false) )
                result.append('1');
            // 1+1+0
            else if((a.charAt(i) == '1' && b.charAt(i) == '1' && carry == false) || (a.charAt(i) == '1' && b.charAt(i) == '0' && carry == true) || (a.charAt(i) == '0' && b.charAt(i) == '1' && carry == true) )
            {
                result.append('0');
                carry = true;
            }
            // 1+1+1
            else
            {
                result.append('1');
                carry = true;
            }
        }
        if(carry == true)
            result.append('1');

        return result.reverse().toString();    

    }
}