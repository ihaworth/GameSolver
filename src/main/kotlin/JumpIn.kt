
class JumpIn {

    fun solve(vararg board: String): String {

        val (rabbitRow, rabbitCol) = locate('W', board)

        if (rabbitCol > 0 && pieceAt(west (rabbitRow, rabbitCol), board) == 'M') return "W" + "(W)"
        if (rabbitRow > 0 && pieceAt(north(rabbitRow, rabbitCol), board) == 'M') return "W" + "(N)"
        if (rabbitCol < 4 && pieceAt(east (rabbitRow, rabbitCol), board) == 'M') return "W" + "(E)"
        if (rabbitRow < 4 && pieceAt(south(rabbitRow, rabbitCol), board) == 'M') return "W" + "(S)"

        return ""
    }

    private fun  west(row: Int, col: Int): Pair<Int, Int> = Pair(row    , col - 1)
    private fun north(row: Int, col: Int): Pair<Int, Int> = Pair(row - 1, col    )
    private fun  east(row: Int, col: Int): Pair<Int, Int> = Pair(row    , col + 1)
    private fun south(row: Int, col: Int): Pair<Int, Int> = Pair(row + 1, col    )


    private fun pieceAt(coord: Pair<Int, Int>, board: Array<out String>): Char {
        val (row, col) = coord
        return board[row][col]
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
