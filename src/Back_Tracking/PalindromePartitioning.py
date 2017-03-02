class Solution(object):
    
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        res = []
        self.backtrack(res, [], s)
        return res
    
    def backtrack(self, res, temp, s):
        if not s:
            res.append(temp)
            return
        for i in range(1, len(s) + 1):
            if self.isPalindrome(s[:i]):
                self.backtrack(res, temp+[s[:i]], s[i:])

    def isPalindrome(self, s):
        return str(s) == str(s)[::-1]