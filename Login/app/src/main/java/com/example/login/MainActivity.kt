import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import com.example.login.R
import com.example.login.WelcomeActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)

        editTextUsername.addTextChangedListener(loginTextWatcher)
        editTextPassword.addTextChangedListener(loginTextWatcher)

        buttonLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val username = editTextUsername.text.toString()
        val password = editTextPassword.text.toString()

        if (username == "user" && password == "1234") {
            startActivity(Intent(this, WelcomeActivity::class.java))
            finish()
        } else {
            // Handle invalid credentials
        }
    }

    private val loginTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            val usernameInput = editTextUsername.text.toString().trim()
            val passwordInput = editTextPassword.text.toString().trim()

            buttonLogin.isEnabled = usernameInput.isNotEmpty() && passwordInput.isNotEmpty()
        }
    }
}
