package calculator.calculatorAction

import calculator.calculatorAction.api.ICalculatorAction
import java.math.BigDecimal

class Subtract : ICalculatorAction {
    /**
     * @param1 первое число
     * @param2 второе число
     * @return частное двух параметров
     */
    override fun action(x1: BigDecimal, x2: BigDecimal): BigDecimal {
        return x1.subtract(x2)
    }
}