import org.hamcrest.CoreMatchers.hasItem
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
                "     "), hasItem(""))
    }

    @Test
    fun alreadyInTopRightHole() {
        assertThat(jumpIn.solve(

                "    W",
                "     ",
                "     ",
                "     ",
                "     "), hasItem(""))
    }

    @Test
    fun alreadyInBottomLeftHole() {
        assertThat(jumpIn.solve(

                "     ",
                "     ",
                "     ",
                "     ",
                "W    "), hasItem(""))
    }

    @Test
    fun alreadyInBottomRightHole() {
        assertThat(jumpIn.solve(

                "     ",
                "     ",
                "     ",
                "     ",
                "    W"), hasItem(""))
    }

    @Test
    fun alreadyInCentralHole() {
        assertThat(jumpIn.solve(

                "     ",
                "     ",
                "  W  ",
                "     ",
                "     "), hasItem(""))
    }

}
