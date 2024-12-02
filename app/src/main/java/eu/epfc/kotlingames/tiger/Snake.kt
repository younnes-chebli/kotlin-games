package eu.epfc.kotlingames.tiger

class Snake: Animal() {
    override val name = "Snake"
    override val weight: Float = 0.1F
    override val speed: Float = 0.2F
    override val agility: Float = 0.7F
    override val force: Float = 0.4F

    override fun makeSound() {
        println("Sssssssss")
    }
}