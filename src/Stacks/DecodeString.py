class Solution(object):
    def decodeString(self, string):
        res = ''
        count = ''
        countStack = []
        resStack = []
        
        for char in string:
            if char.isdigit():
                count += char
            elif char == '[':
                countStack.append(int(count))
                resStack.append(res)
                count = ''
                res = ''
            elif char == ']':
                temp = resStack.pop()
                temp += countStack.pop() * res
                res = temp
            else:
                res += char
    
        return res