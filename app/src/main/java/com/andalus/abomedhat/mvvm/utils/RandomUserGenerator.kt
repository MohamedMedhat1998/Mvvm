package com.andalus.abomedhat.mvvm.utils

import com.andalus.abomedhat.mvvm.models.User
import kotlin.random.Random

class RandomUserGenerator private constructor() {

    companion object {
        private val alphabet = arrayOf(
            'a',
            'b',
            'c',
            'd',
            'e',
            'f',
            'g',
            'h',
            'i',
            'j',
            'k',
            'l',
            'm',
            'n',
            'o',
            'p',
            'q',
            'r',
            's',
            't',
            'u',
            'v',
            'w',
            'x',
            'y',
            'z'
        )
        private val digits = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        private val domains = arrayOf("yahoo", "gmail", "hotmail", "outlook")
        private val stringBuilder = StringBuilder()
        fun generate(): User {
            val id = Random.nextLong(1000000000000000000)
            var count = Random.nextInt(10) + 4
            while (count > 0) {
                stringBuilder.append(alphabet[Random.nextInt(alphabet.size)])
                count--
            }
            val name = stringBuilder.toString()
            stringBuilder.clear()
            stringBuilder.append(0)
            while (count < 12) {
                stringBuilder.append(digits[Random.nextInt(digits.size)])
                count++
            }
            val phone = stringBuilder.toString()
            stringBuilder.clear()
            var emailCount = Random.nextInt(20) + 5
            while (emailCount > 0) {
                stringBuilder.append(alphabet[Random.nextInt(alphabet.size)])
                emailCount--
            }
            stringBuilder.append("@").append(domains[Random.nextInt(domains.size)]).append(".com")
            val email = stringBuilder.toString()
            stringBuilder.clear()
            return User(id, name, phone, email)
        }
    }

}