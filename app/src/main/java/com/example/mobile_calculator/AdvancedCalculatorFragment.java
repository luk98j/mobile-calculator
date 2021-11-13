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

import com.example.mobile_calculator.databinding.FragmentAdvancedCalculatorBinding;

public class AdvancedCalculatorFragment extends Fragment {
    private FragmentAdvancedCalculatorBinding advancedCalculatorBinding;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonAdd;
    private Button buttonSubstring;
    private Button buttonDivision;
    private Button buttonMultiply;
    private Button buttonDot;
    private Button buttonC;
    private Button buttonEquals;
    private Button buttonAC;
    private Button buttonProcent;
    private Button buttonSin;
    private Button buttonCos;
    private Button buttonTanges;
    private Button buttonSqrt;
    private Button buttonLn;
    private Button buttonLog;
    private Button buttonX2;
    private Button buttonXY;
    private Button buttonPlusMinus;
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
        advancedCalculatorBinding = FragmentAdvancedCalculatorBinding.inflate(inflater, container, false);
        return advancedCalculatorBinding.getRoot();

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
        button0 = view.findViewById(R.id.button0);
        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);
        button4 = view.findViewById(R.id.button4);
        button5 = view.findViewById(R.id.button5);
        button6 = view.findViewById(R.id.button6);
        button7 = view.findViewById(R.id.button7);
        button8 = view.findViewById(R.id.button8);
        button9 = view.findViewById(R.id.button9);
        buttonSubstring = view.findViewById(R.id.buttonSubstring);
        buttonAdd =  view.findViewById(R.id.buttonAdd);
        buttonMultiply =  view.findViewById(R.id.buttonMultiply);
        buttonDivision =  view.findViewById(R.id.buttonDivision);
        buttonC =  view.findViewById(R.id.buttonC);
        buttonAC =  view.findViewById(R.id.buttonAC);
        buttonDot =  view.findViewById(R.id.buttonDot);
        buttonEquals = view.findViewById(R.id.buttonEquals);
        textView = view.findViewById(R.id.textView);
        viewOfNumbers =  view.findViewById(R.id.viewOfNumbers);
        buttonProcent =  view.findViewById(R.id.buttonProcent);
        buttonSin =  view.findViewById(R.id.buttonSin);
        buttonCos =  view.findViewById(R.id.buttonCos);
        buttonTanges =  view.findViewById(R.id.buttonTanges);
        buttonSqrt =  view.findViewById(R.id.buttonSqrt);
        buttonLn =  view.findViewById(R.id.buttonLn);
        buttonLog =  view.findViewById(R.id.buttonLog);
        buttonX2 =  view.findViewById(R.id.buttonX2);
        buttonXY =  view.findViewById(R.id.buttonXY);
        buttonPlusMinus =  view.findViewById(R.id.buttonPlusMinus);

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
                if (textView.getText() == null || textView.getText() == "") {
                    textView.setText(null);
                } else {
                    mValueOne = Float.parseFloat(textView.getText() + "");
                    mathSign = '-';
                    viewOfNumbers.setText(mValueOne + "-");
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

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() == null || textView.getText() == "") {
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

        buttonProcent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() == null || textView.getText() == ""){
                    textView.setText("");
                } else {
                    mValueOne = Float.parseFloat(textView.getText() + "");
                    mathSign = '%';
                    viewOfNumbers.setText(mValueOne + "%");
                    textView.setText(null);
                }
            }
        });

        buttonSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() == null || textView.getText() == ""){
                    textView.setText("");
                } else {
                    mValueOne = Float.parseFloat(textView.getText() + "");
                    viewOfNumbers.setText("sin("+mValueOne+")");
                    double newVariable = Math.sin(Double.valueOf(mValueOne));
                    mValueOne = (float) newVariable;
                    textView.setText(mValueOne+"");
                }
            }
        });

        buttonCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() == null || textView.getText() == ""){
                    textView.setText("");
                } else {
                    mValueOne = Float.parseFloat(textView.getText() + "");
                    viewOfNumbers.setText("cos("+mValueOne+")");
                    double newVariable = Math.cos(Double.valueOf(mValueOne));
                    mValueOne = (float) newVariable;
                    textView.setText(mValueOne+"");
                }
            }
        });

        buttonTanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() == null || textView.getText() == ""){
                    textView.setText("");
                } else {
                    mValueOne = Float.parseFloat(textView.getText() + "");
                    viewOfNumbers.setText("tan("+mValueOne+")");
                    double newVariable = Math.tan(Double.valueOf(mValueOne));
                    mValueOne = (float) newVariable;
                    textView.setText(mValueOne+"");
                }
            }
        });

        buttonSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() == null || textView.getText() == ""){
                    textView.setText("");
                } else {
                    mValueOne = Float.parseFloat(textView.getText() + "");
                    viewOfNumbers.setText("sqrt("+mValueOne+")");
                    double newVariable = Math.sqrt(Double.valueOf(mValueOne));
                    mValueOne = (float) newVariable;
                    textView.setText(mValueOne+"");
                }
            }
        });

        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() == null || textView.getText() == ""){
                    textView.setText("");
                } else {
                    mValueOne = Float.parseFloat(textView.getText() + "");
                    viewOfNumbers.setText("log("+mValueOne+")");
                    double newVariable = Math.log10(Double.valueOf(mValueOne));
                    mValueOne = (float) newVariable;
                    textView.setText(mValueOne+"");
                }
            }
        });

        buttonLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() == null || textView.getText() == ""){
                    textView.setText("");
                } else {
                    mValueOne = Float.parseFloat(textView.getText() + "");
                    viewOfNumbers.setText("ln("+mValueOne+")");
                    double newVariable = Math.log(Double.valueOf(mValueOne));
                    mValueOne = (float) newVariable;
                    textView.setText(mValueOne+"");
                }
            }
        });

        buttonX2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() == null || textView.getText() == ""){
                    textView.setText("");
                } else {
                    mValueOne = Float.parseFloat(textView.getText() + "");
                    viewOfNumbers.setText("("+mValueOne+")^2");
                    double newVariable = Math.pow(Double.valueOf(mValueOne),2);
                    mValueOne = (float) newVariable;
                    textView.setText(mValueOne+"");
                }
            }
        });

        buttonXY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() == null || textView.getText() == ""){
                    textView.setText("");
                } else {
                    mValueOne = Float.parseFloat(textView.getText() + "");
                    viewOfNumbers.setText("("+mValueOne+")^");
                    textView.setText(null);
                    mathSign = '^';
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
                        if(mathSign == '%'){
                            mValueTwo = Float.parseFloat(textView.getText() + "");
                            double newVariable = mValueOne % mValueTwo;
                            textView.setText(newVariable+"");

                        }
                        if(mathSign == '^'){
                            mValueTwo = Float.parseFloat(textView.getText() + "");
                            double newVariable = Math.pow(Double.valueOf(mValueOne),mValueTwo);

                            textView.setText(newVariable+"");
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
}
