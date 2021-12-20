package calculator

import calculator.calculatorAction.api.ICalculatorAction
import java.math.BigDecimal
import java.util.regex.Pattern


/**
 * регулярное выражение которое позволяет найти числа, которые располагаются
 * сбоку от опреанда
 * @param1 выражение
 * @param2 операнд
 * @param3 интерфейс с умением вычислять
 * @return выражение посчитанное
 */
fun calculateReg(expression: String, operand: Char, iCalculatorAction: ICalculatorAction): String {
    var expression1 = expression
    val op: String = "\\$operand"
    val pattern = Pattern.compile("([-]?[0-9]+(.[0-9]+)?) * $op *([-]?[0-9]+(.[0-9]+)?)")
    do {
        val matcher = pattern.matcher(expression1)
        val isMatch = matcher.find()
        if (isMatch) {
            val operand1: String = matcher.group(1)
            val operand2: String = matcher.group(3)
            val tmp: BigDecimal = iCalculatorAction.action(operand1.toBigDecimal(), operand2.toBigDecimal())
            expression1 = expression1.replace(matcher.group(), tmp.toString())
        }
    } while (isMatch)
    return expression1
}


