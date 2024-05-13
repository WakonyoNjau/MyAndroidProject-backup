package com.example.myandroidproject.ui.theme.Screens.OurServices

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import java.io.File


@Composable
fun ItineraryScreen(navController: NavController){
    class MainActivity : AppCompatActivity() {

        private lateinit var editText: EditText

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            val mainLayout = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
                setPadding(16, 16, 16, 16)

                editText = EditText(context).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    hint = "Create your own itinerary here"
                    maxLines = 10
                    isVerticalScrollBarEnabled = true
                }

                val saveButton = Button(context).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    text = "Save"
                    setOnClickListener {
                        val textToSave = editText.text.toString()
                        saveTextToFile(textToSave)
                    }
                }

                addView(editText)
                addView(saveButton)
            }

            setContentView(mainLayout)

            // Load existing text from file
            val savedText = loadTextFromFile()
            editText.setText(savedText)
        }

        private fun saveTextToFile(text: String) {
            val file = File(getInternalStoragePath(), "notes.txt")
            file.writeText(text)
        }

        private fun loadTextFromFile(): String {
            val file = File(getInternalStoragePath(), "notes.txt")
            return if (file.exists()) {
                file.readText()
            } else {
                ""
            }
        }

        private fun getInternalStoragePath(): String {
            return filesDir.toString()
        }
    }


}
@Preview
@Composable
fun ItineraryScreenPreview(){
    ItineraryScreen(rememberNavController())
}
