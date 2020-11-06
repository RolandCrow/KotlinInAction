package android_academy

import kotlin.math.max

fun main() {
    /**
     * Тривиальная
     *
     * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
     * Вывести значение того же угла в радианах (например, 0.63256).
     */
    fun angleInRadian(grad: Int, min: Int, sec: Int): Double {


        val oneMinToGrad = (1/60)
        val oneSecToGrad = (1/3600)

        val allGrad = 36 + (14 * oneMinToGrad) + (35 * oneSecToGrad)

        return allGrad * 0.0174533
    }

    println(angleInRadian(36,14,35))


    /**
     * Тривиальная
     *
     * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
     * Например, расстояние между (3, 0) и (0, 4) равно 5
     */
    fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double): Double {


        return kotlin.math.sqrt(((x2 - x1)*(x2 - x1)) + ((y2 - y1) * (y2 - y1)) )

    }

    println(trackLength(3.0,0.0, 0.0, 4.0))

    /**
     * Простая
     *
     * Пользователь задает целое число, большее 100 (например, 3801).
     * Определить третью цифру справа в этом числе (в данном случае 8).
     */
    fun thirdDigit(number: Int): Int {
        val toDigit = (number/100)%100
        return toDigit.toString().substring(1).toInt()

    }

    println(thirdDigit(3801))

    /**
     * Простая
     *
     * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
     * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
     * Определите время поезда в пути в минутах (в данном случае 216).
     */
    fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int)
            : Int {
        val minutesDeparts = (hoursDepart * 60) + minutesDepart
        val minutesArrives = (hoursArrive * 60) + minutesArrive
        return minutesDeparts - minutesArrives

    }

    println(travelMinutes(13,1, 9,25))

    /**
     * Простая
     *
     * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
     * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
     * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
     */
    fun accountInThreeYears(initial: Int, percent: Int): Double {
        val hardPercent = (1 + percent) * 3.0
        return initial + hardPercent
    }

    println(accountInThreeYears(100,10))

    /**
     * Простая
     *
     * Пользователь задает целое трехзначное число (например, 478).
     * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
     */
    fun numberRevert(number: Int): Int {
        val strNumber = number.toString().reversed()
        return strNumber.toInt()
    }

    println(numberRevert(238))


    /**
     * Простая
     *
     * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
     * вернуть строку вида: «21 год», «32 года», «12 лет».
     */
    fun ageDescription(age: Int): String = when (age){
        21 -> "21 год"
        32 -> "32 года"
        12 -> "12 лет"
        else -> "Не тот возраст"
    }

    /**
     * Простая
     *
     * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
     * и t3 часов — со скоростью v3 км/час.
     * Определить, за какое время он одолел первую половину пути?
     */
    fun timeForHalfWay(t1: Double, v1: Double,
                       t2: Double, v2: Double,
                       t3: Double, v3: Double): Double {

        val allKm = ((t1 * v1) + (t2 * v2) + (t3 * v3) ) * 0.5
        val km1 = t1 * v1
        val km2 = t2 * v2
        val km3  = t3 * v3

        var timeOfHalf = 0.0

        timeOfHalf = when {
            allKm <= km1 -> {
                allKm / v1
            }
            allKm <= km1 + km2 -> {
                t1 + (allKm - km1) / v3
            }
            else -> {
                t1 + t2 + (allKm - km1 - km2) / v3
            }
        }
        return timeOfHalf


    }
    /**
     * Простая
     *
     * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
     * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
     * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
     * и 3, если угроза от обеих ладей.
     * Считать, что ладьи не могут загораживать друг друга
     */
    fun whichRookThreatens(kingX: Int, kingY: Int,
                           rookX1: Int, rookY1: Int,
                           rookX2: Int, rookY2: Int): Int {
        return if ((kingX != rookX1) && (kingX != rookX2) && (kingY != rookY1) && (kingY != rookY2)) 0
        else if ((kingX == rookX1) && (kingX != rookX2) && (kingY == rookY1) && (kingY != rookY2)) 1
        else if ((kingX != rookX1) && (kingX == rookX2) && (kingY != rookY1) && (kingY == rookY2)) 2
        else 3

    }

    /**
     * Простая
     *
     * На шахматной доске стоят черный король и белые ладья и слон
     * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
     * Проверить, есть ли угроза королю и если есть, то от кого именно.
     * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
     * и 3, если угроза есть и от ладьи и от слона.
     * Считать, что ладья и слон не могут загораживать друг друга.
     */
    fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                              rookX: Int, rookY: Int,
                              bishopX: Int, bishopY: Int): Int {
        return if((kingX != rookX) && (kingY != rookY) || (kingX != bishopX) && (kingY != bishopY)) 0
        else if((kingX == rookX) && (kingY == rookY) || (kingX != bishopX) && (kingY != bishopY)) 1
        else if((kingX != rookX) && (kingY != rookY) || (kingX == bishopX) && (kingY == bishopY)) 2
        else 3
    }


    fun sqr(x: Double) = x * x

    /**
     * Простая
     *
     * Треугольник задан длинами своих сторон a, b, c.
     * Проверить, является ли данный треугольник остроугольным (вернуть 0),
     * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
     * Если такой треугольник не существует, вернуть -1.
     */
    fun triangleKind(a: Double, b: Double, c: Double): Int {

        val x = max(a, b)
        val y = max(x, c)
        val z = sqr(y)
        val m = sqr(a + b + c - y)
        val n = 2*a*b*c/y
        return if((m - n < z)&&( a + b + c > 2 * y)) 2
        else if ((m - n > z)&&( a + b + c > 2 * y )) 0
        else if((m - n == z)&&( a + b + c > 2 * y)) 1
        else -1
    }




    /**
     * Средняя
     *
     * Даны четыре точки на одной прямой: A, B, C и D.
     * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
     * Найти длину пересечения отрезков AB и CD.
     * Если пересечения нет, вернуть -1.
     */
    fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
        var x = 0
        return if((a >= c) && (c < d) && (b <= d)) {
            b - c
        }
        else if((a == d) || (b == c)) {
            0
        }
        else if((c <= a) && (b <= d)) {
            b - a
        }
        else if((a <= c) && (d <= b)) {
            d - c
        }
        else if((c <= a) && (a < d) && (d <= b)) {
            d - a
        }
        else -1
    }



    /**
     * Простая
     *
     * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
     * Определить, счастливое ли заданное число, вернуть true, если это так.
     */
    fun isNumberHappy(number: Int): Boolean = TODO()

    /**
     * Простая
     *
     * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
     * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
     * Считать, что ферзи не могут загораживать друг друга.
     */
    fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean = TODO()


    /**
     * Простая
     *
     * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
     * Вернуть число дней в этом месяце этого года по григорианскому календарю.
     */
    fun daysInMonth(month: Int, year: Int): Int = TODO()

    /**
     * Средняя
     *
     * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
     * окружности с центром в (x2, y2) и радиусом r2.
     * Вернуть true, если утверждение верно
     */
    fun circleInside(x1: Double, y1: Double, r1: Double,
                     x2: Double, y2: Double, r2: Double): Boolean = TODO()

    /**
     * Средняя
     *
     * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
     * Стороны отверстия должны быть параллельны граням кирпича.
     * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
     * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
     * Вернуть true, если кирпич пройдёт
     */
    fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean = TODO()




}