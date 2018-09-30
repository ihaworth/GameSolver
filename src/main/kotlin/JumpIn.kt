
class JumpIn {

    fun solve(vararg board: String): String {

        if ((board[0][2] == 'W' && board[0][1] == 'M') ||
            (board[4][2] == 'W' && board[4][1] == 'M') ||
            (board[2][4] == 'W' && board[2][3] == 'M'))
            return "W(W)"

        if ((board[2][0] == 'W' && board[1][0] == 'M') ||
            (board[2][4] == 'W' && board[1][4] == 'M') ||
            (board[4][2] == 'W' && board[3][2] == 'M'))
            return "W(N)"

        if ((board[0][2] == 'W' && board[0][3] == 'M') ||
            (board[4][2] == 'W' && board[4][3] == 'M') ||
            (board[2][0] == 'W' && board[2][1] == 'M'))
            return "W(E)"

        if ((board[2][0] == 'W' && board[3][0] == 'M') ||
            (board[2][4] == 'W' && board[3][4] == 'M') ||
            (board[0][2] == 'W' && board[1][2] == 'M'))
            return "W(S)"

        return ""
    }
}