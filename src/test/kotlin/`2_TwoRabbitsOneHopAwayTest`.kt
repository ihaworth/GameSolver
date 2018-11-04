import org.hamcrest.CoreMatchers.equalTo
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
                                "     "), equalTo("W(W)G(S)"))
    }

}
