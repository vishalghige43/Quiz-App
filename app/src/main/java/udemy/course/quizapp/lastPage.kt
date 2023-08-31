package udemy.course.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class lastPage : AppCompatActivity() {



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_page)
        var userName:TextView= findViewById(R.id.Name);
        var score:TextView=findViewById(R.id.score);
        var btn:Button?=findViewById(R.id.btn_last);

        userName.text=intent.getStringExtra(list.USER_NAME);
        val totalQues=intent.getIntExtra(list.TOTAL_QUEST,0);
        val corrAns=intent.getIntExtra(list.CORRECT_ANS,0);

        score.text="Your Score is $corrAns out of $totalQues"

        btn?.setOnClickListener{
            val intend:Intent=Intent(this,MainActivity::class.java);
            startActivity(intend);
        }
    }
}