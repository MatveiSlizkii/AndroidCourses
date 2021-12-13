package calculator

import calculator.priority.HighPriority
import calculator.priority.LowPriority
import calculator.priority.MediumPriority
import calculator.priority.api.ICalculatorPriority
import isCorrectExpression
import java.math.BigDecimal
import java.util.regex.Pattern

class Test {
}

fun main() {
    var expression: String = "5 + 2 * 5 / 7"


    var m1: ICalculatorPriority = HighPriority()
    expression = m1.calculate(expression)
    println(expression)
    m1 = MediumPriority()
    expression = m1.calculate(expression)
    println(expression)
    m1 = LowPriority()
    expression = m1.calculate(expression)
    println(expression)

}