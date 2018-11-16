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

    @Test
    fun alreadyInTopRightHoleShouldNotJumpWest() {
        assertThat(jumpIn.solve(

                "   MW",
                "     ",
                "     ",
                "     ",
                "     "), equalTo(""))
    }

    @Test
    fun alreadyInTopRightHoleShouldNotJumpSouth() {
        assertThat(jumpIn.solve(

                "    W",
                "    M",
                "     ",
                "     ",
                "     "), equalTo(""))
    }

    @Test
    fun alreadyInBottomLeftHoleShouldNotJumpEast() {
        assertThat(jumpIn.solve(

                "     ",
                "     ",
                "     ",
                "     ",
                "WM   "), equalTo(""))
    }

    @Test
    fun alreadyInBottomLeftHoleShouldNotJumpNorth() {
        assertThat(jumpIn.solve(

                "     ",
                "     ",
                "     ",
                "M    ",
                "W    "), equalTo(""))
    }

    @Test
    fun alreadyInBottomRightHoleShouldNotJumpWest() {
        assertThat(jumpIn.solve(

                "     ",
                "     ",
                "     ",
                "     ",
                "   MW"), equalTo(""))
    }

    @Test
    fun alreadyInBottomRightHoleShouldNotJumpNorth() {
        assertThat(jumpIn.solve(

                "     ",
                "     ",
                "     ",
                "    M",
                "    W"), equalTo(""))
    }


    @Test
    fun alreadyInCentralHoleShouldNotJumpOut() {
        assertThat(jumpIn.solve(

                "     ",
                "  M  ",
                " MWM ",
                "  M  ",
                "     "), equalTo(""))
    }

}
