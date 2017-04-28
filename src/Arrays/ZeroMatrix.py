'''
73. Set Matrix Zeroes
https://leetcode.com/problems/set-matrix-zeroes/#/description
'''
class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        fr = False
        fc = False

        rowLength = len(matrix)
        colLength = len(matrix[0])
        for row in range(rowLength):
            for col in range(colLength):
                if (matrix[row][col] is 0):
                	if row is 0:
                		fr = True
                	if col is 0:
                		fc = True
                	matrix[row][0] = 0
                	matrix[0][col] = 0

        for row in range(1, rowLength):
            for col in range(1, colLength):
                if matrix[row][0] is 0 or matrix[0][col] is 0:
                    matrix[row][col] = 0

        if fr:
        	for col in range(colLength):
        		matrix[0][col] = 0

        if fc:
        	for row in range(rowLength):
        		matrix[row][0] = 0
