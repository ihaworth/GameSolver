
class JumpIn {

    fun solve(vararg board: String): String {

        val rabbit = locate('W', board)

        if (rabbit.col > 0 && pieceAt(rabbit. west(), board) == 'M') return "W" + "(W)"
        if (rabbit.row > 0 && pieceAt(rabbit.north(), board) == 'M') return "W" + "(N)"
        if (rabbit.col < 4 && pieceAt(rabbit. east(), board) == 'M') return "W" + "(E)"
        if (rabbit.row < 4 && pieceAt(rabbit.south(), board) == 'M') return "W" + "(S)"

        return ""
    }

    private fun pieceAt(coord: Coordinate, board: Array<out String>): Char {
        return board[coord.row][coord.col]
    }


    private fun locate(piece: Char, board: Array<out String>): Coordinate {
        var rabbitRow = -1
        var rabbitCol = -1

        for (row in 0..4)
            for (col in 0..4)
                if (board[row][col] == piece) {
                    rabbitRow = row
                    rabbitCol = col
                    break
                }
        return Coordinate(rabbitRow, rabbitCol)
    }

}

class Coordinate(val row: Int, val col: Int) {
    constructor(pair: Pair<Int, Int>) : this(pair.first, pair.second)

    fun  west() = Coordinate(row    , col - 1)
    fun north() = Coordinate(row - 1, col    )
    fun  east() = Coordinate(row    , col + 1)
    fun south() = Coordinate(row + 1, col    )
}
