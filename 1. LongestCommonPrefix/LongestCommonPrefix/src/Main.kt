fun main() {

    val s = "abcabccbb"
    val s2 = "bbbbb"
    val s3 = "pwwkew"

    println(lengthOfLongestSubstring(s))
}

fun lengthOfLongestSubstring(s: String): Int {
    var i = 0
    var result = 0
    val resultList: MutableList<Int> = mutableListOf()
    val charList: MutableList<Char> = mutableListOf()

    while (i in s.indices) {
        if (!charList.contains(s[i])) {// pwwkew
            charList.add(s[i])
            result++
        } else {
            resultList.add(result)
            charList.clear()
            charList.add(s[i])
            result = 1
        }
        i++
    }
    return resultList.maxOrNull()!!
}