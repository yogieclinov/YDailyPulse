package com.clinov.ydailypulse.utils

import kotlin.test.assertEquals

infix fun <T> T.shouldBe(value: T) = assertEquals(this, value)
