import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class SingleRabbitOneHopAwayTest {

    private val jumpIn = JumpIn()

    @Test
    fun jumpWestToNWHole() {
        assertThat(jumpIn.solve(" MW  ",
                                "     ",
                                "     ",
                                "     ",
                                "     "), equalTo("W(W)"))
    }

    @Test
    fun jumpNorthToNWHole() {
        assertThat(jumpIn.solve("     ",
                                "M    ",
                                "W    ",
                                "     ",
                                "     "), equalTo("W(N)"))
    }

    @Test
    fun jumpEastToNEHole() {
        assertThat(jumpIn.solve("  WM ",
                                "     ",
                                "     ",
                                "     ",
                                "     "), equalTo("W(E)"))
    }

    @Test
    fun jumpNorthToNEHole() {
        assertThat(jumpIn.solve("     ",
                                "    M",
                                "    W",
                                "     ",
                                "     "), equalTo("W(N)"))
    }

}
