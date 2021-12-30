package com.example.mobile_calculator;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mobile_calculator.databinding.FragmentSimplyCalculatorBinding;

public class SimplyCalculatorFragment extends Fragment {

    private FragmentSimplyCalculatorBinding fragmentSimplyCalculatorBinding;
    private Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSubstring, buttonDivision,
            buttonMultiply, buttonDot, buttonC, buttonEquals, buttonAC, buttonPlusMinus;
    private TextView textView;
    private TextView viewOfNumbers;
    private Float mValueOne;
    private Float mValueTwo;
    private Context context;
    private int duration = Toast.LENGTH_SHORT;
    private Character mathSign;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        context = container.getContext();
        fragmentSimplyCalculatorBinding = FragmentSimplyCalculatorBinding.inflate(inflater, container, false);

        return fragmentSimplyCalculatorBinding.getRoot();

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(mValueOne!=null){
            outState.putFloat("mValueOne",mValueOne);
        }
        if(mValueTwo!=null){
            outState.putFloat("mValueTwo",mValueTwo);
        }
        if(textView.getText() != null && textView.getText() != ""){
            outState.putString("textView",textView.getText().toString());
        }
        if(viewOfNumbers.getText() != null && viewOfNumbers.getText() != ""){
            outState.putString("viewOfNumbers",viewOfNumbers.getText().toString());
        }
        if(!mathSign.equals("")){
            outState.putChar("mathSign",mathSign);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        loadButtons(view);
        if(savedInstanceState!=null){
            mValueOne = savedInstanceState.getFloat("mValueOne");
            mValueTwo = savedInstanceState.getFloat("mValueTwo");
            textView.setText(savedInstanceState.getString("textView"));
            viewOfNumbers.setText(savedInstanceState.getString("viewOfNumbers"));
            mathSign = savedInstanceState.getChar("mathSign");
        }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() == null || textView.getText() == "") {
                    textView.setText("");
                } else {
                    mValueOne = Float.parseFloat(textView.getText() + "");
                    mathSign = '+';
                    viewOfNumbers.setText(mValueOne + " + ");
                    textView.setText(null);
                }
            }
        });

        buttonSubstring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() == null || textView.getText() == ""){
                    textView.setText("");
                } else {
                    mValueOne = Float.parseFloat(textView.getText() + "");
                    mathSign = '-';
                    viewOfNumbers.setText(mValueOne + "-");
                    textView.setText(null);
                }
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() == null || textView.getText() == ""){
                    textView.setText("");
                } else {
                    mValueOne = Float.parseFloat(textView.getText() + "");
                    mathSign = '*';
                    viewOfNumbers.setText(mValueOne + "*");
                    textView.setText(null);
                }
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() == null || textView.getText() == "") {
                    textView.setText("");
                } else {
                    mValueOne = Float.parseFloat(textView.getText() + "");
                    mathSign = '/';
                    viewOfNumbers.setText(mValueOne + "/");
                    textView.setText(null);
                }
            }
        });

        buttonPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() == null || textView.getText() == "") {
                    textView.setText(null);
                } else {
                    float value = Float.parseFloat(textView.getText() + "");
                    if(value>0){
                        textView.setText("-"+value);
                    } else if (value<0){
                        textView.setText(Math.abs(value)+"");
                    } else if(value == 0){
                        Toast.makeText(context, "Nie zmienisz znaku dla zera!", duration).show();
                    }

                }
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewOfNumbers.getText().length() !=0 && textView.getText().length()!=0) {
                    mValueTwo = Float.parseFloat(textView.getText() + "");
                    if(mValueTwo!=null) {
                        viewOfNumbers.setText(mValueOne + "" + mathSign + mValueTwo + "");


                        if (mathSign == '+') {
                            viewOfNumbers.setText(mValueOne + "+" + mValueTwo + "");
                            textView.setText(mValueOne + mValueTwo + "");
                        }

                        if (mathSign == '-') {
                            textView.setText(mValueOne - mValueTwo + "");
                        }

                        if (mathSign == '*') {
                            textView.setText(mValueOne * mValueTwo + "");
                        }

                        if (mathSign == '/') {
                            if (mValueTwo == 0) {
                                Toast.makeText(context, "Nie dziel przez zero!", duration).show();
                            } else {
                                textView.setText(mValueOne / mValueTwo + "");
                            }

                        }
                    }
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mValueTwo!=null){
                    String value = removeLastChar(String.valueOf(mValueTwo));
                    if(value.length()==0){
                        mValueTwo=null;
                        viewOfNumbers.setText(mValueOne + "" + mathSign);
                    } else {
                        mValueTwo = Float.parseFloat(value);
                        textView.setText(mValueTwo+"");
                        viewOfNumbers.setText(mValueOne + "" + mathSign + mValueTwo + "");
                    }
                } else {
                    if(mathSign!=null){
                        mathSign = null;
                        textView.setText(mValueOne+"");
                        viewOfNumbers.setText(mValueOne+"");
                    } else {
                        String value = removeLastChar(String.valueOf(mValueOne));
                        if(value!=null) {
                            if (value.length() == 0) {
                                String display = textView.getText().toString();
                                if(display.length()!=0){
                                    String dispRem = removeLastChar(display);
                                    textView.setText(dispRem);
                                } else {
                                    mValueOne = null;
                                    viewOfNumbers.setText("");
                                    textView.setText("");
                                }

                            } else {
                                mValueOne = Float.parseFloat(value);
                                textView.setText(mValueOne + "");
                                viewOfNumbers.setText(mValueOne + "");
                            }
                        }
                    }
                }
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText() + ".");
            }
        });

        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(null);
                viewOfNumbers.setText(null);
                mValueOne = null;
                mValueTwo = null;
            }
        });
    }
    private static String removeLastChar(String str) {
        if(str.length()!=0 && !str.equals(null) && !str.equals("null")) {
            if (str.charAt(str.length() - 1) == '0' && str.charAt(str.length() - 2) == '.') {
                return str.substring(0, str.length() - 3);
            } else {
                return str.substring(0, str.length() - 1);
            }
        } else {
            return "";
        }
    }

    private void loadButtons(View view){
        button0 = (Button) view.findViewById(R.id.button0);
        button1 = (Button) view.findViewById(R.id.button1);
        button2 = (Button) view.findViewById(R.id.button2);
        button3 = (Button) view.findViewById(R.id.button3);
        button4 = (Button) view.findViewById(R.id.button4);
        button5 = (Button) view.findViewById(R.id.button5);
        button6 = (Button) view.findViewById(R.id.button6);
        button7 = (Button) view.findViewById(R.id.button7);
        button8 = (Button) view.findViewById(R.id.button8);
        button9 = (Button) view.findViewById(R.id.button9);
        buttonSubstring = (Button) view.findViewById(R.id.buttonSubstring);
        buttonAdd = (Button) view.findViewById(R.id.buttonAdd);
        buttonMultiply = (Button) view.findViewById(R.id.buttonMultiply);
        buttonDivision = (Button) view.findViewById(R.id.buttonDivision);
        buttonC = (Button) view.findViewById(R.id.buttonC);
        buttonAC = (Button) view.findViewById(R.id.buttonAC);
        buttonDot = (Button) view.findViewById(R.id.buttonDot);
        buttonEquals = (Button) view.findViewById(R.id.buttonEquals);
        textView = (TextView) view.findViewById(R.id.textView);
        viewOfNumbers = (TextView) view.findViewById(R.id.viewOfNumbers);
        buttonPlusMinus = (Button) view.findViewById(R.id.buttonPlusMinus);
    }
}
