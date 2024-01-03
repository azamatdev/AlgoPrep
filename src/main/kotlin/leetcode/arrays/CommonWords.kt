package leetcode.arrays

/**
 * Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.
 */
fun main() {
//    println(commonChars(arrayOf("bella", "label", "roller")))
//    println(commonChars(arrayOf("cool", "lock", "cook")))

    /**
     *Write a program to check character entered is alphabet,
     * digit or special character using library functions.
     * */

    val c = '#'

    if (c in 'a'..'z' || c in 'A'..'Z')
        println("$c is an alphabet.")
    else {
        if (c in '0'..'9') {
            println("$c is digit")
        } else {
            println("$c is special character.")
        }
    }

}


//fun commonChars(words: Array<String>): List<String> {
//    var charMap = HashMap<Char, Int>()
//    for (i in words.indices) {
//        for (j in words[i].indices) {
//            if (charMap.contains(words[i][j]))
//                charMap.put(words[i][j], +1)
//            charMap.put(words[i][j], 0)
//        }
//    }
//}