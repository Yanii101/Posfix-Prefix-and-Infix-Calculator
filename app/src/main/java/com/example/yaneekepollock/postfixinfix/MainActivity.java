package com.example.yaneekepollock.postfixinfix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaScannerConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener{

    Button one, two, three, four, five, six, seven, eight, nine, zero, clear, dot, space,bracket1,bracket2,MR,buttons;
    ImageButton sub, mult, div, equal, add, backspace;
    TextView equation;
    TextView result;
    TextView postfix;
    StringBuilder vv = new StringBuilder();
    String sres;
    String finals;
    Spinner spinner;
    double test;
    String ff;
    String position="0";
    private static final String OPERATORS = "+-*/";
    private DoubleS operandStack;
    public static final Pattern P = Pattern.compile("^(\\d [\\+\\-] )*\\d$");
    String newfinal;
    String[] calct=new String[]
        {
                "Infix Calculator",
                "Postfix Calculator"
        };
    String textsize="30sp";
    private final String filenameExternal="cashbkfiel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=(Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> ad=new ArrayAdapter<CharSequence>(this,R.layout.spinner_item,calct);
        ad.setDropDownViewResource(R.layout.spinner_dropdown_item);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(ad);
        spinner.getBackground().setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        spinner.setOnItemSelectedListener(this);


        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        MR=(Button)findViewById(R.id.buttonm);
        bracket1=(Button)findViewById(R.id.bracket1);
        bracket2=(Button)findViewById(R.id.bracket2);
        add = (ImageButton) findViewById(R.id.add);
        sub = (ImageButton) findViewById(R.id.sub);
        mult = (ImageButton) findViewById(R.id.mult);
        div = (ImageButton) findViewById(R.id.div);
        clear = (Button) findViewById(R.id.clear);
        equal = (ImageButton) findViewById(R.id.equal);
        backspace = (ImageButton) findViewById(R.id.backspace);
        buttons=(Button)findViewById(R.id.buttons);
        space = (Button) findViewById(R.id.space);
        dot = (Button) findViewById(R.id.dot);
        equation = (TextView) findViewById(R.id.equation);
        equation.setText("");
        result = (TextView) findViewById(R.id.result);
        postfix = (TextView) findViewById(R.id.postfix);
        postfix.setText("");
        result.setText("");

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("1");
                vv.append("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("2");
                vv.append("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("3");
                vv.append("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("4");
                vv.append("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("5");
                vv.append("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                equation.append("6");
                vv.append("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("7");
                vv.append("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("8");
                vv.append("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                equation.append("9");
                vv.append("9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("0");
                vv.append("0");

            }
        });
        bracket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("(");
                vv.append("(");

            }
        });
        bracket2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append(")");
                vv.append(")");

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.setText("");
                result.setText("");
                postfix.setText("");
                vv.setLength(0);
                equation.setTextColor(Color.WHITE);
                equation.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
            }
        });
        MR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                equation.setText("");
                result.setText(sres);
                equation.setText(finals);
                equation.setTextColor(Color.GRAY);
                equation.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                result.setTextSize(TypedValue.COMPLEX_UNIT_SP, 60);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("+");
                vv.append("+");
            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("*");
                vv.append("*");

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("/");
                vv.append("/");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("-");
                vv.append("-");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append(".");
                vv.append(".");
            }
        });
        space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append(" ");
                vv.append(" ");
            }
        });
        equal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                finals = vv.toString();
                String test1="";
                if (position.equals("0")) {
                    int valid = validate(finals);
                    if (valid == 0) {
                        postfix.setText("Invalid Expression");
                        postfix.setTextColor(Color.RED);
                    } else {
                        String[] t = toStringArray(finals);          //u accepting a string n converting it to a string array
                        String[] ppostfix = toPostFix(t);//converting infix to postfix

                        double res = 0;//calculating val
                        try {
                            res = calculate_postfix(ppostfix);
                            res = Math.round(res * 100.00) / 100.00;
                            result.setTextSize(TypedValue.COMPLEX_UNIT_SP, 60);
                            sres = String.valueOf(res);
                            result.setText(sres);//save to file*/
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        equation.setTextColor(Color.GRAY);
                        equation.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                        StringBuilder sb = new StringBuilder();
                        for (String element : ppostfix) {
                            String delim = " ";
                            if (sb.length() > 0) {
                                sb.append(delim);
                            }
                            sb.append(element);
                        }
                        ff = sb.toString();
                        postfix.setTextColor(Color.WHITE);
                        postfix.setText("postfix: " + ff);
                    }
                }
                if (position.equals("1"))
                {
                        try {
                            double results = eval(finals);///integer
                            results = Math.round(results * 100.00) / 100.00;
                            String sval = String.valueOf(results);
                            equation.setTextColor(Color.GRAY);
                            equation.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                            result.setTextSize(TypedValue.COMPLEX_UNIT_SP, 60);
                            result.setText(sval);
                        } catch (Exception ex) {
                            postfix.setText("Incorrect Postfix Form");
                            postfix.setTextColor(Color.RED);
                        }
                }
            }
        });


        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textInBox = equation.getText().toString();
                if(textInBox.length() > 0)
                { String newText = textInBox.substring(0, textInBox.length()-1);
                    equation.setText(newText);
                }
            }
        });
        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    savefile(sres,finals,ff);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String txt=adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),txt,Toast.LENGTH_SHORT).show();
        int tt=i;
        String s=Integer.toString(tt);
        if(s.equals("0"))
        {
            position="0";
        }else
            if(s.equals("1"))
            {
                position="1";
            }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }


    /**
     * @param q post fix string array
     * @return result after evaluating post fix string
     */
    /**
     * breaks infix string to string array of its operands and operators
     * eg. "a+b*c*(d+e)" to {"a","+","b","*","c","(","d","+","e",")"}
     *
     * @param infix_string (String) a correct infix string
     * @return (String[]) array of string(operands and operators)
     */
    public static String[] toStringArray(String infix_string) {

        ArrayList<String> arrl = new ArrayList<String>();
        String out = "";
        for (char c : infix_string.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '^' || c == '/' || c == '(' || c == ')') {
                if (!out.equals( "")){
                    if (out.endsWith("%")) {
                        double num = Double.valueOf(out.substring(0, out.length() - 1));
                        num = num / 100;
                        out = String.valueOf(num);
                    }
                    arrl.add(out);
                }
                arrl.add(String.valueOf(c));
                out = "";
            } else {
                out = out + String.valueOf(c);
            }
        }
        if (!out.equals("")) {
            if (out.endsWith("%")) {
                double num = Double.valueOf(out.substring(0, out.length() - 1));
                num = num / 100;
                out = String.valueOf(num);
            }
            arrl.add(out);
        }
        String[] str = new String[arrl.size()];

        for (int i = 0; i < arrl.size(); i++) {
            str[i] = arrl.get(i).toString();
        }
        return str;
    }

    /**
     * evaluates given infix string
     *
     * @param infix_string infix string to evaluate
     * @return (string) value after evaluation [ERROR if any exception occurred]
     */
    public static String calculate(String infix_string) {
        String result = "";
        String r1[] = toStringArray(infix_string);
        String r2[] = toPostFix(r1);

        try {
            result = remove_extra_precision(String.valueOf(calculate_postfix(r2)));
        } catch (Exception e) {
            result = "ERROR";
        }
        return result;
    }

    /**
     * Removes extra zeros in decimal
     * eg. for 0.10000000000004 it will return 0.10
     *
     * @param value (String) floating point value
     * @return result by reducing decimal value if it has consecutive 6 zeros
     */
    public static String remove_extra_precision(String value) {
        String result = "";
        boolean is_decimal = false;
        boolean is_prev_zero = false;
        int count_zero = 0;  // counter for zero
        int length = 0;
        if (value.contains("E")) {
            return value;
        } else if (value.endsWith(".0")) {
            System.out.println(".0 found");
            value = value.substring(0, value.length() - 2);
            return value;

        } else {
            for (char c : value.toCharArray()) {
                if (is_decimal) {
                    if (c == '0') {
                        if (is_prev_zero) {
                            if (count_zero == 6) {
                                // if consecutive number of zero exceeds 6
                                result = result.substring(0, length - 5);
                                break;
                            }
                            count_zero++;
                            result += String.valueOf(c);
                        } else {
                            is_prev_zero = true;
                            // Zero detected"
                            count_zero++;
                        }
                    } else {
                        is_prev_zero = false;
                        // Other Number Detected
                    }
                } else {
                    if (c == '.') {
                        // Given is decimal"
                        is_decimal = true;
                    }
                }
                result += String.valueOf(c);
                length++;
            }

            return result;
        }
    }

    /**
     * validates the infix string
     *
     * @param infix_string (String) infix string to evaluate
     * @return (boolean) true if it is valid expression else false
     */
    public static int validate(String infix_string) {
        String[] postfix_string_array = toStringArray(infix_string);
        int valid=0;//0 is false
        int operands = 0;
        int operators = 0;
        int brackets = 0;
        for (String c : postfix_string_array) {

            if (c.equals("-") || c.equals("+") || c.equals("/") || c.equals("*") || c.equals("^")) {
                operators++;
            } else if (c.equals("(") || c.equals(")")) {
                brackets++;
            } else {
                operands++;
            }
        }
        if ((operands - operators == 1)&&(brackets % 2 == 0))
        {
            valid = 1;//one is true

        }
        return valid;
    }
    public void savefile(String input,String result,String postfix) throws FileNotFoundException
    {
        String filewrite = input + "\n" + result + "\n" +
                postfix + "\n"+ "\n"+ "\n";
        File file=new File(this.getExternalFilesDir(null),"testfile.txt");
        FileOutputStream fileout=new FileOutputStream(file,true);
        OutputStreamWriter outwrite=new OutputStreamWriter(fileout);
        try {
            outwrite.write(filewrite);
            outwrite.flush();
            fileout.getFD().sync();
            outwrite.close();

            MediaScannerConnection.scanFile(this,new String[]{file.getAbsolutePath()},null,null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String[] toPostFix(String[] infix_array)
    {

        StringStack stack = new StringStack();  // stack to hold operators
        stack.push(" ");
        String[] p = new String[infix_array.length+2];  // post fix string array

        int i = 1;
        int count_brackets = 0;
        p[0] = "(";  // add ( at the beginning of post fix string
        for(String c: infix_array)  // count brackets and length
        {
            if(c.equals("(") || c.equals(")"))
            {
                count_brackets++;
            }
            p[i++] = c;
        }
        p[i] = ")";  // add ) at the end of string

        String[] q = new String[i-1-count_brackets];  // initializing array to store post fix string
        i = 0;

        for(String c: p)  // scan all characters
        {

            if(c.equals("("))  // if character is ( then push to stack
            {

                stack.push(c);
            }
            else if(c.equals(")"))  // if character is ) then pop all operators in stack until matching ( arrives
            {
                while(!stack.peek().equals("(")){

                    q[i++] = stack.pop();
                }
                stack.pop();
            }
            else if(c.equals("-") ||c.equals( "+") || c.equals("/") ||c.equals("*") || c.equals("^"))  // if character is operator
            {
                // if stack already has operator of same precedence at top ,
                // and put it to post fix string and push current operator to stack
                // else just put operator to stack

                if(c.equals("+") || c.equals("-"))
                {

                    if((stack.peek().equals("+")) || (stack.peek().equals("-") ||(stack.peek().equals("*")) || (stack.peek().equals("/") || (stack.peek().equals("^"))))){
                        q[i++] = stack.pop();
                        stack.push(c);
                    }
                    else{
                        stack.push(c);
                    }
                }
                else if((c.equalsIgnoreCase("*") || c.equals("/")))
                {
                    if((stack.peek().equals("*")) || (stack.peek().equals("/") || (stack.peek().equals("^")))){
                        q[i++] = stack.pop();
                        stack.push(c);
                    }

                    else{
                        stack.push(c);
                    }
                }
                else{
                    if(stack.peek().equals("^")){
                        q[i++] = stack.pop();
                        stack.push(c);
                    }
                    else{
                        stack.push(c);
                    }
                }
            }
            else  // if character is operand just add it to input string
            {
                q[i++] = c;
            }
        }

        return q;
    }



    /**
     * @param q  post fix string array
     * @return result after evaluating post fix string
     */
    public static double  calculate_postfix(String[] q) throws Exception{
        double result = 0;
        DoubleS stack = new DoubleS();
        stack.push(0.0);
        for(String c: q){
            if(c.equals("-") ||c.equals( "+") || c.equals("/") ||c.equals("*") || c.equals("^"))
            {
                try{
                    double op2 = stack.pop();
                    double op1 = stack.pop();

                    if(c.equals("+")){
                        stack.push(op1+op2);
                    }
                    else if(c.equals("-")){
                        stack.push(op1-op2);
                    }
                    else if(c.equals("*")){
                        // System.out.println(op1*op2);
                        stack.push(op1*op2);
                    }
                    else if(c.equals("/")){
                        stack.push(op1/op2);
                    }
                    else{
                        stack.push(Math.pow(op1, op2));
                    }
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                    throw(new Exception("Invalid Input"));
                }
            }
            else
            {
                stack.push(Double.valueOf(c));
            }
        }
        result = stack.pop();
        return result;
    }







    public double eval(String expression)
    {
        operandStack = new DoubleS();

        // Process each token
        processTokens(expression);
        // Get the result from the operand stack.
        return getFinalResult();
    }

    private double getFinalResult() {
        if (operandStack.isEmpty()) {
            postfix.setText("No value to return!");
            postfix.setTextColor(Color.RED);
        }

        if (operandStack.size() > 1) {
            postfix.setText("Too many operands!");
            postfix.setTextColor(Color.RED);
        }

        return operandStack.pop();
    }

    private void processTokens(String expression) {
        Scanner tokens = new Scanner(expression);
        String nextToken;
        while (tokens.hasNext()) {
            nextToken = tokens.next();

            // A number.  Push it on the operand stack.
            if (Character.isDigit(nextToken.charAt(0))) {
                double value = Double.parseDouble(nextToken);
                operandStack.push(value);
            }

            // Evaluate the operator and push the result onto the operand stack
            else if (isOperator(nextToken)) {
                double result = evalOp(nextToken);
                operandStack.push(result);
            }

            // A valid expression will have no other characters
            else {
                postfix.setText("Invalid character encountered");
                postfix.setTextColor(Color.RED);
            }
        }
        tokens.close();
    }

    private boolean isOperator(String str) {
        // All the operators are a single character.
        if (str.length() > 1) {
            return false;
        }

        return OPERATORS.indexOf(str.charAt(0)) != -1;
    }

    private double evalOp(String op) {
        // Get the operands
        if (operandStack.isEmpty()) {
            postfix.setText("Stack is empty");
            postfix.setTextColor(Color.RED);
        }
        double rhs = operandStack.pop();

        if (operandStack.isEmpty()) {
            postfix.setText("Stack is empty");
            postfix.setTextColor(Color.RED);
        }
        double lhs = operandStack.pop();

        // Perform the arithmetic.
        switch (op.charAt(0)) {
            case '+':
                return lhs + rhs;
            case '-':
                return lhs - rhs;
            case '*':
                return lhs * rhs;
            case '/':
                return lhs / rhs;
        }

        // There are no other valid operators.
        assert false;
        return 0;
    }






}


