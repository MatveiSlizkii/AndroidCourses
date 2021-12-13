package calculator.calculatorAction

import calculator.calculatorAction.api.ICalculatorAction
import java.math.BigDecimal

class Add : ICalculatorAction {
    /**
     * @param1 первое число
     * @param2 второе число
     * @return сумма
     */
    override fun action(x1: BigDecimal, x2: BigDecimal): BigDecimal {
        return x1.add(x2)
    }
}