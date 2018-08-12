import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class SingleRabbitAlreadyInHolesTest {

    private val jumpIn = JumpIn()

    @Test
    fun alreadyInTopLeftHole() {
        assertThat(jumpIn.solve(

                "W    ",
                "     ",
                "     ",
                "     ",
                "     "), equalTo(""))
    }

    @Test
    fun alreadyInTopRightHole() {
        assertThat(jumpIn.solve(

                "    W",
                "     ",
                "     ",
                "     ",
                "     "), equalTo(""))
    }

    @Test
    fun alreadyInBottomLeftHole() {
        assertThat(jumpIn.solve(

                "     ",
                "     ",
                "     ",
                "     ",
                "W    "), equalTo(""))
    }

    @Test
    fun alreadyInBottomRightHole() {
        assertThat(jumpIn.solve(

                "     ",
                "     ",
                "     ",
                "     ",
                "    W"), equalTo(""))
    }

    @Test
    fun alreadyInCentralHole() {
        assertThat(jumpIn.solve(

                "     ",
                "     ",
                "  W  ",
                "     ",
                "     "), equalTo(""))
    }

}
