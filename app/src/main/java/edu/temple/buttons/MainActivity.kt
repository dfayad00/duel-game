package edu.temple.buttons

import android.graphics.drawable.ClipDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.lang.StringBuilder
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val player2Health = findViewById<TextView>(R.id.player2health)
        val player1Health = findViewById<TextView>(R.id.player1health)
        val healthBar1 = findViewById<TextView>(R.id.healthBar1)
        val healthBar2 = findViewById<TextView>(R.id.healthBar2)
        val narrator1 = findViewById<TextView>(R.id.narrator1)
        val narrator2 = findViewById<TextView>(R.id.narrator2)
        val actionButton = findViewById<Button>(R.id.actionButton)
        val resetButton = findViewById<Button>(R.id.resetButton)


        val player1 = Player(10, healthBar1)
        val player2 = Player(10, healthBar2)
        player1.getHealthBar()
        player2.getHealthBar()

        resetButton.setOnClickListener {
            player1.getHealthBar()
            player2.getHealthBar()
            player1Health.text = player1.health.toString()
            player2Health.text = player2.health.toString()
        }

        //pick a and execute random move for each player
        actionButton.setOnClickListener {
            val p1move = player1.getMove()
            val p2move = player2.getMove()

            //player 1 move
            narrator1.text = p1move
            player2.health = player1.doMove(player2, p2move, p1move)
            //Log.e("log","Player 1 $p1move player 2")

            //player 2 move
            narrator2.text = p2move
            player1.health = player2.doMove(player1, p1move, p2move)
            //Log.e("log","Player 2 $p2move player 1\n")

            player1Health.text = player1.health.toString()
            player2Health.text = player2.health.toString()
        }
    }
}