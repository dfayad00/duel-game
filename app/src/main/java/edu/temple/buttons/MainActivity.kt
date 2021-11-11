package edu.temple.buttons

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val player2Health = findViewById<TextView>(R.id.player2health)
        val player1Health = findViewById<TextView>(R.id.player1health)
        val narrator1 = findViewById<TextView>(R.id.narrator1)
        val narrator2 = findViewById<TextView>(R.id.narrator2)
        val button = findViewById<Button>(R.id.button)

        val player1 = Player(10)
        val player2 = Player(15)

        button.setOnClickListener {
            val p1move = player1.getMove()
            val p2move = player2.getMove()

            //player 1 move
            narrator1.text = p1move
            player2.health = player1.doMove(player2, p2move, p1move)
            player2Health.text = player2.health.toString()

            //player 2 move
            narrator2.text = p2move
            player1.health = player2.doMove(player1, p1move, p2move)
            player1Health.text = player1.health.toString()
        }
    }
}