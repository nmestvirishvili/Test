package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Question> questions = new ArrayList<>();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createTest();

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);
        mQuestionView = (TextView)findViewById(R.id.question);

        updateQuestion();

        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (mButtonChoice1.getText().equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (mButtonChoice2.getText().equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (mButtonChoice3.getText().equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        mButtonChoice4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (mButtonChoice4.getText().equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

    }

    private void updateQuestion(){
        if (mQuestionNumber > 9) {
            Intent i = new Intent(getApplicationContext(), ResultActivity.class);
            i.putExtra("score", mScore);
            startActivity(i);
        } else {
            Question question = questions.get(mQuestionNumber);
            mQuestionView.setText(question.question);
            List<String> answers = question.getAnswers();
            mButtonChoice1.setText(answers.get(0));
            mButtonChoice2.setText(answers.get(1));
            mButtonChoice3.setText(answers.get(2));
            mButtonChoice4.setText(answers.get(3));

            mAnswer = question.correctAnswer;
            mQuestionNumber++;
        }

    }


    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }

    private void createTest() {
        Question question1 = new Question("1+2 = ", "3", "34", "6", "0");
        Question question2 = new Question("5*0 = ", "0", "8", "6", "89");
        Question question3 = new Question("1/2 = ", "0.5", "4", "6.4", "0.9");
        Question question4 = new Question("10+2 = ", "12", "3", "-3", "0");
        Question question5 = new Question("1*2 = ", "2", "4", "6", "0");
        Question question6 = new Question("1-2 = ", "-1", "1119", "12313", "123");
        Question question7 = new Question("5*5 = ", "25", "0", "5", "1");
        Question question8 = new Question("1/1 = ", "1", "34", "6", "0");
        Question question9 = new Question("2*2*2 = ", "8", "34", "6", "0");
        Question question10 = new Question("15/2 = ", "7.5", "3.4", "6", "0");
        Test test = new Test(question1, question2, question3, question4, question5, question6, question7, question8, question9, question10);
        this.questions = test.getQuestions();
    }
}
