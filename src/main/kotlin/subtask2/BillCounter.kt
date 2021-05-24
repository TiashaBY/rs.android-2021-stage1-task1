package subtask2

class BillCounter {

    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val billWithoutAllergicFood = bill.toMutableList().filterIndexed{ index, _ -> index !=k }
        val annaBill = billWithoutAllergicFood.sum() / 2
        return if (annaBill == b) {
            "Bon Appetit"
        } else {
            (b - annaBill).toString()
        }
    }
}
