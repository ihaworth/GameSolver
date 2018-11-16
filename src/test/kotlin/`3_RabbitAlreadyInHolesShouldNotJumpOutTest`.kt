import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class SingleRabbitAlreadyInHolesShouldNotJumpOutTest {

    private val jumpIn = JumpIn()

    @Test
    fun alreadyInTopLeftHoleShouldNotJumpEast() {
        assertThat(jumpIn.solve(

                "WM   ",
                "     ",
                "     ",
                "     ",
                "     "), equalTo(""))
    }

    @Test
    fun alreadyInTopLeftHoleShouldNotJumpSouth() {
        assertThat(jumpIn.solve(

                "W    ",
                "M    ",
                "     ",
                "     ",
                "     "), equalTo(""))
    }

}
