
val WEST  = Vector( 0, -1)
val NORTH = Vector(-1,  0)
val EAST  = Vector( 0,  1)
val SOUTH = Vector( 1,  0)

class JumpIn {

    fun solve(vararg board: String): List<String> {

        return listOf(move('W', board) + move('G', board))
    }

    private fun move(bunny: Char, board: Array<out String>): String {
        val rabbit = Board(board).locate(bunny)

        if (pieceAt(rabbit?.validate(rabbit + WEST ), board) == 'M') return bunny + "(" + "W" + ")"
        if (pieceAt(rabbit?.validate(rabbit + NORTH), board) == 'M') return bunny + "(" + "N" + ")"
        if (pieceAt(rabbit?.validate(rabbit + EAST ), board) == 'M') return bunny + "(" + "E" + ")"
        if (pieceAt(rabbit?.validate(rabbit + SOUTH), board) == 'M') return bunny + "(" + "S" + ")"

        return ""
    }

    private fun pieceAt(coord: Coordinate?, board: Array<out String>): Char? {
        return coord?.pieceAt(board)
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
}

class Coordinate(val row: Int, val col: Int) {
    fun validate(coordinate: Coordinate): Coordinate? {
        if (coordinate.row in 0..4 && coordinate.col in 0..4)
            return coordinate
        return null
    }

    operator fun plus(vector: Vector): Coordinate {
        return Coordinate(row + vector.rowDelta, col + vector.colDelta)
    }

    fun pieceAt(board: Array<out String>) = board[row][col]
}

class Vector(val rowDelta: Int, val colDelta: Int) {}
