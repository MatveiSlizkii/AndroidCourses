package calculator.priority

import calculator.calculateReg
import calculator.calculatorAction.*
import calculator.calculatorAction.api.ICalculatorAction
import calculator.priority.api.ICalculatorPriority

class LowPriority : ICalculatorPriority {
    /*
вычисления, имеющие низкий приоритет приоритет. В данном случае низкий приоритет
имеют выражения сложения и вычитания
 */
    override fun calculate(expression: String): String {
        var expression1 = expression
        var action: ICalculatorAction = Add()
        expression1 = calculateReg(expression1, '+', action)
        action = Subtract()
        expression1 = calculateReg(expression1, '-', action)
        return expression1
    }
}