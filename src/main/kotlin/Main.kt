package com.example

import org.example.TowerOfHanoiGame
import org.jline.reader.LineReaderBuilder
import org.jline.terminal.TerminalBuilder

fun main() {
    val game = TowerOfHanoiGame()
    val terminal = TerminalBuilder.terminal()
    val reader = LineReaderBuilder.builder().terminal(terminal).build()

    game.printGameState()

    while (!game.isGameWon()) {
        val input = reader.readLine("Enter your move (e.g., AB to move from A to B): ").trim().toUpperCase()
        if (input.length == 2 && input.all { it in 'A'..'C' }) {
            game.moveDisk(input[0], input[1])
            game.printGameState()
        } else {
            println("Invalid input. Please enter two tower letters (e.g., AB).")
        }
    }

    println("Congratulations! You've completed the Tower of Hanoi puzzle!")
}
