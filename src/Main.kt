private fun inputInt(message: String): Int {
    while (true) {
        print(message)
        val input = readln().toIntOrNull()

        if (input == null) {
            println("Введите число")
            continue
        }

        if (input <= 0) {
            println("Число должно быть больше нуля")
            continue
        }

        return input
    }
}

fun main() {
    val forkPhilosopherCount = inputInt("Введите число философов за столом с вилками: ")
    val forkTable = Table(forkPhilosopherCount) { name, seat -> ForkPhilosopher(name, seat) }
    forkTable.takeUtensils()

    println()

    val stickPhilosopherCount = inputInt("Введите число философов за столом с палочками: ")
    val stickTable = Table(stickPhilosopherCount) { name, seat -> StickPhilosopher(name, seat) }
    stickTable.takeUtensils()
}
