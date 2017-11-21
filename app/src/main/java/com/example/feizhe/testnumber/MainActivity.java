package com.example.feizhe.testnumber;

import android.content.pm.ApplicationInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {

        int number;

        public boolean isSquare() {
            double squareroot = Math.sqrt(number);

            if (squareroot == Math.floor(squareroot))
                return true;
            else
                return false;
        }


        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;
            while (triangularNumber < number) {
                x++;
                triangularNumber = triangularNumber + x;
            }
            if (triangularNumber == number) {
                return true;
            } else
                return false;
        }

    }

    public void numberShapes(View view) {

        EditText usersNumber = (EditText) findViewById(R.id.testnumber);
        String message = "";
        if(usersNumber.getText().toString().isEmpty()){
            message = "Please enter a number";
        }  else {
            Number myNumber = new Number();

            myNumber.number = Integer.parseInt(usersNumber.getText().toString());
            if (myNumber.isTriangular()) {
                if (myNumber.isSquare()) {
                    message = myNumber.number + " is both a triangular number and a square number";
                } else {
                    message = myNumber.number + " is a triangular number ,not a square number";

                }
            } else {
                if (myNumber.isSquare()) {
                    message = myNumber.number + " is not a triangular number but a square number";

                } else {
                    message = myNumber.number + " is neither a triangular number nor a square number";
                }
            }
        }


        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
