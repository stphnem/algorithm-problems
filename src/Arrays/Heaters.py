'''
475. Heaters
https://leetcode.com/problems/heaters/#/description
'''

class Solution(object):
    def findRadius(self, houses, heaters):
        """
        :type houses: List[int]
        :type heaters: List[int]
        :rtype: int
        """
        houses.sort()
        heaters.sort()
        maximum = 0
        i = 0
        for house in houses:
            while (i < len(heaters) - 1 and heaters[i] + heaters[i+1] <= house * 2):
                i += 1
            maximum = max(maximum, abs(heaters[i] - house))
        
        return maximum
