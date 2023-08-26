package com.softserve.opetryc

const val specialCharacters = "!\"#$%%&'()*+,-./:;<=>?@\\]\\[\\\\^_`{|}~"

private const val specialRegex = "^(?!.*\\s.*)(?=.{%d}$)(?=.*[a-z].*)(?=.*[A-Z].*)(?=.*\\d.*)(.*[%s].*)$"

fun String.isValid(maxLength: Int = this.length): Boolean {
    val regexStr = specialRegex.format(maxLength, specialCharacters)
    val regex = Regex(regexStr)
    return regex.containsMatchIn(this)
}