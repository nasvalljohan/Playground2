
package com.jojjenator.playground2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jojjenator.playground2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var currentFloor = 1
    private var currentFloor1 = 1
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // UI Buttons & TextViews
        binding.apply {


            // Buttons for elevator #2.
            floor11.setOnClickListener{
                elevator2(1, floorText1)
            }
            floor22.setOnClickListener{
                elevator2(2, floorText1)
            }
            floor33.setOnClickListener{
                elevator2(3, floorText1)
            }
            floor44.setOnClickListener{
                elevator2(4, floorText1)
            }
            floor55.setOnClickListener{
                elevator2(5, floorText1)
            }

            // Buttons for elevator #1
            floor1.setOnClickListener{
                elevator(1, floorText)
            }
            floor2.setOnClickListener{
                elevator(2, floorText)
            }
            floor3.setOnClickListener{
                elevator(3, floorText)
            }
            floor4.setOnClickListener{
                elevator(4, floorText)
            }
            floor5.setOnClickListener{
                elevator(5, floorText)
            }

            // Button to fetch elevator, checks which is closest to 1st floor.
            fetchElevator.setOnClickListener {
                if(currentFloor > currentFloor1) {
                    elevator2(1, floorText1)
                    println("Elevator two to the rescue!!!")
                }else if(currentFloor == currentFloor1){
                    elevator(1, floorText)
                    println("I AM FASTER, THEREFORE I COME")
            }
            else {
                    elevator(1, floorText)
                    println("Elevator one to the rescue!!")
                }
            }
        }
    }

    // Function for elevator #1
    private fun elevator(input: Int, floorText: TextView){
        if(input == currentFloor) {
            println("Already on that floor")
        }else {
            if (input < currentFloor){
                println("Elevator one going down to floor $input")
                for(floor in input..currentFloor){
                        currentFloor = input
                        floorText.text = currentFloor.toString()
                }
            } else {
                println("Elevator one going up to floor $input")
                for(floor in currentFloor..input) {
                        currentFloor = input
                        floorText.text = currentFloor.toString()
                }
            }
        }
    }

    // Function for elevator #2
    private fun elevator2(input1: Int, elevatorFloorTextView: TextView){
        if(input1 == currentFloor1) {
            println("Already on that floor")
        }else {
            if (input1 < currentFloor1){
                println("Elevator two going down to floor $input1")
                for(floor in input1..currentFloor1){
                        currentFloor1 = input1
                        elevatorFloorTextView.text = currentFloor1.toString()
                }
            } else {
                println("Elevator two going up to floor $input1")
                for(floor in currentFloor1..input1) {
                        currentFloor1 = input1
                        elevatorFloorTextView.text = currentFloor1.toString()
                }
            }
        }
    }
}