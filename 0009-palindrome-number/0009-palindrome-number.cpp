class Solution {
public:
    bool isPalindrome(int x) {
    if(x < 0)
    return false;
    
    stack<int> stack;
    int y = x; // divide from the y

    while (y != 0)
    {
        stack.push(y%10);
        y /= 10;   
    }

    long reversed = 0;
    for(int i = 0; !stack.empty(); i++)
    {
        reversed += stack.top() * pow(10, i);
        stack.pop();
    }

    if(reversed == x)
        return true;
    else
        return false;
    }
};