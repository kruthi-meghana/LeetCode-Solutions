/*
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. 
Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and 
concatenate every saying.

@Author: Kruthi Meghana
*/


class Solution {
public:
    string countAndSay(int n) {
        if(n == 1)
            return "1";
        string answer = "11";
        while(n > 2) {
            string temp = "";
            int ind = 0, count = 0, num = 0;
            while(answer[num] != '\0' && answer[ind] != '\0') {
                if(answer[num] != answer[ind]) {
                    temp += count + '0';
                    temp += answer[num];
                    num = num + count;
                    count = 0;
                }
                count++;
                ind++;
            }
            temp += count + '0';
            temp += answer[num];
            answer = temp;
            n--;
        }
        return answer;
    }
    
};
