package subtask3

import java.util.*
import kotlin.collections.ArrayList

class StringParser {

    private val endOfString = '\u0000'

    fun getResult(inputString: String): Array<String> {
        val pairsList = arrayListOf(Pair("(",")"), Pair("[","]"), Pair("<", ">"))
        val results = substringByDelimiters(pairsList, inputString)
        return results.map{ e-> e.substring(1, e.lastIndex).toString()}.toTypedArray()
    }

    private fun substringByDelimiters(
        delimitersPairsList: ArrayList<Pair<String, String>>,
        inputString: String
    ): Deque<StringBuilder> {
        var substringsDequeue: Deque<StringBuilder> = ArrayDeque<StringBuilder>()
        inputString.forEach { c ->
            if (delimitersPairsList.map { pair -> pair.second }.toList().contains(c.toString())) {
                val startSeparator = delimitersPairsList.first { separator ->
                    separator.second == c.toString() }.first
                substringsDequeue.last { string ->
                    string.last() != endOfString && string.startsWith(startSeparator) }
                    .append(endOfString)
                writeSymbolToOpenedSubstrings(substringsDequeue, c)
            } else {
                writeSymbolToOpenedSubstrings(substringsDequeue, c)
                if (delimitersPairsList.map { m -> m.first }.toList().contains(c.toString())) {
                    val builder = StringBuilder().append(c)
                    substringsDequeue.add(builder)
                }
            }
        }
        return substringsDequeue
    }

    private fun writeSymbolToOpenedSubstrings(
        stackToWrite: Deque<StringBuilder>,
        c: Char
    ) {
        stackToWrite.forEach { s ->
            if (s.last() != endOfString) {
                s.append(c)
            }
        }
    }
}





