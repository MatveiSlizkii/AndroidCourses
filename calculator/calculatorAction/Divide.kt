package calculator.calculatorAction

import calculator.calculatorAction.api.ICalculatorAction
import java.math.BigDecimal
import java.math.RoundingMode

class Divide : ICalculatorAction {
    /**
     * @param1 первое число
     * @param2 второе число
     * @return деление от деления двух параметров, 6 знаков после запятой
     */
    override fun action(x1: BigDecimal, x2: BigDecimal): BigDecimal {
        return x1.divide(x2, 6, RoundingMode.HALF_UP)
    }
}