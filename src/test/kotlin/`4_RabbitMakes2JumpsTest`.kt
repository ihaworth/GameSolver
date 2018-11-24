import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class SingleRabbitMakes2JumpsTest {

    private val jumpIn = JumpIn()

    @Test
    fun jumpNWtoEndUpInNWHole() {
        assertThat(jumpIn.solve(

                " M     ",
                "  M    ",
                "  W    ",
                "       ",
                "       ",
                "       ",
                "       "), equalTo("W(NW)"))
    }

    @Test
    fun jumpWNtoEndUpInNWHole() {
        assertThat(jumpIn.solve(

                "       ",
                "M      ",
                " MW    ",
                "       ",
                "       ",
                "       ",
                "       "), equalTo("W(WN)"))
    }

    @Test
    fun jumpNEtoEndUpInNEHole() {
        assertThat(jumpIn.solve(

                "     M ",
                "    M  ",
                "    W  ",
                "       ",
                "       ",
                "       ",
                "       "), equalTo("W(NE)"))
    }

}
