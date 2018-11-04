
class JumpIn {

    fun solve(vararg board: String): String {

        val (rabbitRow, rabbitCol) = locate(board)

        if (rabbitCol > 0 && board[rabbitRow    ][rabbitCol - 1] == 'M') return "W" + "(W)"
        if (rabbitRow > 0 && board[rabbitRow - 1][rabbitCol    ] == 'M') return "W" + "(N)"
        if (rabbitCol < 4 && board[rabbitRow    ][rabbitCol + 1] == 'M') return "W" + "(E)"
        if (rabbitRow < 4 && board[rabbitRow + 1][rabbitCol    ] == 'M') return "W" + "(S)"

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
