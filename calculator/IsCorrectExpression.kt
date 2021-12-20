/**
 * Данный метод проверяет выражение на:
 * присутствие букв,
 * правильную расстановку скобок,
 * повторяющиеся операнды
 * присутствие символов !@#$%&"|~`'^
 * @param выражение
 * @return правильное ли выражение
 */
fun isCorrectExpression(expression: String): Boolean {
    return if (expression.contains("[a-zA-Z]|[/*+^-]{2,}|[!@#$%&\"|~`'^]".toRegex())) {
        false
    } else {
        parentheses(expression)

    }
}

/**
 *  Данная функция проверяет праильность вводимых скобок
 *  пример: "(5+8)" -> true
 *          "((5+8)" -> false
 *          ")(5+8" -> false
 *  @param выражение
 *  @return true -> скобки расставлены верно
 */
fun parentheses(expression: String): Boolean {
    var count: Int = 0
    for (char in expression) {
        when (char) {
            '(' -> count++
            ')' -> count--
        }
        if (count < 0) {
            return false
        }
    }
    return count == 0
}