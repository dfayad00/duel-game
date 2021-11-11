package edu.temple.buttons

fun getMoveList() : ArrayList<String> {
    val moves = ArrayList<String>()
    moves.add("Attack") //attack
    moves.add("Block") //block
    moves.add("Counter") //counter
    moves.add("Nothing") //nothing

    return moves
}

class Player(_health: Int) {
    var health = _health

    fun getMove() : String {
        val moves = getMoveList()
        return moves.random()
    }

    fun doMove(opponent: Player, opponentMove: String, userMove: String): Int {
        when(userMove) {
            "Attack" -> {
                if(opponentMove != "Block" && opponentMove != "Counter")
                    opponent.health--
            }
            "Counter" -> {
                if(opponentMove == "Attack")
                    opponent.health -= 2
                else
                    health--
            }
        }

        return opponent.health
    }
}