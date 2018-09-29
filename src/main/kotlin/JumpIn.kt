
class JumpIn {

    fun solve(vararg config: String): String {
        if (config[0][1] == 'M')
            return "W(W)"
        if (config[1][0] == 'M')
            return "W(N)"

        if (config[0][3] == 'M')
            return "W(E)"
        if (config[1][4] == 'M')
            return "W(N)"

        if (config[4][1] == 'M')
            return "W(W)"
        if (config[3][0] == 'M')
            return "W(S)"

        if (config[4][3] == 'M')
            return "W(E)"
        if (config[3][4] == 'M')
            return "W(S)"

        return ""
    }
}