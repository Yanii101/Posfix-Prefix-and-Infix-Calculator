package com.example.yaneekepollock.postfixinfix;

/**
 * Created by Yaneeke Pollock on 3/29/2018.
 */

public class StringStack
{

    private StackNode top;

    public StringStack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null ? true : false;
    }

    @SuppressWarnings("unused")
    public boolean isFull() {
        StackNode temp = new StackNode();
        if(temp==null)
        {
            return true;
        }else {
            temp = null;
            return false;
        }
    }

    public void push(String operand) {
        if(isFull()) {
            System.out.println("The stack is full");
        }else {
            StackNode temp =new StackNode(operand);
            if(isEmpty()) {
                top = temp;
            }else {
                temp.setLink(top);
                top = temp;
            }
        }
    }

    public String pop() {
        String popOperand = null;
        if(isEmpty()) {
            System.out.println("Sorry yo can't pop from an empty stack");
        }else {
            StackNode temp = top.getLink();
            popOperand = top.getOperand();
            top = null;
            top = temp;
        }
        return popOperand;
    }

    public void destroyStack() {
        while(!isEmpty()) {
            this.pop();
        }
    }

    public String peek() {
        return top.getOperand();
    }

    public StackNode getTopNextLink() {
        return top.getLink();
    }






}














