class JumpIn {

    fun solve(vararg board: String): String {

        val move = solve('W', Board(board))

        return if (move.isEmpty()) "" else "W($move)"
    }

    private fun solve(bunny: Char, board: Board): String {

        val rabbit = board.locate(bunny)

        if (board.inHole(rabbit))
            return ""

        if (board.pieceAt(rabbit.plus( west)) == 'M') return "W"
        if (board.pieceAt(rabbit.plus(north)) == 'M') return "N"
        if (board.pieceAt(rabbit.plus( east)) == 'M') return "E"
        if (board.pieceAt(rabbit.plus(south)) == 'M') return "S"

        return ""
    }
}

val  west = Vector( 0, -1)
val north = Vector(-1,  0)
val  east = Vector( 0,  1)
val south = Vector( 1,  0)

class Board(private val board: Array<out String>) {

    fun pieceAt(coordinate: Coordinate) =
            if (coordinate !in this) null else board[coordinate.row][coordinate.col]

    operator fun contains(coordinate: Coordinate) =
            coordinate.row in 0 until board.size &&
            coordinate.col in 0 until board.size

    fun locate(piece: Char): Coordinate {
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

    fun inHole(rabbit: Coordinate): Boolean {
        val maxOrdinate = board.size - 1
        val minOrdinate = 0

        return rabbit == Coordinate(minOrdinate    , minOrdinate    ) ||
               rabbit == Coordinate(minOrdinate    , maxOrdinate    ) ||
               rabbit == Coordinate(maxOrdinate    , minOrdinate    ) ||
               rabbit == Coordinate(maxOrdinate    , maxOrdinate    ) ||
               rabbit == Coordinate(maxOrdinate / 2, maxOrdinate / 2)
    }

}

data class Coordinate(val row: Int, val col: Int) {
    fun plus(vector: Vector) = Coordinate(row + vector.rowDelta,
                                          col + vector.colDelta)
}

data class Vector(val rowDelta: Int, val colDelta: Int)
