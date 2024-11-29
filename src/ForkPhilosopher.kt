import kotlin.random.Random

internal class ForkPhilosopher(private val name: String, private val seat: Int): IPhilosopher {
    override fun takeUtensil(utensils: MutableList<Boolean>) {
        val random = Random.nextInt(0, 2)

        val rightIndex = (seat + random).mod(utensils.size)
        if (!utensils[rightIndex]) {
            utensils[rightIndex] = true
            println("$name взял вилку справа и обедает")
            return
        }

        val leftIndex = (seat + (1 - random)).mod(utensils.size)
        if (!utensils[leftIndex]) {
            utensils[leftIndex] = true
            println("$name взял вилку слева и обедает")
            return
        }

        println("$name размышляет")
    }
}
