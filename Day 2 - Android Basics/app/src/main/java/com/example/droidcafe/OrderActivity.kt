package com.example.droidcafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class OrderActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Create the spinner
        val spinner: Spinner? = findViewById(R.id.label_spinner)
        spinner?.onItemSelectedListener = this
        // Create ArrayAdapter using the string array and default spinner layout.

        // Create ArrayAdapter using the string array and default spinner layout.
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter
            .createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item)
        // Specify the layout to use when the list of choices appears

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner.
        spinner?.adapter = adapter
        // ... End of onCreate code ...
    }

    fun onRadioButtonClicked(view: View) {

        // Is the button now checked?
        val checked: Boolean = (view as? RadioButton)?.isChecked == true
        // Check which radio button was clicked.
        when (view.id) {
            R.id.sameday -> {
                // Same day service
                if (checked)
                    displayToast(getString(R.string.same_day_messenger_service))
            }
            R.id.nextday -> {
                // Next day delivery
                if (checked)
                    displayToast(getString(R.string.next_day_ground_delivery))
            }
            R.id.pickup -> {
                // Pick up
                if (checked)
                    displayToast(getString(R.string.pick_up))
            }
        }
    }

    fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT)
            .show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val spinnerLabel = parent?.getItemAtPosition(position).toString()
        displayToast(spinnerLabel)
    }

    override fun onNothingSelected(parent: AdapterView<*>) {}

}
