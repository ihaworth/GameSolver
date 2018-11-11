
val WEST  = Vector( 0, -1)
val NORTH = Vector(-1,  0)
val EAST  = Vector( 0,  1)
val SOUTH = Vector( 1,  0)

class JumpIn {

    fun solve(vararg board: String): List<String> = solve(Board(board))

    private fun solve(board: Board): List<String> {

        return listOf(
                rabbitsPresent(board).
                fold("") { acc, pair -> acc + move(board, pair.second, pair.first) })
    }

    private fun rabbitsPresent(board: Board): List<Pair<Char, Coordinate>> {
        return listOf('W', 'G', 'B').
                mapNotNull { bunny -> board.locate(bunny)?.let { Pair(bunny, it) } }
    }

    private fun move(board: Board, position: Coordinate, bunny: Char): String {
        var move = ""
        if (position == Coordinate(0, 0))
            return ""
        listOf(WEST, NORTH, EAST, SOUTH).
                forEach { if (board.pieceAt(position.plus(it)) == 'M') move += bunny + "(" + output(it) + ")" }
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

data class Coordinate(val row: Int, val col: Int) {

    operator fun plus(vector: Vector) = Coordinate(row + vector.rowDelta,
                                                   col + vector.colDelta)
}

class Vector(val rowDelta: Int, val colDelta: Int) {}
