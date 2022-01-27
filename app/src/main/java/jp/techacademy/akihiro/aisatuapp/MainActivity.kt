package jp.techacademy.akihiro.aisatuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import jp.techacademy.akihiro.aisatuapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button1) {
            showTimePickerDialog()
        }
    }
    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                if (hour >= 2 && hour < 10) {
                    binding.textView.text = "おはよう"
                } else if (hour >= 10 && hour < 18) {
                    binding.textView.text = "こんにちは"
                } else if ( (hour >= 18 && hour < 24) || (hour >= 0 && hour < 2) ) {
                    binding.textView.text = "こんばんは"
                }
            },
            13, 0, true)
        timePickerDialog.show()
    }
}