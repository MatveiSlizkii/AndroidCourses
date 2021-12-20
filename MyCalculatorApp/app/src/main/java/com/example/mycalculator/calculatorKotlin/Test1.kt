package com.example.mycalculator.calculatorKotlin

import java.util.regex.Pattern

fun main(args: Array<String>) {
    var expression: String = "2 + (-2 * 3)" //8
    // expression = expression.replace("(\\d{1,}(\\/\\d{1,}){0,1}) *\\* *(\\d{1,}(\\/\\d{1,}){0,1})".toRegex(), " por ")
    println(expression)
    val ch: Char = '*'
    val xal: String = "\\$ch"
    val pattern = Pattern.compile("([-]?[0-9]+(.[0-9]+)?) * $xal *([-]?[0-9]+(.[0-9]+)?)")

    val matcher = pattern.matcher(expression)
    while (matcher.find()) {
        val operand1: String = matcher.group(1)
        val operand2: String = matcher.group(3)
        println(operand2)
        val tmp: Double = operand1.toDouble() * operand2.toDouble()
        expression = expression.replace(matcher.group(), tmp.toString())
    }
    println(expression)
    // println(calculate(expression,'*'))


}
