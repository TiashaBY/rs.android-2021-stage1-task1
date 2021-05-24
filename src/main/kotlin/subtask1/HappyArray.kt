package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        val mutableArray = sadArray.toMutableList()
        var needCheck = true
        while (needCheck) {
            needCheck = false
            var i = 1
            while (i < mutableArray.size - 1) {
                if (mutableArray[i] > (mutableArray[i + 1] + mutableArray[i - 1])) {
                    mutableArray.removeAt(i)
                    needCheck = true
                } else i++
            }
        }
        return mutableArray.toIntArray()
    }
}


