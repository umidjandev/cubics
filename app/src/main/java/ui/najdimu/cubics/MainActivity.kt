package ui.najdimu.cubics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import ui.najdimu.cubics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private val colors = arrayOf(R.color.blue,R.color.red,R.color.yellow,R.color.green)
    private val button = Array(25) {0}

    private lateinit var binding : ActivityMainBinding
    private var requiredColor: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requiredColor = colors.random()
        binding.indicator.backgroundTintList= ContextCompat.getColorStateList(this, requiredColor)


        val factor = binding.root.context.resources.displayMetrics.density


        for (i in 0..24){
            val button = AppCompatButton(this)
            val layoutParams = ViewGroup.LayoutParams((60 * factor).toInt(), (60 * factor).toInt())

            button.layoutParams= layoutParams
            button.requestLayout()

            button.randomColor(i)

            button.setOnClickListener{
                button.randomColor(i)
                check()
            }


            binding.gridLayout.addView(button)


        }

    }

    private fun check() {
        if (button.all { it == requiredColor })
        {
            Toast.makeText(this, "Winner Winner\nChicken Dinner!", Toast.LENGTH_SHORT).show()

        }
    }



    private fun AppCompatButton.randomColor(i: Int) {
        val color = colors.random()
        button[i] = color
        this.backgroundTintList = ContextCompat.getColorStateList(this@MainActivity, color)
    }


    fun randomColor() = colors.random()
}

/*
token  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


https://github.com/umidjandevo/cubics.git
 */