/*
package com.example.jetpackcomposecomponentes

import java.util.Hashtable


fun main(){
    val array: IntArray = intArrayOf(2,3,4)
    val tag = 6
        print(twoSum(array,tag).contentToString())

    }
//val array: IntArray = intArrayOf(-7,-3,2,3,11)
    private fun sortedSquares(nums: IntArray): IntArray {
        val list = mutableListOf<Int>()
        nums.forEach { list.add(it*it) }
        return list.sorted().toIntArray()
    }


fun twoSum(nums: IntArray, target: Int): IntArray {
*/
/*    var indexParent = 0
    var ret = mutableListOf<Int>()
            while (indexParent < nums.size){
                var index = 0
                while (index < nums.size){
                    if(index == indexParent){
                        index++
                    }else{
                        if((nums[indexParent] + nums[index]) == target){
                            ret.add(indexParent)
                            ret.add(index)
                            return ret.toIntArray()
                        }
                        index++
                    }
                }
                indexParent++
            }
    return ret.toIntArray()*//*

    var ret = mutableListOf<Int>()
    var hashTable: Hashtable<Int, Int> = Hashtable()
    var i = 0;
    while ((i < nums.size) && (hashTable.get(nums[i]) == null)) {
        hashTable.put(target - nums[i], i);
        i++;
    }
    if (i < nums.size) {
        print("1 ${hashTable.get(nums[i])} - ")
        print("2 ${hashTable.get(i)}")
    }
    return ret.toIntArray();
}*/
