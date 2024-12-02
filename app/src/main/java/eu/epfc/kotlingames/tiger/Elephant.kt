package eu.epfc.kotlingames.tiger

class Elephant: Animal() {
    override val name = "Elephant"
    override val weight: Float = 0.1F
    override val speed: Float = 0.3F
    override val agility: Float = 0.3F
    override val force: Float = 0.7F

    override fun makeSound() {
        TODO("Not yet implemented")
    }
}