package com.profitmed.arx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.profitmed.arx.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IMainView {

    companion object {
        const val PRESENTER_KEY = "PRESENTER"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainPresenter
    private lateinit var mapCounter: Map<Button, Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainPresenter(this)

        mapCounter = mapOf(
            binding.btnCounter1 to 0,
            binding.btnCounter2 to 1,
            binding.btnCounter3 to 2
        )

        initAll()
    }

    private fun initAll() {
        initViews()
        initListeners()
    }

    private fun initViews() {
        for (it in mapCounter) {
            it.key.setCounter(it.value)
        }
    }

    private fun initListeners() {
        val listener = View.OnClickListener {
            presenter.counterClick(it.getCounterIndexByViewId())
        }
        for (it in mapCounter) {
            it.key.setOnClickListener(listener)
        }
    }

    override fun setButtonText(index: Int, text: String) {
        for (it in mapCounter) {
            if (it.value == index) {
                it.key.text = text
            }
        }
    }

    private fun View.getCounterIndexByViewId(): Int {
        return mapCounter[this] ?: -1
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(PRESENTER_KEY, presenter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        presenter = savedInstanceState.getSerializable(PRESENTER_KEY) as MainPresenter
        initAll()
    }

    private fun Button.setCounter(index: Int) {
        try {
            this.text = presenter.getCurrent(index).toString()
        }
        catch (ex: Exception) {
            Log.d("SET_COUNTER", "Ошибка установки счетчика индексом $index, по причине: ${ex.message}")
        }
    }
}