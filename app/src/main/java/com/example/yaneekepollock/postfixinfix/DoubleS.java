package com.example.yaneekepollock.postfixinfix;

import java.util.EmptyStackException;

/**
 * Created by Yaneeke Pollock on 3/29/2018.
 */

public class DoubleS {
        private double[ ] data;
        private int manyItems;

        public DoubleS()
        {
            final int INITIAL_CAPACITY = 10;
            manyItems = 0;
            data = new double[INITIAL_CAPACITY];
        }

        public DoubleS(int initialCapacity)
        {
            if (initialCapacity < 0)
                throw new IllegalArgumentException
                        ("initialCapacity too small " + initialCapacity);
            manyItems = 0;
            data = new double[initialCapacity];
        }

        public Object clone( )
        {  // Clone a DoubleStack.
            DoubleS answer;

            try
            {
                answer = (DoubleS) super.clone( );
            }
            catch (CloneNotSupportedException e)
            {

                throw new RuntimeException
                        ("This class does not implement Cloneable");
            }

            answer.data = (double [ ]) data.clone( );

            return answer;
        }

        public void ensureCapacity(int minimumCapacity)
        {
            double biggerArray[ ];

            if (data.length < minimumCapacity)
            {
                biggerArray = new double[minimumCapacity];
                System.arraycopy(data, 0, biggerArray, 0, manyItems);
                data = biggerArray;
            }
        }

        public int getCapacity( )
        {
            return data.length;
        }

        public boolean isEmpty( )
        {
            return (manyItems == 0);
        }

        public double peek( )
        {
            if (manyItems == 0)
                throw new EmptyStackException( );
            return data[manyItems-1];
        }

        public double pop( )
        {
            if (manyItems == 0)
                throw new EmptyStackException( );
            return data[--manyItems];
        }

        public void push(double item)
        {
            if (manyItems == data.length)
            {

                ensureCapacity(manyItems*2 + 1);
            }
            data[manyItems] = item;
            manyItems++;
        }

        public int size( )
        {
            return manyItems;
        }
    }


