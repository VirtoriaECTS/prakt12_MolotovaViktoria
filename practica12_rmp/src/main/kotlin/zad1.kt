//zad1.kt
import kotlinx.coroutines.*
import java.lang.NumberFormatException
suspend fun main()= coroutineScope{
    println("Введите кол-во функций: ")
    val n = readLine()!!.toInt()

    if(n <=0){
        println("Фунций должно быть больше нуля")
    }
    else{

        launch {
            for (i in 1..n) {
                try {
                    println("Введите высоту премоугольника:")
                    val height = readLine()!!.toDouble()
                    if(height <= 0) println("Высота должна быть больше нуля")
                    else{
                        println("Введите ширину премоугольника:")
                        val weight = readLine()!!.toDouble()
                        if(weight <= 0) println("Ширина должна быть больше нуля")
                        else{
                            val rectangle: Rectangle = Rectangle(weight, height)
                            rectangle.Square();
                            rectangle.Perimeter()
                        }
                    }
                }

                catch (e: NumberFormatException){
                    println("Необходимо ввести число")
                }
            }
        }
        for (i in 1..n) {
            println("$i прямоугольник")
            delay(4000)
        }
    }
}