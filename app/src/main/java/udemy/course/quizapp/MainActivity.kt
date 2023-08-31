package udemy.course.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    public var userName:String?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnStart:Button=findViewById(R.id.start);
        var name:EditText=findViewById(R.id.etName);

        btnStart.setOnClickListener {
            if(name.text.isEmpty()){
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show();
            }
            else{

                val intent:Intent=Intent(this,QuizQuestions::class.java);
//                intent.putExtra(list.USER_NAME,name.text);
                startActivity(intent);
                finish();
            }

        }


    }
}