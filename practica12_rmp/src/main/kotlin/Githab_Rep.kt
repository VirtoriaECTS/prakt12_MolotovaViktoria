//Githab_Rep.kt
import kotlinx.coroutines.*

class Githab_Rep {
    fun Block(block: Boolean){
        while(block == false){
            println("Заблокировано. Введите 'Загрузить участников'")
            val anwer = readLine()!!
            if(anwer == "Загрузить участников"){
                break
            }

        }

    }
    suspend fun Get_users(repCount: Int): List<Pair<Int, String>> = withContext(Dispatchers.IO)
    {
        val users = mutableListOf<Pair<Int, String>>()
        try {
            for(i in 1..repCount)
            {
                println("Введите имя участника $i")
                val name: String = readLine()!!
                println("Введите количество его репозиториев")
                val count: Int = readLine()!!.toInt()
                users.add(count to name)
            }
        }
        catch (e: Exception)
        {
            println("Вы ввели не число")
        }
        users
    }
    suspend fun Print(user: Pair<Int, String>)
    {
        delay(1000)
        println("${user.second  } - ${user.first} репозиториев")
    }
}