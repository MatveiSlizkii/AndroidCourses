package calculator.priority

import calculator.calculateReg
import calculator.calculatorAction.*
import calculator.calculatorAction.api.ICalculatorAction
import calculator.priority.api.ICalculatorPriority
import java.util.regex.Pattern

class HighPriority: ICalculatorPriority {
    /*
    вычисления, имеющие высокий приоритет. В данном случае высокий приоритет
    имеют выражения внутри скобки
     */
    override fun calculate(expression: String): String {
        var expression1 = expression
        val pattern = Pattern.compile("\\(.*?\\)")
        do {
            val matcher = pattern.matcher(expression1)
            val isMatch = matcher.find()
            if (isMatch){
                val operand1: String = matcher.group(0)
                var xal = operand1.substring(1, operand1.length-2)
                var priority: ICalculatorPriority = MediumPriority()
                xal = priority.calculate(xal)
                priority = LowPriority()
                xal = priority.calculate(xal)
                expression1 = expression1.replace(matcher.group(), xal)
            }
        } while (isMatch)



        return expression1
    }
}