from random import randint as rdi

nums = [rdi(0, 100) for _ in range(10)]


def for_loop_bubble_sort(nums):
    for i in range(len(nums)):
        for j in range(len(nums) - i - 1):
            if nums[j] > nums[j + 1]:
                nums[j], nums[j + 1] = nums[j + 1], nums[j]
    return nums


print(f"\nThe original list is: ${nums}\nAfter sorting: ${for_loop_bubble_sort(nums)}\nMaking sure the list changed: ${nums}...")