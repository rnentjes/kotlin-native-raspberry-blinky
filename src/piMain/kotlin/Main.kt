@file:Suppress("EXPERIMENTAL_UNSIGNED_LITERALS")

import wiringPi.*

val LED = 8

fun main() {
    wiringPiSetup()
    pinMode(LED, OUTPUT)

    repeat(10) {
        digitalWrite(LED, HIGH)
        delay(500u)
        digitalWrite(LED, LOW)
        delay(500u)
    }
}
