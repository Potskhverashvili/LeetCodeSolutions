fun main() {

    val s = "abcabccbb"
    val s2 = "bbbbb"
    val s3 = "pwwkew"
    val s4 = ""
    val s5 = " "

    println(lengthOfLongestSubstring(s5))
}

fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0
    if (s.isBlank()) return 1

    var i = 0
    val result = 0
    var subStringLen = 0
    val resultList: MutableList<Int> = mutableListOf()
    val charList: MutableList<Char> = mutableListOf()

    while (i in s.indices) {
        if (!charList.contains(s[i])) {// pwwkew
            charList.add(s[i])
            subStringLen++
        } else {
            resultList.add(subStringLen)
            charList.clear()
            charList.add(s[i])
            subStringLen = 1
        }
        i++
    }

    return resultList.maxOrNull() ?: 0
}

/*
✅ Best Approach: Sliding Window + HashSet
Time complexity: O(n)

Space complexity: O(k) (k = size of longest substring)

Uses two pointers (start and end) and a HashSet to track characters.
*/


fun lengthOfLongestSubstring(s: String?): Int {
    if (s == null) return 0
    if (s.isBlank()) return 1

    val seenChars = mutableSetOf<Char>()
    var maxLength = 0
    var start = 0

    for (end in s.indices) {
        while (seenChars.contains(s[end])) {
            seenChars.remove(s[start])
            start++
        }
        seenChars.add(s[end])
        maxLength = maxOf(maxLength, end - start + 1)
    }

    return maxLength
}
