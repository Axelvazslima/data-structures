# Selection Sort algorithm in Python

import random as rd

nums = [rd.randint(0, 100) for i in range(10)]


def forLoopSelSort(nums):

    for i in range(len(nums)):
        minIndex = i
        for j in range(i + 1, len(nums)):
            if nums[minIndex] > nums[j]: nums[minIndex], nums[j] = nums[j], nums[minIndex]
    return nums


print(f"\nThe original list is: ${nums}\nAfter sorting: ${forLoopSelSort(nums)}\nNow the list is: ${nums}... Notice that it changes the original list, meaning it has a collateral effect (it didn't need to return anything I just wanted to make it easier to print)")

