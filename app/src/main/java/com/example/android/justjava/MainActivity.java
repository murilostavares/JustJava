package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {

        double price = calcularPreco(num);
        String message = "Total: R$" + price + "\nObrigado!";
        displayMessage(message);

    }

    private int calcularPreco(int num) {

        int calculo = num * 5;
        return calculo;

    }

    public void increment(View view) {

        num++;
        displayQuantity(num);
    }

    public void decrement(View view) {

        num--;
        displayQuantity(num);
    }

    private void displayQuantity(int number) {

        TextView quantityTextView = (TextView) findViewById(R.id.quantidade_apresentada);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {

        TextView priceTextView = (TextView) findViewById(R.id.preco_apresentada);
        priceTextView.setText(message);
    }

}