import kotlin.test.*
import org.junit.Test

class StringChecker {

    fun checkString(string: String, predicate: Char): Int {
        var occurences = 0
        string.forEach {// char: Char ->
            if (it == predicate) occurences++
        }
        return occurences
    }
}

class StringCheckerTest {
    // "Potato" 'Z'
    @Test
    fun `No Occurences`(){
        val testString = "Potato"
        val testChar = 'Z'

        val checker = StringChecker()

        val result = checker.checkString(testString, testChar)

        assertEquals(result, 0)
    }

    // "Blin" 'i'
    @Test fun `One Occurence`(){
        val testString = "Blin"
        val testChar = 'i'

        val checker = StringChecker()

        val result = checker.checkString(testString, testChar)

        assertEquals(result, 1)
    }

    // "Antidisestablishmentarianist" 'i'
    @Test fun `Many Occurences`(){
        val testString = "Antidisestablishmentarianist"
        val testChar = 'i'

        val checker = StringChecker()

        val result = checker.checkString(testString, testChar)

        assertEquals(result, 5)
    }
}