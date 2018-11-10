import org.hamcrest.CoreMatchers.hasItem
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class TwoRabbitsOneHopAwayTest {

    private val jumpIn = JumpIn()

    @Test
    fun twoRabbitsToMakeSingleJumps() {
        assertThat(jumpIn.solve(" MW  ",
                                "     ",
                                "    G",
                                "    M",
                                "     "), hasItem("W(W)G(S)"))
    }

    @Test
    fun twoOtherRabbitsToMakeSingleJumps() {
        assertThat(jumpIn.solve(" MG  ",
                                "     ",
                                "    B",
                                "    M",
                                "     "), hasItem("G(W)B(S)"))
    }

}
