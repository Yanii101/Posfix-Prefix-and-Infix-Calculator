package com.example.yaneekepollock.postfixinfix;

/**
 * Created by Yaneeke Pollock on 3/29/2018.
 */

public class StackNode {
    private StackNode link;
    private String operand;

    public StackNode() {
        this(null);
        link = null;
    }
    public StackNode(String operand) {
        this.operand = operand;
        link = null;
    }
    public StackNode getLink() {
        return link;
    }
    public void setLink(StackNode link) {
        this.link = link;
    }
    public String getOperand() {
        return operand;
    }
    public void setOperand(String operand) {
        this.operand = operand;
    }
    @Override
    public String toString() {
        return "Node [link=" + link + ", operand=" + operand + ", getLink()=" + getLink() + ", getOperand()="
                + getOperand() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }

}
