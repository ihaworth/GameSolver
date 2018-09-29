
class JumpIn {

    fun solve(vararg config: String): String {
        if (config[0][1] == 'M')
            return "W(W)"
        if (config[1][0] == 'M')
            return "W(N)"
        return ""
    }
}