
class JumpIn {

    fun solve(vararg board: String): String {
        if (board[0][1] == 'M' && board[0][2] == 'W')
            return "W(W)"
        if (board[1][0] == 'M' && board[2][0] == 'W')
            return "W(N)"

        if (board[0][3] == 'M' && board[0][2] == 'W')
            return "W(E)"
        if (board[1][4] == 'M' && board[2][4] == 'W')
            return "W(N)"

        if (board[4][1] == 'M' && board[4][2] == 'W')
            return "W(W)"
        if (board[3][0] == 'M' && board[2][0] == 'W')
            return "W(S)"

        if (board[4][3] == 'M' && board[4][2] == 'W')
            return "W(E)"
        if (board[3][4] == 'M' && board[2][4] == 'W')
            return "W(S)"

        if (board[1][2] == 'M' && board[0][2] == 'W')
            return "W(S)"
        if (board[2][3] == 'M' && board[2][4] == 'W')
            return "W(W)"
        if (board[3][2] == 'M' && board[4][2] == 'W')
            return "W(N)"
        if (board[2][1] == 'M' && board[2][0] == 'W')
            return "W(E)"

        return ""
    }
}