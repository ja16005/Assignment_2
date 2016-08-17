
package com.example.jahnavi.findprimenum;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity  {

    private Button tagcorrectButton;
    private Button tagincorrectButton;
    private Button tagnextButton;
    private TextView tagTextView1;
    private TextView tagTextView2;
    private static final String TAG = "MainActivity";
    private int p,count=0,score=0;


    private int isPrimeNumber(int number) {

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {

                return 0;
            }
        }
        return 1;
    }

    private int random() {
        Random randomGenerator = new Random();
        int r = randomGenerator.nextInt(1000) + 1;
        if(count<5) {
            String s = Integer.toString(r) + " is prime number!";
            count = count + 1;
            tagTextView1.setText(s);
        }
        else {
            Toast.makeText(getApplicationContext(), "FINISHED PRIME NUMBER QUIZ", Toast.LENGTH_LONG).show();
            String m="Your Score = "+ Integer.toString(score)+ "/5 ";
            tagTextView2.setText(m);
            tagcorrectButton.setEnabled(false);
            tagcorrectButton.setClickable(false);
            tagincorrectButton.setEnabled(false);
            tagincorrectButton.setClickable(false);
            tagnextButton.setEnabled(false);
            tagnextButton.setClickable(false);
        }
        return r;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tagcorrectButton = (Button) findViewById(R.id.correctButton);
        tagincorrectButton = (Button) findViewById(R.id.incorrectButton);
        tagnextButton = (Button) findViewById(R.id.nextButton);
        tagTextView1 = (TextView) findViewById(R.id.primeText);
        tagTextView2 = (TextView) findViewById(R.id.secText);


        execution();
    }

    private void execution()

    {
        tagcorrectButton.setEnabled(true);
        tagcorrectButton.setClickable(true);
        tagincorrectButton.setEnabled(true);
        tagincorrectButton.setClickable(true);
        p = random();
        tagcorrectButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                tagincorrectButton.setEnabled(false);
                tagincorrectButton.setClickable(false);
                Log.d(TAG, "Inside correctButton");
                int q=isPrimeNumber(p);
                if (q==1) {
                    Toast.makeText(getApplicationContext(), "Yay! Correct answer", Toast.LENGTH_SHORT).show();
                    score =score+1;
                    tagcorrectButton.setEnabled(false);
                    tagcorrectButton.setClickable(false);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Sorry! Wrong answer", Toast.LENGTH_SHORT).show();
                    tagcorrectButton.setEnabled(false);
                    tagcorrectButton.setClickable(false);
                }
            }

        });

        tagincorrectButton.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View view) {

                tagcorrectButton.setEnabled(false);
                tagcorrectButton.setClickable(false);
                Log.d(TAG, "Inside incorrectButton");
                int q=isPrimeNumber(p);
                if (q==1) {
                    Toast.makeText(getApplicationContext(), "Sorry! Wrong answer", Toast.LENGTH_SHORT).show();
                    tagincorrectButton.setEnabled(false);
                    tagincorrectButton.setClickable(false);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Yay! Correct answer", Toast.LENGTH_SHORT).show();
                    score=score+1;
                    tagincorrectButton.setEnabled(false);
                    tagincorrectButton.setClickable(false);
                }
            }
        });

        tagnextButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                Log.d(TAG, "Inside nextButton");
                execution();
            }

        });


    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnResume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }

}





