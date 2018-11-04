
class JumpIn {

    fun solve(vararg board: String): String {

        val (rabbitRow, rabbitCol) = locate(board)

        if ((board[0][2] == 'W' && board[rabbitRow][rabbitCol - 1] == 'M') ||
            (board[4][2] == 'W' && board[rabbitRow][rabbitCol - 1] == 'M') ||
            (board[2][4] == 'W' && board[rabbitRow][rabbitCol - 1] == 'M'))
            return "W(W)"

        if ((board[2][0] == 'W' && board[rabbitRow - 1][rabbitCol] == 'M') ||
            (board[2][4] == 'W' && board[rabbitRow - 1][rabbitCol] == 'M') ||
            (board[4][2] == 'W' && board[rabbitRow - 1][rabbitCol] == 'M'))
            return "W(N)"

        if ((board[0][2] == 'W' && board[rabbitRow][rabbitCol + 1] == 'M') ||
            (board[4][2] == 'W' && board[rabbitRow][rabbitCol + 1] == 'M') ||
            (board[2][0] == 'W' && board[rabbitRow][rabbitCol + 1] == 'M'))
            return "W(E)"

        if ((board[2][0] == 'W' && board[rabbitRow + 1][rabbitCol] == 'M') ||
            (board[2][4] == 'W' && board[rabbitRow + 1][rabbitCol] == 'M') ||
            (board[0][2] == 'W' && board[rabbitRow + 1][rabbitCol] == 'M'))
            return "W(S)"

        return ""
    }

    private fun locate(board: Array<out String>): Pair<Int, Int> {
        var rabbitRow = -1
        var rabbitCol = -1

        for (row in 0..4)
            for (col in 0..4)
                if (board[row][col] == 'W') {
                    rabbitRow = row
                    rabbitCol = col
                    break
                }
        return Pair(rabbitRow, rabbitCol)
    }

}
