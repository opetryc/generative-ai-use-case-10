package com.softserve.opetryc

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RegexUtilsTest {

    @Test
    fun `fail if string is empty`() {
        assertFalse("".isValid())
    }

    @Test
    fun `fail if string is space`() {
        assertFalse(" ".isValid())
    }

    @Test
    fun `if all present then pass`() {
        assertTrue("Aa2%".isValid())
    }

    @Test
    fun `if no digits then fail`() {
        assertFalse("Aa%".isValid())
    }

    @Test
    fun `if no uppercase letters then fail`() {
        assertFalse("a2%".isValid())
    }

    @Test
    fun `if no lowercase letters then fail`() {
        assertFalse("A2%".isValid())
    }

    @Test
    fun `if no special char then fail`() {
        assertFalse("Aa2".isValid())
    }

    @Test
    fun `fail if whitespace exists in a string`() {
        assertFalse("A a2%".isValid())
    }

    @Test
    fun `fail if whitespace exists at start`() {
        assertFalse(" Aa2%".isValid())
    }

    @Test
    fun `fail if whitespace exists at end`() {
        assertFalse("Aa2% ".isValid())
    }

    @Test
    fun `fail if whitespace exists at start, middle, end`() {
        assertFalse(" Aa 2% ".isValid())
    }

    @Test
    fun `fail if tabs exist`() {
        assertFalse("Aa\t2%".isValid())
    }

    @Test
    fun `fail if new line exist in the middle linux`() {
        assertFalse("Aa\n2%".isValid())
    }

    @Test
    fun `fail if new line exist in the middle pre mac os X`() {
        assertFalse("Aa\r2%".isValid())
    }

    @Test
    fun `fail if new line exist in the middle windows`() {
        assertFalse("Aa\r\n2%".isValid())
    }

    @Test
    fun `fail if string starts with new line for linux`() {
        assertFalse("\nAa2%".isValid())
    }

    @Test
    fun `fail if string starts with new line for pre osX mac`() {
        assertFalse("\rAa2%".isValid())
    }


    @Test
    fun `fail if string starts with new line for windows`() {
        assertFalse("\r\nAa2%".isValid())
    }

    @Test
    fun `fail if string ends with new line for linux`() {
        assertFalse("Aa2%\n".isValid())
    }

    @Test
    fun `fail if string ends with new line for pre osX mac`() {
        assertFalse("Aa2%\n".isValid())
    }


    @Test
    fun `fail if string ends with new line for windows`() {
        assertFalse("Aa2%\n".isValid())
    }

    @Test
    fun `fail if string starts and ends with new line complex`() {
        val str = """
                    Aa2%
                  """
        assertFalse(str.isValid())
    }

    @Test
    fun `don't fail if special character exists`() {
        val basicStr = "Aa2"
        specialCharacters.forEach { char ->
            assertTrue(char.toString(), "$basicStr$char".isValid())
        }
    }

    @Test
    fun `special test case, don't fail if backslash exists`() {
        val basicStr = "Aa2\\"
        assertTrue(basicStr.isValid())
    }

    @Test
    fun `fail if number of characters is within the range`() {
        assertTrue("Aa2%".isValid(10))
    }

    @Test
    fun `fail if number of characters if bigger than expected`() {
        assertFalse("Aagjlkdgh5@#5435tgrg".isValid(2))
    }

    @Test
    fun `pass if number of characters is as expected`() {
        val str = "Agfdhgjkldrhl&9*&*352"
        assertTrue(str.isValid(str.length))
    }

    @Test
    fun `fail even if expecting length of 0`() {
        assertFalse("".isValid(0))
    }
}