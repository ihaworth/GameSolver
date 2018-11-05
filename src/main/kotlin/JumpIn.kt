
class JumpIn {

    fun solve(vararg board: String): List<String> {

        return listOf(move('W', board) + move('G', board))
    }

    private fun move(bunny: Char, board: Array<out String>): String {
        val rabbit = locate(bunny, board)

        if (pieceAt(rabbit?. west(), board) == 'M') return bunny + "(" + "W" + ")"
        if (pieceAt(rabbit?.north(), board) == 'M') return bunny + "(" + "N" + ")"
        if (pieceAt(rabbit?. east(), board) == 'M') return bunny + "(" + "E" + ")"
        if (pieceAt(rabbit?.south(), board) == 'M') return bunny + "(" + "S" + ")"

        return ""
    }

    private fun pieceAt(coord: Coordinate?, board: Array<out String>): Char? {
        return coord?.pieceAt(board)
    }

    private fun locate(piece: Char, board: Array<out String>): Coordinate? {
        for (row in 0..4)
            for (col in 0..4)
                if (board[row][col] == piece) {
                    return Coordinate(row, col)
                }
        return null
    }

}

class Coordinate(val row: Int, val col: Int) {
    fun  west() = if (col == 0) null else plus( 0,-1)
    fun north() = if (row == 0) null else plus(-1, 0)
    fun  east() = if (col == 4) null else plus( 0, 1)
    fun south() = if (row == 4) null else plus( 1, 0)

    private fun plus(rowDelta: Int, colDelta: Int): Coordinate {
        return Coordinate(row + rowDelta, col + colDelta)
    }

    fun pieceAt(board: Array<out String>) = board[row][col]
}
