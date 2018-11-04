
class JumpIn {

    fun solve(vararg board: String): String {

        val (rabbitRow, rabbitCol) = locate('W', board)

        if (rabbitCol > 0 && pieceAt(Coordinate(rabbitRow, rabbitCol). west(), board) == 'M') return "W" + "(W)"
        if (rabbitRow > 0 && pieceAt(Coordinate(rabbitRow, rabbitCol).north(), board) == 'M') return "W" + "(N)"
        if (rabbitCol < 4 && pieceAt(Coordinate(rabbitRow, rabbitCol). east(), board) == 'M') return "W" + "(E)"
        if (rabbitRow < 4 && pieceAt(Coordinate(rabbitRow, rabbitCol).south(), board) == 'M') return "W" + "(S)"

        return ""
    }

    private fun pieceAt(coord: Coordinate, board: Array<out String>): Char {
        return board[coord.row][coord.col]
    }


    private fun locate(piece: Char, board: Array<out String>): Pair<Int, Int> {
        var rabbitRow = -1
        var rabbitCol = -1

        for (row in 0..4)
            for (col in 0..4)
                if (board[row][col] == piece) {
                    rabbitRow = row
                    rabbitCol = col
                    break
                }
        return Pair(rabbitRow, rabbitCol)
    }

}

class Coordinate(val row: Int, val col: Int) {
    constructor(pair: Pair<Int, Int>) : this(pair.first, pair.second)

    fun  west() = Coordinate(row    , col - 1)
    fun north() = Coordinate(row - 1, col    )
    fun  east() = Coordinate(row    , col + 1)
    fun south() = Coordinate(row + 1, col    )
}
