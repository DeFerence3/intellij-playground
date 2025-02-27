package com.diffy.aaupapa

fun findOccurrence(array: Array<Int>): Array<Int> {

    val distinctArray = array.distinct()  // [1,2,3]
    val returnArray = IntArray(distinctArray.size) // size = 3
    var arrayIndex = 0 // 2

    //returnArray  = [1,2,1]

    distinctArray.forEach { distinctElement -> // 3
        array.forEach { element -> // 3
            if(distinctElement == element){
                returnArray[arrayIndex] = returnArray[arrayIndex] + 1
            }
        }
        arrayIndex++
    }
    
    return returnArray.toTypedArray()
}