package com.softserve.opetryc

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RegexUtilsTest {

    @Test
    fun `fail if string is empty`() {
        assertFalse("".isSpecialRegexValid)
    }

    @Test
    fun `fail if string is space`() {
        assertFalse(" ".isSpecialRegexValid)
    }

    @Test
    fun `if all present then pass`() {
        assertTrue("Aa2%".isSpecialRegexValid)
    }

    @Test
    fun `if no digits then fail`() {
        assertFalse("Aa%".isSpecialRegexValid)
    }

    @Test
    fun `if no uppercase letters then fail`() {
        assertFalse("a2%".isSpecialRegexValid)
    }

    @Test
    fun `if no lowercase letters then fail`() {
        assertFalse("A2%".isSpecialRegexValid)
    }

    @Test
    fun `if no special char then fail`() {
        assertFalse("Aa2".isSpecialRegexValid)
    }

    @Test
    fun `fail if whitespace exists in a string`() {
        assertFalse("A a2%".isSpecialRegexValid)
    }

    @Test
    fun `fail if whitespace exists at start`() {
        assertFalse(" Aa2%".isSpecialRegexValid)
    }

    @Test
    fun `fail if whitespace exists at end`() {
        assertFalse("Aa2% ".isSpecialRegexValid)
    }

    @Test
    fun `fail if whitespace exists at start, middle, end`() {
        assertFalse(" Aa 2% ".isSpecialRegexValid)
    }

    @Test
    fun `fail if tabs exist`() {
        assertFalse("Aa\t2%".isSpecialRegexValid)
    }

    @Test
    fun `fail if new line exist in the middle linux`() {
        assertFalse("Aa\n2%".isSpecialRegexValid)
    }

    @Test
    fun `fail if new line exist in the middle pre mac os X`() {
        assertFalse("Aa\r2%".isSpecialRegexValid)
    }

    @Test
    fun `fail if new line exist in the middle windows`() {
        assertFalse("Aa\r\n2%".isSpecialRegexValid)
    }

    @Test
    fun `fail if string starts with new line for linux`() {
        assertFalse("\nAa2%".isSpecialRegexValid)
    }

    @Test
    fun `fail if string starts with new line for pre osX mac`() {
        assertFalse("\rAa2%".isSpecialRegexValid)
    }


    @Test
    fun `fail if string starts with new line for windows`() {
        assertFalse("\r\nAa2%".isSpecialRegexValid)
    }

    @Test
    fun `don't fail if special character exists`() {
        val basicStr = "Aa2"
        specialCharacters.forEach { char ->
            println("$basicStr$char")
            assertTrue(char.toString(), "$basicStr$char".isSpecialRegexValid)
        }
    }

    @Test
    fun `special test case, don't fail if backslash exists`() {
        val basicStr = "Aa2\\"
        assertTrue(basicStr.isSpecialRegexValid)
    }
}