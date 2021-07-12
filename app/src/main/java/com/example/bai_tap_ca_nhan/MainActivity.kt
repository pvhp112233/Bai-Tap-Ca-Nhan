package com.example.bai_tap_ca_nhan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button0.setOnClickListener { appendVal("0", false) }
        button1.setOnClickListener { appendVal("1", false) }
        button2.setOnClickListener { appendVal("2", false) }
        button3.setOnClickListener { appendVal("3", false) }
        button4.setOnClickListener { appendVal("4", false) }
        button5.setOnClickListener { appendVal("5", false) }
        button6.setOnClickListener { appendVal("6", false) }
        button7.setOnClickListener { appendVal("7", false) }
        button8.setOnClickListener { appendVal("8", false) }
        button9.setOnClickListener { appendVal("9", false) }
        buttonc.setOnClickListener { appendVal(".", false) }

        // Xử lý các phím chức năng
        buttonCE.setOnClickListener { appendVal("", true) }
        buttonchia.setOnClickListener { appendVal(" / ", false) }
        buttonnhan.setOnClickListener { appendVal(" * ", false) }
        buttontru.setOnClickListener { appendVal(" - ", false) }
        buttoncong.setOnClickListener { appendVal(" + ", false) }

        buttonONC.setOnClickListener {
            tvExpression.text = tvExpression.text.toString().subSequence(0, tvExpression.text.toString().length - 1)
        }

        buttonbang.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    tvExpression.text = longResult.toString()
                } else
                    tvExpression.text = result.toString()

            } catch (e: Exception) {
            }
        }
    }

    fun appendVal(string: String, isClear: Boolean) {
        if (isClear) {
            tvExpression.text = ""
        } else {
            tvExpression.append(string)
        }
    }
}