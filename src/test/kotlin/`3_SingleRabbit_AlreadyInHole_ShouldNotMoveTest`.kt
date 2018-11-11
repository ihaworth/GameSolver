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

    @Test
    fun stayInNEHoleRatherThanJumping() {
        assertThat(jumpIn.solve("   MW",
                                "     ",
                                "     ",
                                "     ",
                                "     "), hasItem(""))
    }

    @Test
    fun stayInSWHoleRatherThanJumping() {
        assertThat(jumpIn.solve("     ",
                                "     ",
                                "     ",
                                "     ",
                                "WM   "), hasItem(""))
    }

    @Test
    fun stayInSEHoleRatherThanJumping() {
        assertThat(jumpIn.solve("     ",
                                "     ",
                                "     ",
                                "     ",
                                "   MW"), hasItem(""))
    }

}
