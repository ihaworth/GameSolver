class JumpIn {

    fun solve(vararg board: String): String {

        val move = solve(board, 'W')

        return if (move.isEmpty()) "" else "W($move)"
    }

    private fun solve(board: Array<out String>, bunny: Char): String {

        val rabbit = locate(bunny, board)

        val max_ordinate = board.size - 1
        val min_ordinate = 0

        if (rabbit == Coordinate(min_ordinate    , min_ordinate    ) ||
            rabbit == Coordinate(min_ordinate    , max_ordinate    ) ||
            rabbit == Coordinate(max_ordinate    , min_ordinate    ) ||
            rabbit == Coordinate(max_ordinate    , max_ordinate    ) ||
            rabbit == Coordinate(max_ordinate / 2, max_ordinate / 2))
            return ""

        if (pieceAt(rabbit. west(board), board) == 'M') return "W"
        if (pieceAt(rabbit.north(board), board) == 'M') return "N"
        if (pieceAt(rabbit. east(board), board) == 'M') return "E"
        if (pieceAt(rabbit.south(board), board) == 'M') return "S"

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
    fun  west(board: Array<out String>) = if (col == 0             ) null else plus(Vector( 0, -1))
    fun north(board: Array<out String>) = if (row == 0             ) null else plus(Vector(-1,  0))
    fun  east(board: Array<out String>) = if (col == board.size - 1) null else plus(Vector( 0,  1))
    fun south(board: Array<out String>) = if (row == board.size - 1) null else plus(Vector( 1,  0))

    private fun plus(vector: Vector): Coordinate = Coordinate(row + vector.rowDelta, col + vector.colDelta)
}

data class Vector(val rowDelta: Int, val colDelta: Int) {
}
