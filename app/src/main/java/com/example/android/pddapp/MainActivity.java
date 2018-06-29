package com.example.android.pddapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    int checkSubmit = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    * This method checks the radio button answers
    * */


    /*
    * This method checks answered questions
    * */

    private void checkQuestions(){

        //Get candidate name
        EditText name = (EditText) findViewById(R.id.candName);
        String cand_name = name.getText().toString();

        //Get the ID of radio group one and check if an option is selected
        RadioGroup groupOne = (RadioGroup) findViewById(R.id.radio_question_three);
        int groupOneCheckedId = groupOne.getCheckedRadioButtonId();

        //Get the ID of radio group two and check if an option is selected
        RadioGroup groupTwo = (RadioGroup) findViewById(R.id.radio_question_four);
        int groupTwoCheckedId = groupTwo.getCheckedRadioButtonId();

        //Get the ID of radio group three and check if an option is selected
        RadioGroup groupThree = (RadioGroup) findViewById(R.id.radio_question_five);
        int groupThreeCheckedId = groupThree.getCheckedRadioButtonId();

        //Get the ID of radio group four and check if an option is selected
        RadioGroup groupFour = (RadioGroup) findViewById(R.id.radio_question_six);
        int groupFourCheckedId = groupFour.getCheckedRadioButtonId();

        //Get the ID of radio group five and check if an option is selected
        RadioGroup groupFive = (RadioGroup) findViewById(R.id.radio_question_seven);
        int groupFiveCheckedId = groupFive.getCheckedRadioButtonId();

        //Get the ID of radio group six and check if an option is selected
        RadioGroup groupSix = (RadioGroup) findViewById(R.id.radio_question_eight);
        int groupSixCheckedId = groupSix.getCheckedRadioButtonId();

        // Get the values of checkboxes ticked in question Two
        CheckBox questionTwoBox1 = (CheckBox) findViewById(R.id.checkbox_one);
        boolean questionTwoBox_1 = questionTwoBox1.isChecked();

        CheckBox questionTwoBox2 = (CheckBox) findViewById(R.id.checkbox_two);
        boolean questionTwoBox_2 = questionTwoBox2.isChecked();


        // Check parameters in question two
        boolean question_two = questionTwoBox_1 || questionTwoBox_2;

        //parameters for radioButtonAnswers
        RadioButton radioquestion3_opt3 = (RadioButton) findViewById(R.id.radio_question_three_option_3);
        boolean radioquestion3_opt_3 = radioquestion3_opt3.isChecked();

        RadioButton radioquestion4_opt4 =(RadioButton) findViewById(R.id.radio_question_four_option_4);
        boolean radioquestion4_opt_4 = radioquestion4_opt4.isChecked();

        RadioButton radioquestion5_opt2 = (RadioButton) findViewById(R.id.radio_question_five_option_2);
        boolean radioquestion5_opt_2 = radioquestion5_opt2.isChecked();

        RadioButton radioquestion6_opt1 = (RadioButton) findViewById(R.id.radio_question_six_option_1);
        boolean radioquestion6_opt_1 = radioquestion6_opt1.isChecked();

        RadioButton radioquestion7_opt4 = (RadioButton) findViewById(R.id.radio_question_seven_option_4);
        boolean radioquestion7_opt_4 = radioquestion7_opt4.isChecked();

        RadioButton radioquestion8_opt4 = (RadioButton) findViewById(R.id.radio_question_eight_option_4);
        boolean radioquestion8_opt_4 = radioquestion8_opt4.isChecked();



        // Validate that a radiobutton was selected in a each radiogroup question
        //Group one question 3 display toastmessage if no option selected after submit button click
        if (groupOneCheckedId == -1){
            Toast.makeText(this, "Please select an option in question 3", Toast.LENGTH_SHORT).show();
        }
        else if(groupTwoCheckedId == -1){
            Toast.makeText(this, "Please select an option in question 4", Toast.LENGTH_SHORT).show();

        }
        else if(groupThreeCheckedId == -1){
            Toast.makeText(this, "Please select an option in question 5", Toast.LENGTH_SHORT).show();

        }
        else if(groupFourCheckedId == -1){
            Toast.makeText(this, "Please select an option in question 6", Toast.LENGTH_SHORT).show();

        }
        else if(groupFiveCheckedId == -1){
            Toast.makeText(this, "Please select an option in question 7", Toast.LENGTH_SHORT).show();

        } else if(groupSixCheckedId == -1){
            Toast.makeText(this, "Please select an option in question 8", Toast.LENGTH_SHORT).show();

        }
        else if (!question_two){
            Toast.makeText(this, "Please select an option for question 2", Toast.LENGTH_SHORT).show();
        }
        else {
            checkSubmit =+ 1;

            radioButtonAnswerCheck(radioquestion3_opt_3, radioquestion4_opt_4, radioquestion5_opt_2,
                                    radioquestion6_opt_1, radioquestion7_opt_4, radioquestion8_opt_4);


        }




        String grade = " ";

        if (score < 10){
            grade = "Kindly update your knowledge of PDD in women";

        }
        else if (score == 20){

            grade = "You can improve on your knowledge of PDD";
        }
        else if (score > 20){
            grade = "Pretty good!";
        }
        else {
            grade = "You're balling!";
        }

        //Toast message to show the candidate's score
        Toast.makeText(this, grade + name + "Your score is " + score , Toast.LENGTH_LONG).show();

    }



    private  int radioButtonAnswerCheck (boolean radioquestion3_opt_3, boolean radioquestion4_opt_4, boolean radioquestion5_opt2,
                                         boolean radioquestion6_opt_1, boolean radioquestion7_opt_4, boolean radioquestion8_opt_4 ){
        // What happens if user selects option 3 for question 3
        if (radioquestion3_opt_3){
            score += 10;
        }

        // What happens if user selects option 4 for question 4
        if (radioquestion4_opt_4){
            score += 10;
        }

        // What happens if user selects option 2 for question 5
        if (radioquestion5_opt2){

            score += 10;
        }
        // What happens if user selects option 1 for question 6
        if (radioquestion6_opt_1){
            score += 10;
        }
        // What happens if user selects option 4 for question 7
        if (radioquestion7_opt_4){

            score += 10;
        }
        // What happens if user selects option 4 for question 8
        if (radioquestion8_opt_4){

            score += 10;
        }

        //calculate total score and return
        return score;

    }



    public  void submitBtn(View view){
                checkQuestions();
            }

}