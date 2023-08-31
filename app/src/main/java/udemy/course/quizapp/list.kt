package udemy.course.quizapp

object list {
    const val USER_NAME:String="userName";
    const val TOTAL_QUEST:String="total ans";
    const val CORRECT_ANS:String="correct ans";

    fun getQues():ArrayList<question>{
        val questionList=ArrayList<question>();
        // 1
        val que1=question(
            1,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_india,"argentina","russia",
            "taiwan","india",4,
        );
        questionList.add(que1);
        // 2
        val que2=question(
            2,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_argentina,"egypt","russia",
            "argentina","india",3,
        );
        questionList.add(que2);
        // 3
        val que3=question(
            3,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_australia,"canada","australia",
            "japan","china",2,
        );
        questionList.add(que3);
        // 4
        val que4=question(
            4,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_belgium,"germany","russia",
            "belgium","chile",3,
        );
        questionList.add(que4);
        // 4
        val que5=question(
            5,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_brazil,"germany","france",
            "chile","brazil",4,
        );
        questionList.add(que5);
        //6
        val que6=question(
            6,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_denmark,"denmark","turkey",
            "kuwait","brazil",1,
        );
        questionList.add(que6);
        //7
        val que7=question(
            7,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_fiji,"german","fiji",
            "nepal","cuba",2,
        );
        questionList.add(que7);
        // 8
        val que8=question(
            8,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_germany,"denmark","germany",
            "syria","taliban",2,
        );
        questionList.add(que8);
        // 9
        val que9=question(
            9,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_kuwait,"norway","ireland",
            "turkey","kuwait",4,
        );
        questionList.add(que5);
        // 10
        val que10=question(
            10,"What country does this flag belong to ?",
            R.drawable.ic_flag_of_new_zealand,"new zealand","new york",
            "turkey","kuwait",1,
        );
        questionList.add(que10);
        return questionList;
    }
}