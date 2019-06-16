package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import android.widget.Button;

import android.widget.GridLayout;

import android.widget.TextView;
import android.widget.Toast;
import android.text.method.ScrollingMovementMethod;



public class MainActivity extends AppCompatActivity {

    GridLayout gridLayout;
    int width;
    Button button1;
    Button clear;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button minus;
    Button plus;
    Button delete;
    Button decimal;
    Button divide;
    Button multiply;
    Button bracketClose;
    Button bracketOpen;
    Button equal;
    Button button0;
    String[] calculation;


    TextView answer;
    TextView enter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayout = findViewById(R.id.grid);
        button1 = findViewById(R.id.one);
        button2 = findViewById(R.id.two);
        button3 = findViewById(R.id.three);
        button4 = findViewById(R.id.four);

        button5 = findViewById(R.id.five);
        button6 = findViewById(R.id.six);
        button7 = findViewById(R.id.seven);
        button8 = findViewById(R.id.eight);
        button9 = findViewById(R.id.nine);
        button0 = findViewById(R.id.zero);
        minus = findViewById(R.id.subtract);
        plus = findViewById(R.id.add);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        equal = findViewById(R.id.equal);

        clear = findViewById(R.id.clear);
        delete = findViewById(R.id.backspace);
        decimal = findViewById(R.id.decimal);
        answer = findViewById(R.id.answers);
        enter = findViewById(R.id.calculations);
        answer.setText("");
        enter.setText("");

        answer.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        if(answer.getText().length()>5)
                        {
                            answer.setTextSize(60);
                        }
                        if(answer.getText().length()<5)
                        {
                            answer.setTextSize(120);
                        }

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if(answer.getText().length()>5)
                        {
                            answer.setTextSize(60);
                        }
                        if(answer.getText().length()<5)
                        {
                            answer.setTextSize(120);
                        }


                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if(answer.getText().length()>5)
                        {
                            answer.setTextSize(60);
                        }
                        if(answer.getText().length()<5)
                        {
                            answer.setTextSize(120);
                        }


                    }
                }
        );
        answer.setMovementMethod(new ScrollingMovementMethod());



        equal.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                if(answer.getText().length()==0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter a number.", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                if (!GetLastchar().equals("*")&&!GetLastchar().equals("+")&&!GetLastchar().equals("-")&&!GetLastchar().equals("/")&&!GetLastchar().equals("("))
                {

                    enter.setText(answer.getText().toString()+"=");

                    answer.setText(compute(answer.getText().toString()).toString());
                    equal.setWidth(button0.getWidth());



                }
                else
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Equation cannot end with an operator",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }

        });

        plus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(answer.getText().length()==0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter a number.", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if (!GetLastchar().equals("*")&&!GetLastchar().equals("+")&&!GetLastchar().equals("-")&&!GetLastchar().equals("/")&&!GetLastchar().equals("("))
                    answer.setText(answer.getText().toString() + "+");

                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Syntax error, Please check your equation", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(answer.getText().length()==0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter a number.", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else


                if (!GetLastchar().equals("*")&&!GetLastchar().equals("+")&&!GetLastchar().equals("-")&&!GetLastchar().equals("/")&&!GetLastchar().equals("("))
                    answer.setText(answer.getText().toString() + "-");
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Syntax error, Please check your equation", Toast.LENGTH_SHORT);
                    toast.show();
                }


            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {if(answer.getText().length()==0) {
                Toast toast = Toast.makeText(getApplicationContext(), "Enter a number.", Toast.LENGTH_SHORT);
                toast.show();
            }
            else


                if (!GetLastchar().equals("*")&&!GetLastchar().equals("+")&&!GetLastchar().equals("-")&&!GetLastchar().equals("/")&&!GetLastchar().equals("("))
                    answer.setText(answer.getText().toString() + "*");
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Syntax error, Please check your equation", Toast.LENGTH_SHORT);
                    toast.show();
                }


            }
        });
        divide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(answer.getText().length()==0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter a number.", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else


                if (!GetLastchar().equals("*")&&!GetLastchar().equals("+")&&!GetLastchar().equals("-")&&!GetLastchar().equals("/")&&!GetLastchar().equals("("))
                    answer.setText(answer.getText().toString() + "/");
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Syntax error, Please check your equation", Toast.LENGTH_SHORT);
                    toast.show();
                }


            }
        });


        decimal.setOnClickListener(new View.OnClickListener()

    {

        @Override
        public void onClick (View v){


        answer.setText(answer.getText().toString() + ".");


    }
    });
        button1.setOnClickListener(new View.OnClickListener()

    {

        @Override
        public void onClick (View v){


        answer.setText(answer.getText().toString() + "1");


    }
    });
        button2.setOnClickListener(new View.OnClickListener()

    {

        @Override
        public void onClick (View v){


        answer.setText(answer.getText().toString() + "2");


    }
    });
        button3.setOnClickListener(new View.OnClickListener()

    {

        @Override
        public void onClick (View v){


        answer.setText(answer.getText().toString() + "3");


    }
    });
        button4.setOnClickListener(new View.OnClickListener()

    {

        @Override
        public void onClick (View v){


        answer.setText(answer.getText().toString() + "4");


    }
    });
        button5.setOnClickListener(new View.OnClickListener()

    {

        @Override
        public void onClick (View v){


        answer.setText(answer.getText().toString() + "5");


    }
    });
        button6.setOnClickListener(new View.OnClickListener()

    {

        @Override
        public void onClick (View v){


        answer.setText(answer.getText().toString() + "6");


    }
    });
        button7.setOnClickListener(new View.OnClickListener()

    {

        @Override
        public void onClick (View v){


        answer.setText(answer.getText().toString() + "7");


    }
    });
        button8.setOnClickListener(new View.OnClickListener()

    {

        @Override
        public void onClick (View v){


        answer.setText(answer.getText().toString() + "8");


    }
    });
        button9.setOnClickListener(new View.OnClickListener()

    {

        @Override
        public void onClick (View v){


        answer.setText(answer.getText().toString() + "9");


    }
    });
        button0.setOnClickListener(new View.OnClickListener()

    {

        @Override
        public void onClick (View v){


        answer.setText(answer.getText().toString() + "0");
        hasWindowFocus();


    }
    });
        clear.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        answer.setText("");
        enter.setText("");
    }
    });
        delete.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
            int length = answer.getText().length();
            if (length > 0) {
                String text = answer.getText().toString();
                answer.setText(text.substring(0, text.length() - 1));
            }
    }
    });



}
    private java.lang.String GetLastchar()
    {

        CharSequence s = answer.getText();
       String n=(s.subSequence(s.length()-1, s.length())).toString();


    return n;

    }




    static Double compute(String equation) {


            double result = 0.0;
            String noMinus = equation.replace("-", "+-");
            String[] byPlus = noMinus.split("\\+");

            for (String multi : byPlus) {
                String[] byMultipl = multi.split("\\*");
                double multiplyResult = 1.0;
                for (String operand : byMultipl) {
                    if (operand.contains("/")) {
                        String[] division = operand.split("\\/");
                        double dividend = Double.parseDouble(division[0]);
                        for (int i = 1; i < division.length; i++) {
                            dividend /= Double.parseDouble(division[i]);
                        }
                        multiplyResult *= dividend;
                    } else {
                        multiplyResult *= Double.parseDouble(operand);
                    }
                }
                result += multiplyResult;
            }

            return result;
        }

    }


