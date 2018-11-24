class JumpIn {

    fun solve(vararg board: String): String {

        val move = solve('W', Board(board))

        return if (move.isEmpty()) "" else "W($move)"
    }

    private fun solve(bunny: Char, board: Board): String {

        val rabbit = board.locate(bunny)

        if (board.inHole(rabbit))
            return ""

        listOf(west, north, east, south).forEach { dir ->
            if (board.pieceAt(rabbit.plus(dir)) == 'M') return toText(dir)
        }

        return ""
    }

    private fun toText(dir: Vector) =
            when (dir) {
                west  -> "W"
                north -> "N"
                east  -> "E"
                south -> "S"
                else  -> ""
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

    private val maxOrdinate = board.size - 1

    fun locate(piece: Char): Coordinate {
        var rabbitRow = -1
        var rabbitCol = -1

        for (row in 0..maxOrdinate)
            for (col in 0..maxOrdinate)
                if (board[row][col] == piece) {
                    rabbitRow = row
                    rabbitCol = col
                    break
                }
        return Coordinate(rabbitRow, rabbitCol)
    }

    private val holes = setOf(Coordinate(0              , 0              ),
                              Coordinate(0              , maxOrdinate    ),
                              Coordinate(maxOrdinate    , 0              ),
                              Coordinate(maxOrdinate    , maxOrdinate    ),
                              Coordinate(maxOrdinate / 2, maxOrdinate / 2))

    fun inHole(coord: Coordinate) = coord in holes
}

data class Coordinate(val row: Int, val col: Int) {
    fun plus(vector: Vector) = Coordinate(row + vector.rowDelta,
                                          col + vector.colDelta)
}

data class Vector(val rowDelta: Int, val colDelta: Int)
