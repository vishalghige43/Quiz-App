package udemy.course.quizapp

data class question(
    val id:Int,
    val ques:String,
    val image:Int,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val ans:Int,
)
