
class JumpIn {

    fun solve(vararg board: String): String {

        val (rabbitRow, rabbitCol) = locate('W', board)

        if (rabbitCol > 0 && pieceWest (board, rabbitRow, rabbitCol) == 'M') return "W" + "(W)"
        if (rabbitRow > 0 && pieceNorth(board, rabbitRow, rabbitCol) == 'M') return "W" + "(N)"
        if (rabbitCol < 4 && pieceEast (board, rabbitRow, rabbitCol) == 'M') return "W" + "(E)"
        if (rabbitRow < 4 && pieceSouth(board, rabbitRow, rabbitCol) == 'M') return "W" + "(S)"

        return ""
    }

    private fun pieceWest (board: Array<out String>, rabbitRow: Int, rabbitCol: Int) = board[rabbitRow][rabbitCol - 1]
    private fun pieceNorth(board: Array<out String>, rabbitRow: Int, rabbitCol: Int) = board[rabbitRow - 1][rabbitCol]
    private fun pieceEast (board: Array<out String>, rabbitRow: Int, rabbitCol: Int) = board[rabbitRow][rabbitCol + 1]
    private fun pieceSouth(board: Array<out String>, rabbitRow: Int, rabbitCol: Int) = board[rabbitRow + 1][rabbitCol]

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
