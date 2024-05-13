package com.example.myandroidproject.ui.theme.Screens.ContactUs

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ContactUs(navController: NavHostController){
class ContactUsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        val editTextName = EditText(this)
        editTextName.hint = "Name"
        layout.addView(editTextName)

        val editTextEmail = EditText(this)
        editTextEmail.hint = "Email"
        layout.addView(editTextEmail)

        val editTextMessage = EditText(this)
        editTextMessage.hint = "Message"
        editTextMessage.setLines(5)
        layout.addView(editTextMessage)

        val buttonSend = Button(this)
        buttonSend.text = "Send"
        buttonSend.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val message = editTextMessage.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || message.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: Send message (e.g., via email, API, etc.)
                // For demonstration, just show a toast message
                Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show()
                // Clear input fields
                editTextName.setText("")
                editTextEmail.setText("")
                editTextMessage.setText("")
            }
        }
        layout.addView(buttonSend)

        setContentView(layout)

    }
}
}
@Preview
@Composable
fun ContactUsPreview(){
    ContactUs(rememberNavController() )
}