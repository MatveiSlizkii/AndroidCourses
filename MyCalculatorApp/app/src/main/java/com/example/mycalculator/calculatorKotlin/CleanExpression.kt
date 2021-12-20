package calculator


/**
 *
 * @param выражение представленное строкой
 * @return выражение с правильно раставленными пробелами
 */
fun cleanExpression(expression: String): String {
    // не знаю как вместо нескольких .replace сделать одно
    var expression1: String = expression
        .filter { !it.isWhitespace() }///для удаления пробелов
        .replace("/", " / ")
        .replace("*", " * ")
        .replace("(", " ( ")
        .replace(")", " ) ")
        .replace("+", " + ")
    /*
    вставляет пробелы только когда минус не яляется знаком для определения
    отрицательного значения
    отрицательное число проявляется когда:
    1) отрицательное число стоит впереди выражения
    2) когда число стоит впереди открывающей скобкой "("
     */
    for (i in expression1.length - 1 downTo 1) {
        if (expression1[i].equals('-') && !expression1[i - 2].equals('(')) {
            expression1 = expression1.substring(0, i) +
                    " " +
                    expression1[i] +
                    " " +
                    expression1.substring(i + 1)
        }
    }
    //удаляет дабл пробелы
    expression1.replace(regex = "[\\s]{2,}".toRegex(), replacement = " ").also { expression1 = it }
    return expression1

}


