
class JumpIn {

    fun solve(vararg board: String): String {

        val (rabbitRow, rabbitCol) = locate('W', board)

        if (rabbitCol > 0 && pieceAt( west(Coordinate(rabbitRow, rabbitCol)), board) == 'M') return "W" + "(W)"
        if (rabbitRow > 0 && pieceAt(north(Coordinate(rabbitRow, rabbitCol)), board) == 'M') return "W" + "(N)"
        if (rabbitCol < 4 && pieceAt( east(Coordinate(rabbitRow, rabbitCol)), board) == 'M') return "W" + "(E)"
        if (rabbitRow < 4 && pieceAt(south(Coordinate(rabbitRow, rabbitCol)), board) == 'M') return "W" + "(S)"

        return ""
    }

    private fun  west(coordinate: Coordinate) = Coordinate(coordinate.row    , coordinate.col - 1)
    private fun north(coordinate: Coordinate) = Coordinate(coordinate.row - 1, coordinate.col    )
    private fun  east(coordinate: Coordinate) = Coordinate(coordinate.row    , coordinate.col + 1)
    private fun south(coordinate: Coordinate) = Coordinate(coordinate.row + 1, coordinate.col    )


    private fun pieceAt(coord: Coordinate, board: Array<out String>): Char {
        return board[coord.row][coord.col]
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

class Coordinate(val row: Int, val col: Int) {
    constructor(pair: Pair<Int, Int>) : this(pair.first, pair.second)
}
