package com.zybooks.pizzaparty

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

/**
 * MainActivity for the Pizza Party app.
 *
 * This activity allows users to calculate the number of pizzas needed for a party based on
 * the number of attendees and their hunger level.
 */

const val SLICES_PER_PIZZA = 8

class MainActivity : AppCompatActivity() {

    private lateinit var numAttendEditText: EditText //Creating a reference to the edit text UI element
    private lateinit var numPizzasTextView: TextView //Creating a reference to the "total pizzas" text UI element
    private lateinit var howHungryRadioGroup: RadioGroup //Creating a reference to the Radio group UI element

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numAttendEditText = findViewById(R.id.num_attend_edit_text) //Finding the edit text UI element using its ID
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view) //Finding the "total pizzas" text UI element using its ID
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group) //Finding the radio group UI element using its ID
    }

    /**
     * Handles the click event for the calculate button.
     *
     * This function reads the number of attendees and their hunger level, calculates the
     * total number of pizzas required, and displays the result.
     *
     * @param view The view that was clicked.
     */

    fun calculateClick(view: View) {

        // Get the text that was typed into the EditText
        val numAttendStr = numAttendEditText.text.toString()

        // Convert the text into an integer
        val numAttend = numAttendStr.toInt()

        // Determine how many slices on average each person will eat
        val slicesPerPerson = when (howHungryRadioGroup.checkedRadioButtonId) {
            R.id.light_radio_button -> 2
            R.id.medium_radio_button -> 3
            else -> 4
        }

        // Calculate and show the number of pizzas needed
        val totalPizzas = ceil(numAttend * slicesPerPerson / SLICES_PER_PIZZA.toDouble()).toInt()
        numPizzasTextView.text = "Total pizzas: $totalPizzas"
    }
}