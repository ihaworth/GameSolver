class JumpIn {

    fun solve(vararg board: String): String {

        val move = solve(board, 'W')

        return if (move.isEmpty()) "" else "W($move)"
    }

    private fun solve(board: Array<out String>, bunny: Char): String {

        val rabbit = locate(bunny, board)

        val max_ordinate = board.size - 1
        val min_ordinate = 0

        if (rabbit == Coordinate(min_ordinate    , min_ordinate    ) ||
            rabbit == Coordinate(min_ordinate    , max_ordinate    ) ||
            rabbit == Coordinate(max_ordinate    , min_ordinate    ) ||
            rabbit == Coordinate(max_ordinate    , max_ordinate    ) ||
            rabbit == Coordinate(max_ordinate / 2, max_ordinate / 2))
            return ""

        val board1 = Board(board)
        if (board1.pieceAt1(rabbit.plus( west)) == 'M') return "W"
        if (board1.pieceAt1(rabbit.plus(north)) == 'M') return "N"
        if (board1.pieceAt1(rabbit.plus( east)) == 'M') return "E"
        if (board1.pieceAt1(rabbit.plus(south)) == 'M') return "S"

        return ""
    }


    private fun locate(piece: Char, board: Array<out String>): Coordinate {
        var rabbitRow = -1
        var rabbitCol = -1

        val max_ordinate = board.size - 1

        for (row in 0..max_ordinate)
            for (col in 0..max_ordinate)
                if (board[row][col] == piece) {
                    rabbitRow = row
                    rabbitCol = col
                    break
                }
        return Coordinate(rabbitRow, rabbitCol)
    }

}

val  west = Vector( 0, -1)
val north = Vector(-1,  0)
val  east = Vector( 0,  1)
val south = Vector( 1,  0)

class Board(val board: Array<out String>) {

    fun pieceAt1(coordinate: Coordinate) = pieceAt(limitToBoard(coordinate))

    fun pieceAt(coord: Coordinate?) =
            coord?.let { board[it.row][it.col] }

    fun limitToBoard(coordinate: Coordinate): Coordinate? =
            if (coordinate !in this) null else coordinate

    operator fun contains(coordinate: Coordinate) =
            coordinate.row in 0 until board.size &&
            coordinate.col in 0 until board.size
}

data class Coordinate(val row: Int, val col: Int) {
    fun plus(vector: Vector) = Coordinate(row + vector.rowDelta, col + vector.colDelta)
}

data class Vector(val rowDelta: Int, val colDelta: Int) {
}
