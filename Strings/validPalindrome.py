"""
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
"""

import re

class Solution:
    def isPalindrome(self, s: str) -> bool:
        expression =  re.compile('[a-zA-Z0-9]')
        front = 0
        rare = len(s) - 1
        
        while(front < rare):
            if(re.match(expression,s[front]) and re.match(expression,s[rare])):
                if(s[front].lower() != s[rare].lower()):
                    return False
                front += 1
                rare -= 1
            elif not(re.match(expression,s[front])):
                front += 1
            elif not(re.match(expression,s[rare])):
                rare -= 1
                
        return True
