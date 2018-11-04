import org.hamcrest.CoreMatchers.hasItem
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
                                "     "), hasItem("W(W)"))
    }

    @Test
    fun jumpNorthToNWHole() {
        assertThat(jumpIn.solve("     ",
                                "M    ",
                                "W    ",
                                "     ",
                                "     "), hasItem("W(N)"))
    }

    @Test
    fun jumpEastToNEHole() {
        assertThat(jumpIn.solve("  WM ",
                                "     ",
                                "     ",
                                "     ",
                                "     "), hasItem("W(E)"))
    }

    @Test
    fun jumpNorthToNEHole() {
        assertThat(jumpIn.solve("     ",
                                "    M",
                                "    W",
                                "     ",
                                "     "), hasItem("W(N)"))
    }

    @Test
    fun jumpWestToSWHole() {
        assertThat(jumpIn.solve("     ",
                                "     ",
                                "     ",
                                "     ",
                                " MW  "), hasItem("W(W)"))
    }

    @Test
    fun jumpSouthToSWHole() {
        assertThat(jumpIn.solve("     ",
                                "     ",
                                "W    ",
                                "M    ",
                                "     "), hasItem("W(S)"))
    }

    @Test
    fun jumpEastToSWHole() {
        assertThat(jumpIn.solve("     ",
                                "     ",
                                "     ",
                                "     ",
                                "  WM "), hasItem("W(E)"))
    }

    @Test
    fun jumpSouthToSEHole() {
        assertThat(jumpIn.solve("     ",
                                "     ",
                                "    W",
                                "    M",
                                "     "), hasItem("W(S)"))
    }

    @Test
    fun jumpSouthToCentralHole() {
        assertThat(jumpIn.solve("  W  ",
                                "  M  ",
                                "     ",
                                "     ",
                                "     "), hasItem("W(S)"))
    }

    @Test
    fun jumpWestToCentralHole() {
        assertThat(jumpIn.solve("     ",
                                "     ",
                                "   MW",
                                "     ",
                                "     "), hasItem("W(W)"))
    }

    @Test
    fun jumpNorthToCentralHole() {
        assertThat(jumpIn.solve("     ",
                                "     ",
                                "     ",
                                "  M  ",
                                "  W  "), hasItem("W(N)"))
    }

    @Test
    fun jumpEastToCentralHole() {
        assertThat(jumpIn.solve("     ",
                                "     ",
                                "WM   ",
                                "     ",
                                "     "), hasItem("W(E)"))
    }

}
