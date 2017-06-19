class Solution():
	def searchRange(self, nums, target):
		left = right = -1
		length = len(nums)
		if self.binarySearch(nums, target) == -1:
			return [left, right]

		left = right = self.binarySearch(nums, target)
		while left > 0 and self.binarySearch(nums, target, last=left-1) != -1:
			left = self.binarySearch(nums, target, last=left-1)

		while right <= length and self.binarySearch(nums, target, first=right+1) != -1:
			right = self.binarySearch(nums, target, first=right+1, last=None)

		return [left, right]

	
	def binarySearch(self, nums, target, first=None, last=None):
		if first is None:
			first = 0
		if last is None:
			last = len(nums)-1
		midpoint = -1
		found = False
	
		while first<=last and not found:
			midpoint = (first + last)//2
			if nums[midpoint] == target:
				found = True
			else:
				if target < nums[midpoint]:                   
					last = midpoint-1
				else:
					first = midpoint+1
	
		return midpoint if found else -1
