package eu.epfc.kotlingames.tiger

import kotlin.random.Random

fun createEnemies(): List<Animal> {
    val animalsList: MutableList<Animal> = mutableListOf()

    for (turn in 0..5) {
        val random: Int = Random.nextInt(3)

        when (random) {
            0 -> animalsList.add(Tiger())
            1 -> animalsList.add(Snake())
            2 -> animalsList.add(Elephant())
        }
    }

    return animalsList
}