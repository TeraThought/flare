import enchant.flare.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.test.*

@OptIn(ExperimentalCoroutinesApi::class)
class AuthTest: FlareTest() {
    val auth: FirebaseAuth by lazy {
        if (useLocal) LocalAuth() else FirebaseAuth.instance
    }

    @Test
    fun signInWithEmail() = runTest {
        val info = auth.signIn(AuthMethod.EmailPassword("$testId@hi.com", "mypassword"))
        assertTrue(info.isNewUser)
        assertEquals("$testId@hi.com", auth.currentUser?.email)
    }

    @Test
    fun signOut() = runTest {
        auth.signIn(AuthMethod.EmailPassword("$testId@hi.com", "mypassword"))
        auth.signOut()
        assertNull(auth.currentUser)
    }

    @Test
    fun failSignIn() = runTest {
        auth.signIn(AuthMethod.EmailPassword("$testId@hi.com", "mypassword"))
        auth.signOut()
        try {
            auth.signIn(AuthMethod.EmailPassword("$testId@hi.com", "mywrongpassword"))
            fail()
        } catch (e: AuthException) {

        }
    }
}