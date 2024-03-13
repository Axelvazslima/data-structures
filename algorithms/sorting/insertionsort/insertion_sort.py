import random

nums = [random.randint(1, 100) for _ in range(10)]


def for_loop_insertion_sort(nums):

    for i in range(1, len(nums)):
        for j in range(i, 0, - 1):
            if nums[j] > nums[j - 1]:
                break
            nums[j], nums[j - 1] = nums[j - 1], nums[j]

    return nums


print(f"\nThe original list is: ${nums}\nAfter sorting: ${for_loop_insertion_sort(nums)}\nMaking sure the list changed: ${nums}...")