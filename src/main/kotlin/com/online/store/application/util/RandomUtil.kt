package com.online.store.application.util

import java.util.Random

object RandomUtil {
    fun generateCustomerId(): String {
        val rnd: Random = Random()
        val number: Int = rnd.nextInt(999999)
        // this will convert any number sequence into 6 character.
        return String.format("%06d", number)
    }
}