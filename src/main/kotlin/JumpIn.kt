class JumpIn {

    fun solve(vararg board: String): String {

        val rabbit = locate('W', board)

        val max_ordinate = board.size - 1
        val min_ordinate = 0

        if (rabbit == Coordinate(min_ordinate    , min_ordinate    ) ||
            rabbit == Coordinate(min_ordinate    , max_ordinate    ) ||
            rabbit == Coordinate(max_ordinate    , min_ordinate    ) ||
            rabbit == Coordinate(max_ordinate    , max_ordinate    ) ||
            rabbit == Coordinate(max_ordinate / 2, max_ordinate / 2))
            return ""

        if (pieceAt(rabbit. west(), board) == 'M') return "W" + "(W)"
        if (pieceAt(rabbit.north(), board) == 'M') return "W" + "(N)"
        if (pieceAt(rabbit. east(), board) == 'M') return "W" + "(E)"
        if (pieceAt(rabbit.south(), board) == 'M') return "W" + "(S)"

        return ""
    }

    private fun pieceAt(coord: Coordinate?, board: Array<out String>): Char? {
        if (coord == null) return null
        return board[coord.row][coord.col]
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

data class Coordinate(val row: Int, val col: Int) {
    fun  west() = if (col == 0) null else Coordinate(row    , col - 1)
    fun north() = if (row == 0) null else Coordinate(row - 1, col    )
    fun  east() = if (col == 4) null else Coordinate(row    , col + 1)
    fun south() = if (row == 4) null else Coordinate(row + 1, col    )
}
