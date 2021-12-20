package calculator.priority

import calculator.calculateReg
import calculator.calculatorAction.*
import calculator.calculatorAction.api.ICalculatorAction
import calculator.priority.api.ICalculatorPriority

class MediumPriority : ICalculatorPriority {
    /*
вычисления, имеющие средний приоритет приоритет. В данном случае приоритет
имеют выражения умножения и деления
*/
    override fun calculate(expression: String): String {
        var expression1 = expression
        var action: ICalculatorAction = Divide()
        expression1 = calculateReg(expression1, '/', action)
        action = Multiply()
        expression1 = calculateReg(expression1, '*', action)
        return expression1
    }
}