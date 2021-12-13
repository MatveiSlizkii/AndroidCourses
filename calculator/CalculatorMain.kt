package calculator

import calculator.priority.HighPriority
import calculator.priority.LowPriority
import calculator.priority.MediumPriority
import calculator.priority.api.ICalculatorPriority
import isCorrectExpression


    fun main(){
        //"5 + 2 * ( 5 + 8 * 5 / 4 ) - 20 / 12 + ( 2 )"
        println("Введите выражение")
        println("Ответ: " + readLine()?.let { CalculateAll(it) })

    }
    fun CalculateAll(expression: String): String {
        var expression1 = expression
        //проверочка
        if (isCorrectExpression(expression1)) {
            //чистим
            expression1 = cleanExpression(expression1)
            //считаем
            var action: ICalculatorPriority = HighPriority()
            expression1 = action.calculate(expression1)
            action = MediumPriority()
            try {
                expression1 = action.calculate(expression1)
            } catch (e: Exception){
                return "Делить на ноль нельзя"
            }
            action = LowPriority()
            expression1 = action.calculate(expression1)
            /*
            если полученный результат нельзя преобразовать в число
            например если выражение было 5.02.12 + 5 - 8
             */
            try {
                return expression1.trim().toBigDecimal().toString()
            } catch (e: Exception){
                return "Вы ввели неверное выражение"
            }
        } else {
            return "Вы ввели неверное выражение"
        }
    }