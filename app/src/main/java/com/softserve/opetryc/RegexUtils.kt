package com.softserve.opetryc

val specialCharacters = "!\"#\$%&'()*+,-./:;<=>?@[]^_`{|}~\\".toList()

private val specialRegex =
    "(?!\\s.+)(?=^\\s*\\S+\\s*\$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!\"#\$%&'()*+,-./:;<=>?@\\]\\[\\\\^_`{|}~]).+(?<!\\s)\$".toRegex()

val String.isSpecialRegexValid: Boolean
    get() = specialRegex.containsMatchIn(this)