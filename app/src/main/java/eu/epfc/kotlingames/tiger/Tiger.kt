package eu.epfc.kotlingames.tiger

class Tiger(private val nickname: String? = null): Animal() {
    override val name = "Tiger"
    override val weight: Float = 0.5F
    override val speed: Float = 0.9F
    override val agility: Float = 0.9F
    override val force: Float = 0.7F

    constructor(nickname: String?, makeSound: Boolean = false): this(nickname) {
        if(makeSound) makeSound()
    }

    override fun makeSound() {
        if(nickname != null)
            println("$nickname Grrrrrrrr")
        else
            println("$name Grrrrrrrr")
    }

    fun getNicknameUppercase(): String {
        return nickname?.uppercase() ?: name.uppercase()
    }
}