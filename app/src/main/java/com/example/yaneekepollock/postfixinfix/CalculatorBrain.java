package com.example.yaneekepollock.postfixinfix;
/**
 * Created by Yaneeke Pollock on 3/29/2018.
 */
public class CalculatorBrain
{
    private double mOperand;
    private double mWaitingOperand;
    private String mWaitingOperator;
    private double mCalculatorMemory;
    // operator types
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

    public static final String CLEAR = "C" ;
    public static final String CLEARMEMORY = "MC";
    public static final String ADDTOMEMORY = "M+";
    public static final String SUBTRACTFROMMEMORY = "M-";
    public static final String RECALLMEMORY = "M";

    public CalculatorBrain() {
        // initialize variables upon start
        mOperand = 0;
        mWaitingOperand = 0;
        mWaitingOperator = "";
        mCalculatorMemory = 0;
    }

    public void setOperand(double operand) {
        mOperand = operand;
    }

    public double getResult() {
        return mOperand;
    }

    // used on screen orientation change
    public void setMemory(double calculatorMemory) {
        mCalculatorMemory = calculatorMemory;
    }

    // used on screen orientation change
    public double getMemory() {
        return mCalculatorMemory;
    }

    public String toString() {
        return Double.toString(mOperand);
    }

    protected double performOperation(String operator)
    {
        if (operator.equals(CLEAR))
        {
            mOperand = 0;
            mWaitingOperator = "";
            mWaitingOperand = 0;
           // mCalculatorMemory = 0;
        } else if (operator.equals(CLEARMEMORY))
        {
            mCalculatorMemory = 0;
        } else if (operator.equals(ADDTOMEMORY))
        {
            mCalculatorMemory = mCalculatorMemory + mOperand;
        } else if (operator.equals(SUBTRACTFROMMEMORY))
        {
            mCalculatorMemory = mCalculatorMemory - mOperand;
        } else if (operator.equals(RECALLMEMORY))
        {
            mOperand = mCalculatorMemory;
        }
        else {
            performWaitingOperation();
            mWaitingOperator = operator;
            mWaitingOperand = mOperand;
        }
        return mOperand;
    }

    protected void performWaitingOperation() {

        if (mWaitingOperator.equals(ADD))
        {
            mOperand = mWaitingOperand + mOperand;
        } else if
                (mWaitingOperator.equals(SUBTRACT))
        {
            mOperand = mWaitingOperand - mOperand;
        } else if (mWaitingOperator.equals(MULTIPLY))
        {
            mOperand = mWaitingOperand * mOperand;
        } else if (mWaitingOperator.equals(DIVIDE))
        {
            if (mOperand != 0)
            {
                mOperand = mWaitingOperand / mOperand;
            }
        }

    }
}