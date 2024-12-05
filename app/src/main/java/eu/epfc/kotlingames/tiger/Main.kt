package eu.epfc.kotlingames.tiger

var victories: Int = 0
var failures: Int = 0

private fun test1() {
    val tiger1 = Tiger()
    val tiger2 = Tiger()

    println("Tiger 1 Attacks Tiger 2")
    tiger1.attack(tiger2){}
    println("Tiger 1: ${tiger1.lifePoints}")
    println("Tiger 2: ${tiger2.lifePoints}")
    println()
    println("Tiger 1 Attacks Tiger 2")
    tiger1.attack(tiger2){}
    println("Tiger 1: ${tiger1.lifePoints}")
    println("Tiger 2: ${tiger2.lifePoints}")
    println()
    println("Tiger 2 Attacks Tiger 1")
    tiger2.attack(tiger1){}
    println("Tiger 1: ${tiger1.lifePoints}")
    println("Tiger 2: ${tiger2.lifePoints}")
}

private fun test2() {
    val tiger = Tiger(null, true)
    val elephant = Elephant()
    println("Before elephant attacks tiger")
    println("tiger: ${tiger.lifePoints}, elephant: ${elephant.lifePoints}")

    println()
    elephant.attack(tiger){}

    println("After elephant attacks tiger")
    println("tiger: ${tiger.lifePoints}, elephant: ${elephant.lifePoints}")
}

private fun test3() {
    val tiger = Tiger(null, true)
    tiger.getNicknameUppercase()
}

private fun test4() {
    val tiger = Tiger()
    val elephant = Elephant()

    tiger.attack(elephant) {
        println("${tiger.name} failed to attack. Damage: $it")
    }
    elephant.attack(tiger) {
        println("${elephant.name} failed to attack. Damage: $it")
    }
}

private fun askForNewGame() {
    do {
        print("Do you want to continue? (yes/no): ")
        val input = readlnOrNull()
        input?.lowercase()

        when (input) {
            "yes" -> {
                jungleGame()
            }
            "no" -> {
                println("You won $victories time(s) and you failed $failures time(s)")
                victories = 0
                failures = 0
            }
            else -> {
                println()
                println("Not a valid answer, type Yes or No.")
            }
        }
    } while (input != "yes" && input != "no")
}

private fun jungleGame() {
    val player = Tiger()
    val enemies: List<Animal> = createEnemies()

    for (enemy in enemies) {
        println()
        println("Next enemy: ${enemy.name}")

         do {
            print("Press letter 'a' to attack current enemy: ")
            val input = readlnOrNull()
            input?.lowercase()

            if( input == "a") {
                player.attack(enemy){
                    println("You failed to attack. Damage: $it")
                }
                println("Enemy life points: ${enemy.lifePoints}")
                println("Your life points: ${player.lifePoints}")
                println()
            } else {
                println("Not a valid answer, type letter 'a' to attack.")
                println()
            }
        } while ((enemy.lifePoints > 0 && player.lifePoints > 0) || input != "a")

        if (player.lifePoints <= 0) {
            println("GAME OVER")
            askForNewGame()
            ++failures
            break
        }
    }

    if (player.lifePoints > 0) {
        println("YOU WIN")
        ++victories
        askForNewGame()
    }
}

fun main() {
//    test1()
//    test2()
//    test3()
//    test4()
    jungleGame()
}