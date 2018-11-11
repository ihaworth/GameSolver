import org.hamcrest.CoreMatchers.hasItem
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Ignore
import org.junit.Test

class SingleRabbit_AlreadyInHole_ShouldNotMoveTest {

    private val jumpIn = JumpIn()

    @Test
    fun stayInNWHoleRatherThanJumping() {
        assertThat(jumpIn.solve("WM   ",
                                "     ",
                                "     ",
                                "     ",
                                "     "), hasItem(""))
    }

}
