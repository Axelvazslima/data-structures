from random import randint as rdi

list_one = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
list_two = [3, 4, 5, 6, 7, 8, 9, 9, 9, 10]

def merge_sort(list_one: list[int], list_two: list[int]) -> list[int]:
# In non-python implementations you are going to need a third variable to control the insertion in the resulting array, but here you can simply append it.
    i, j = 0, 0
    resulting_list = []
    
    while True:
        condition_first_array: bool = i >= len(list_one)
        condition_second_array: bool = j >= len(list_two)
        
        if condition_first_array and condition_second_array:
            break
        
        if condition_first_array:
            resulting_list.append(list_two[j])
            j += 1
            continue
        elif list_one[i] <= list_two[j]:
            resulting_list.append(list_one[i])
            i += 1
            continue
        if condition_second_array:
            resulting_list.append(list_one[i])
            i += 1
        elif list_two[j] < list_one[i]:
            resulting_list.append(list_two[j])
            j += 1
    return resulting_list

print(merge_sort(list_one = list_one, list_two = list_two))

# Different approaches, same result
def traditional_merge_implementation(nums_one: list[int], nums_two: list[int]) -> list[int]:
    out = []
    
    i, j, = 0, 0
    while i < len(nums_one) and j < len(nums_two):
        if nums_one[i] <= nums_two[j]:
            out.append(nums_one[i])
            i+=1
        else:
            out.append(nums_two[j])
            j+=1
    while i < len(nums_one):
        out.append(nums_one[i])
        i+=1
    while j < len(nums_two):
        out.append(nums_two[j])
        j+=1
    
    return out

print(traditional_merge_implementation(nums_one=list_one, nums_two=list_two))