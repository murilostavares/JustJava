package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int num = 0;
    int precoUnitario = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {

        double price = calcularPreco(num);
        displayMessage(resumoPedido(price));
    }

    private String resumoPedido(double price) {

        String name = "Murilo de Souza Tavares";
        String message = "Nome: " + name +
                "\nQuantidade: " + num +
                "\nTotal: R$" + price +
                "\nObrigado!";

        return message;
    }

    private int calcularPreco(int num) {

        int calculo = num * precoUnitario;

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

        TextView pedidoTextView = (TextView) findViewById(R.id.pedido_apresentado);
        pedidoTextView.setText(message);
    }

}