package calculator.priority.api

interface ICalculatorPriority {
    /**
     * @param строка выражения
     * @return строку выражения с посчитанным одним выражением
     */
    fun calculate(expession: String): String
}