internal class Table(philosopherCount: Int, philosopherFactory: (String, Int) -> IPhilosopher) {
    private val _philosophers: List<IPhilosopher>
    private val _utensils = mutableListOf<Boolean>()

    init {
        if (philosopherCount < 0) throw IllegalArgumentException("Число философов не может быть отрицательным")

        val philosophers = mutableListOf<IPhilosopher>()
        for (i in 1..philosopherCount) {
            print("Введите имя философа $i: ")
            val name = readln().trim()
            philosophers.add(philosopherFactory(name, i))
            _utensils.add(false)
        }

        _philosophers = philosophers
    }

    fun takeUtensils() {
        _philosophers.shuffled().forEach { it.takeUtensil(_utensils) }
    }
}
