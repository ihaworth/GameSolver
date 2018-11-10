
val WEST  = Vector( 0, -1)
val NORTH = Vector(-1,  0)
val EAST  = Vector( 0,  1)
val SOUTH = Vector( 1,  0)

class JumpIn {

    fun solve(vararg board: String): List<String> {

        val board1 = Board(board)
        val board2 = Board(board)
        val board3 = Board(board)
        return listOf(
                (board1.locate('W')?.let { move(board1, it, 'W') } ?: "") +
                (board2.locate('G')?.let { move(board2, it, 'G') } ?: "") +
                (board3.locate('B')?.let { move(board3, it, 'B') } ?: ""))
    }

    private fun move(board: Board, rabbit: Coordinate, bunny: Char): String {
        var move = ""
        listOf(WEST, NORTH, EAST, SOUTH).forEach { dir ->
            if (board.pieceAt(rabbit.plus(dir)) == 'M') move += bunny + "(" + output(dir) + ")"
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

class Board(private val board: Array<out String>) {
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

    fun pieceAt(coord: Coordinate): Char? = if (coord in this) board[coord.row][coord.col] else null

    operator fun contains(coord: Coordinate) = coord.row in (0 until height) &&
                                               coord.col in (0 until width)

}

class Coordinate(val row: Int, val col: Int) {

    operator fun plus(vector: Vector) = Coordinate(row + vector.rowDelta,
                                                   col + vector.colDelta)
}

class Vector(val rowDelta: Int, val colDelta: Int) {}
