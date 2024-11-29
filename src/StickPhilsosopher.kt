internal class StickPhilsosopher(private val name: String, private val seat: Int) : IPhilosopher {
    override fun takeUtensil(utensils: MutableList<Boolean>) {
        val rightIndex = seat.mod(utensils.size)
        val leftIndex = (seat + 1).mod(utensils.size)

        if (utensils[rightIndex] || utensils[leftIndex]) {
            println("$name размышляет")
            return
        }

        utensils[rightIndex] = true
        utensils[leftIndex] = true
        println("$name взял палочки и обедает")
    }
}
