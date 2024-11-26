package eu.epfc.kotlingames

import java.io.File
import java.lang.Thread.sleep
import kotlin.random.Random

fun main() {
    for (i in 0..2) {
        println("Starts in ${3-i} seconds")
        sleep(1000)
    }
    println("Game Starts")

    val wordToGuess = generateWordToGuess()
    val success : String = "YOU WIN!"
    val fail : String = "GAME OVER! The word was $wordToGuess"

    val lettersPlayedByUsers : MutableList<Char> = mutableListOf()

    var maskedWord = getMaskedWordToGuess(wordToGuess, lettersPlayedByUsers)
    println("$maskedWord \n")

    for (turn in 0..7) {
        if (!maskedWord.contains('*')) {
            break
        }

        print("Type a letter: ")
        val stringInput = readLine()

        if (stringInput != null) {
            lettersPlayedByUsers += stringInput[0]
            maskedWord = getMaskedWordToGuess(wordToGuess, lettersPlayedByUsers)
            println("$maskedWord")
        }
    }

    if(maskedWord.contains('*'))
        println(fail)
    else
        println(success)
}

fun generateWordToGuess() : String {
    val dictionalyFile = File("dictionary.txt")
    val dictionary = dictionalyFile.readLines()
    val randomIndex = Random.nextInt(dictionary.count() - 1)
    return dictionary[randomIndex].lowercase()
}

fun getMaskedWordToGuess(
    wordToGuess: String,
    playedLetters: List<Char>
) : String {
    var maskedWord = ""

    for(letter in wordToGuess) {
        if(playedLetters.contains(letter))
            maskedWord += letter
        else
            maskedWord += '*'
    }

    return maskedWord
}