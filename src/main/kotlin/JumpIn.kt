
val WEST  = Vector( 0, -1)
val NORTH = Vector(-1,  0)
val EAST  = Vector( 0,  1)
val SOUTH = Vector( 1,  0)

class JumpIn {

    fun solve(vararg board: String): List<String> {

        return listOf(move('W', board) + move('G', board))
    }

    private fun move(bunny: Char, board: Array<out String>): String {
        val rabbit = locate(bunny, Board(board))

        if (pieceAt(rabbit?. west(), board) == 'M') return bunny + "(" + "W" + ")"
        if (pieceAt(rabbit?.north(), board) == 'M') return bunny + "(" + "N" + ")"
        if (pieceAt(rabbit?. east(), board) == 'M') return bunny + "(" + "E" + ")"
        if (pieceAt(rabbit?.south(), board) == 'M') return bunny + "(" + "S" + ")"

        return ""
    }

    private fun pieceAt(coord: Coordinate?, board: Array<out String>): Char? {
        return coord?.pieceAt(board)
    }

    private fun locate(piece: Char, board: Board): Coordinate? {
        for (row in 0..4)
            for (col in 0..4)
                if (board.board[row][col] == piece) {
                    return Coordinate(row, col)
                }
        return null
    }
}

class Board(val board: Array<out String>) {

}

class Coordinate(val row: Int, val col: Int) {
    fun  west() = if (col == 0) null else this + WEST
    fun north() = if (row == 0) null else this + NORTH
    fun  east() = if (col == 4) null else this + EAST
    fun south() = if (row == 4) null else this + SOUTH

    operator fun plus(vector: Vector): Coordinate {
        return Coordinate(row + vector.rowDelta, col + vector.colDelta)
    }

    fun pieceAt(board: Array<out String>) = board[row][col]
}

class Vector(val rowDelta: Int, val colDelta: Int) {}
