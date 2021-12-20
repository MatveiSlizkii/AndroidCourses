package calculator.calculatorAction

import calculator.calculatorAction.api.ICalculatorAction
import java.math.BigDecimal

class Multiply: ICalculatorAction {
    /**
     * @param1 первое число
     * @param2 второе число
     * @return произведение параметров
     */
    override fun action(x1: BigDecimal, x2: BigDecimal): BigDecimal {
        return x1.multiply(x2)
    }
}