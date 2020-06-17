package com.example.kotlintask.View

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlintask.R
import com.example.kotlintask.databinding.AnswerQuestionsActivityBinding
import com.example.kotlintask.viewModel.AnswerViewModel

class AnswerQuestionActivity : AppCompatActivity()  {

    var binding: AnswerQuestionsActivityBinding? = null
    var viewmodel: AnswerViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.answer_questions_activity)
        viewmodel = ViewModelProviders.of(this).get(AnswerViewModel::class.java)
        binding?.viewmodel = viewmodel
        initObservables()
    }

    private fun initObservables() {
        viewmodel?.uiEventLiveData?.observe(this, Observer {
            if (it == 1) {
                Toast.makeText(this, "Done", Toast.LENGTH_LONG).show()
                startActivity(Intent(this,ResultActivity::class.java))

            }else{
                Toast.makeText(this, R.string.answer_wrong, Toast.LENGTH_LONG).show()
            }
        })



    }


}