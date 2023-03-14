//zad2.kt
import kotlinx.coroutines.*
import java.lang.NumberFormatException

fun main() {
    println("Введите имя пользователя:")
    var login = readLine()!!
    println("Введите пароль:")
    try{
        var password = readLine()!!
        println("Введите количество участников:")
        val count_user = readLine()!!.toInt()
        if(count_user > 0){
            val repositories = Githab_Rep()

            val usersAndRepos = runBlocking {
                repositories.Get_users(count_user)
            }

            runBlocking {
                repositories.Block(false)
                println("Количество участников:")
                usersAndRepos.sortedWith(compareBy({ it.first }, { it.second }))
                    .forEach { user -> launch { repositories.Print(user) } }
                delay(3000)
            }
        }
        else{
            println("Количество участников должно быть больше нуля")
        }
        }

    catch (e: NumberFormatException){
        println("Необходимо ввести число")
    }

}
