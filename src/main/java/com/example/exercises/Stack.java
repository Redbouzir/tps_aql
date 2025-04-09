package com.example.exercises;

public class Stack {
    private int[] array;
    private int top;
    private static final int INITIAL_CAPACITY = 10;

    public Stack() {
        array = new int[INITIAL_CAPACITY];
        top = -1;
    }

    public void push(int element) {
        if (top == array.length - 1) {
            expandArray();
        }
        array[++top] = element;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    private void expandArray() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
} 