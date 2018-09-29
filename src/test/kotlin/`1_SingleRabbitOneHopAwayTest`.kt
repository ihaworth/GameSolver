import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class SingleRabbitOneHopAwayTest {

    private val jumpIn = JumpIn()

    @Test
    fun jumpWestToNWHole() {
        assertThat(jumpIn.solve(

                " MW  ",
                "     ",
                "     ",
                "     ",
                "     "), equalTo("W(W)"))
    }

}
