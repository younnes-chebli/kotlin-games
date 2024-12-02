package eu.epfc.kotlingames.tiger

import kotlin.math.abs
import kotlin.random.Random

abstract class Animal {
    abstract val name : String
    abstract val weight: Float
    abstract val speed: Float
    abstract val agility: Float
    abstract val force: Float
    var lifePoints: Float = 3.0F

    abstract fun makeSound()

    fun attack(target: Animal, failCallback: (Float) -> Unit) {
        val attackScore = 10 * weight * (speed + agility + force + Random.nextFloat() * 3)
        val enemyScore = 10 * target.weight * (target.speed + target.agility + target.force) + Random.nextFloat() * 3

        val damage = abs(attackScore - enemyScore)

        if(attackScore > enemyScore) {
            target.lifePoints -= damage
        } else {
            lifePoints -= damage
            failCallback(damage)
        }
    }
}