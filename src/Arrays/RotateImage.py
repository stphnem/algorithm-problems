'''
48. Rotate Image
https://leetcode.com/problems/rotate-image/#/description
'''
class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        self.reverse(matrix)
        length = len(matrix)
        for i in range(length):
            for j in range(i+1, length):
                self.swap(i, j, matrix)
    
    def swap(self, i, j, matrix):
        temp = matrix[i][j]
        matrix[i][j] = matrix[j][i]
        matrix[j][i] = temp
        
    def reverse(self, matrix):
        length = len(matrix)
        for i in range(length/2):
            temp = matrix[length-i-1]
            matrix[length-i-1] = matrix[i]
            matrix[i] = temp
            
