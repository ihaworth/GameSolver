
val WEST  = Vector( 0, -1)
val NORTH = Vector(-1,  0)
val EAST  = Vector( 0,  1)
val SOUTH = Vector( 1,  0)

class JumpIn {

    fun solve(vararg board: String): List<String> {

        return listOf(move('W', Board(board)) + move('G', Board(board)))
    }

    private fun move(bunny: Char, board: Board): String {
        val rabbit = board.locate(bunny)

        var move = ""

        if (rabbit != null) {
            listOf(WEST, NORTH, EAST, SOUTH).forEach {dir ->
                if (board.pieceAt(rabbit.plus(dir)) == 'M') move += bunny + "(" + output(dir) + ")"
            }
        }

        return move
    }

    private fun output(vector: Vector): String {
        when (vector) {
            WEST  -> return "W"
            NORTH -> return "N"
            EAST  -> return "E"
            SOUTH -> return "S"
            else  -> return ""
        }
    }

}

class Board(val board: Array<out String>) {
    val height = board.size
    val width  = board.first().length

    fun locate(piece: Char): Coordinate? {
        for (row in 0 until height)
            for (col in 0 until width)
                if (this.board[row][col] == piece) {
                    return Coordinate(row, col)
                }
        return null
    }

    fun pieceAt(coord: Coordinate): Char? {
        return validate(coord)?.let { this.board[it.row][it.col] }
    }

    private fun validate(coord: Coordinate): Coordinate? {
        return coord.let { if (it.row in 0 until height && it.col in 0 until width) it else null }
    }

}

class Coordinate(val row: Int, val col: Int) {

    operator fun plus(vector: Vector): Coordinate {
        return Coordinate(row + vector.rowDelta, col + vector.colDelta)
    }

}

class Vector(val rowDelta: Int, val colDelta: Int) {}
