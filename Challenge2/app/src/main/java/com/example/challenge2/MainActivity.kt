package com.example.challenge2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.content.Intent
import android.view.KeyEvent
import android.net.Uri
import android.util.Log
import android.view.inputmethod.EditorInfo
import androidx.core.content.ContextCompat.startActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText? = findViewById(R.id.phone_text)
        editText?.setOnEditorActionListener(object: TextView.OnEditorActionListener{
            // If view is found, set the listener for editText
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                    var handled: Boolean = false
                    if (actionId == EditorInfo.IME_ACTION_SEND){∫
                        handled = true
                    }
                    return handled
            }
        })
    }

    private fun dialNumber() {
        // Find the editText_main view
        val editText: EditText? = findViewById(R.id.phone_text)
        var phoneNum: String? = null
        // If the editText field is not null,
        // concatenate "tel: " with the phone number string
        editText?.text.toString().let{
            phoneNum = "tel: $it"
            // Optional: Log the concatenated phone number for dialing.
            Log.d("ImplicitIntents", "dialNumber: $phoneNum")
            // Specify the intent.
            val intent = Intent(Intent.ACTION_DIAL)
            // Set the data for the intent as the phone number.
            intent.data = Uri.parse(phoneNum)
            // If the intent resolves to a package (app), start the activity with the intent
            intent.resolveActivity(packageManager)?.let {
                startActivity(intent)
            } ?: run {
                Log.d("ImplicitIntents", "Can't handle this!")
            }
        }
    }
}
