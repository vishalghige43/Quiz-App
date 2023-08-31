package udemy.course.quizapp

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.AdaptiveIconDrawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestions : AppCompatActivity() ,View.OnClickListener{
    private var ques:TextView?=null;
    private var image:ImageView?=null;
    private var progressBar:ProgressBar?=null;
    private var progText:TextView?=null;

    private var optionOne:TextView?=null;
    private var optionTwo:TextView?=null;
    private var optionThree:TextView?=null;
    private var optionFour:TextView?=null;

    private  var btnSubmit:Button?=null;

    private var curr:Int=1;
    private var questionList:ArrayList<question> ?=null;
    private var selectedAns:Int=0;

    var userName:String?=null;
    private var correctAns:Int=0;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        ques=findViewById(R.id.quest);
        image=findViewById(R.id.flag);
        progressBar=findViewById(R.id.prgressBar);
        progText=findViewById(R.id.progressText);
        optionOne=findViewById(R.id.option_one);
        optionTwo=findViewById(R.id.option_two);
        optionThree=findViewById(R.id.option_three);
        optionFour=findViewById(R.id.option_four);
        btnSubmit=findViewById(R.id.btnSubmit);
        userName=intent.getStringExtra(list.USER_NAME);

        optionOne?.setOnClickListener(this);
        optionTwo?.setOnClickListener(this);
        optionThree?.setOnClickListener(this);
        optionFour?.setOnClickListener(this);
        btnSubmit?.setOnClickListener(this);

        questionList=list.getQues();
        setQues();
        defaultOptions();
    }

    private fun setQues() {

        var question:question=questionList!![curr-1];
        ques?.text=question.ques;
        progressBar?.progress=curr;
        progText?.text="${curr}/${questionList?.size}"
        optionOne?.text=question.optionOne;
        optionTwo?.text=question.optionTwo;
        optionThree?.text=question.optionThree;
        optionFour?.text=question.optionFour;
        image?.setImageResource(question.image);
        defaultOptions();
        btnSubmit?.text="SUBMIT";

    }
    private fun defaultOptions(){
        var options=ArrayList<TextView>();
        optionOne?.let{
            options.add(0,it);
        }
        optionTwo?.let{
            options.add(1,it);
        }
        optionThree?.let{
            options.add(2,it);
        }
        optionFour?.let{
            options.add(3,it);
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"));
            option.typeface= Typeface.DEFAULT;
            option.background=ContextCompat.getDrawable(this,R.drawable.option_bg);
        }
    }
    private fun seletedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptions();
        selectedAns=selectedOptionNum;
        tv.setTextColor(Color.parseColor("#363A43"));
        tv.setTypeface(tv.typeface,Typeface.BOLD);
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_btn);
    }
    override fun onClick(view: View?){
        when(view?.id){
            R.id.option_one->{
                optionOne?.let{
                    seletedOptionView(it,1);
                }
            }
            R.id.option_two->{
                optionTwo?.let{
                    seletedOptionView(it,2);
                }
            }
            R.id.option_three->{
                optionThree?.let{
                    seletedOptionView(it,3);
                }
            }
            R.id.option_four->{
                optionFour?.let{
                    seletedOptionView(it,4);
                }
            }
            R.id.btnSubmit->{
                if(selectedAns==0) {
                    curr++;
                    when{
                        curr<=questionList!!.size->{
                            setQues();
                        }
                        else->{
                            val intend:Intent =Intent(this,lastPage::class.java);
                            intend.putExtra(list.USER_NAME,userName);
                            intend.putExtra(list.CORRECT_ANS,correctAns);
                            intend.putExtra(list.TOTAL_QUEST, questionList!!.size);
                            startActivity(intend);
                        }
                    }
                }
                else{
                    val question=questionList?.get(curr-1);
                    if(question!!.ans!=selectedAns){
                        answerView(selectedAns,R.drawable.wrong_ans_bg);
                    }
                    else {
                        correctAns++;
                    }
                    answerView(question!!.ans,R.drawable.correct_ans_bg);

                    if(curr==questionList!!.size){
                        btnSubmit?.text="FINISH";
                    }
                    else{
                        btnSubmit?.text="NEXT";
                    }
                    selectedAns=0;
                }
            }
        }
    }
    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                optionOne?.background=ContextCompat.getDrawable(this,drawableView);
            }
            2->{
                optionTwo?.background=ContextCompat.getDrawable(this,drawableView);
            }
            3->{
                optionThree?.background=ContextCompat.getDrawable(this,drawableView);
            }
            4->{
                optionFour?.background=ContextCompat.getDrawable(this,drawableView);
            }
        }
    }

}