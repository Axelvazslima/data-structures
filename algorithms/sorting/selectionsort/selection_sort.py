# Selection Sort algorithm in Python

import random as rd

nums = [rd.randint(0, 100) for i in range(10)]


def for_loop_selection_sort(nums):
    temp = nums.copy()

    for i in range(len(nums)):
        min_index = i
        for j in range(i + 1, len(nums)):
            if nums[min_index] > nums[j]: nums[min_index], nums[j] = nums[j], nums[min_index]
    return nums


print(f"\nThe original list is: ${nums}\nAfter sorting: ${for_loop_selection_sort(nums)}\nMaking sure the list changed: ${nums}...")

