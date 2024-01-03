package crackingthecodinginterview


fun main() {
    println(IsUnique().isUnique("Hello"))
}

class IsUnique {
    //O(n) time, Space O(1) space limited 128 characters.
    fun isUnique(str: String): Boolean {
        if (str.length > 128) return false
        val charArray = BooleanArray(128)
        for (element in str) {
            if (charArray[element.code]) {
                return false
            }
            charArray[element.code] = true
        }
        return true
    }
}