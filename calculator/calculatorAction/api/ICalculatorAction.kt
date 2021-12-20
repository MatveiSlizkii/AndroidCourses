package calculator.calculatorAction.api

import java.math.BigDecimal

interface ICalculatorAction {
    /*
    Интерфейс отвечает за простые вычисление
     */
    fun action(x1: BigDecimal, x2: BigDecimal): BigDecimal
}