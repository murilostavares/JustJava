package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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

        CheckBox chantilly = findViewById(R.id.checkbox_chantilly);
        boolean hasChantilly = chantilly.isChecked();

        CheckBox chocolate = findViewById(R.id.checkbox_chocolate);
        boolean hasChocolate = chocolate.isChecked();

        double price = calcularPreco(hasChantilly,hasChocolate);
        displayMessage(resumoPedido(price, hasChantilly, hasChocolate));
    }

    private String resumoPedido(double price, boolean hasChantilly, boolean hasChocolate) {

        EditText name = findViewById(R.id.nome_view);
        String nome = name.getText().toString();

        String chantillySN = "SIM";
        String chocolateSN = "SIM";

        if (hasChantilly == false) {
            chantillySN = "NÃO";
        }
        if (hasChocolate == false) {
            chocolateSN = "NÃO";
        }

        String message = "Nome: " + nome +
                "\nChantilly? :" + chantillySN +
                "\nChocolate? :" + chocolateSN +
                "\nQuantidade: " + num +
                "\nTotal: R$" + price +
                "\nObrigado!";

        return message;
    }

    private int calcularPreco(boolean hasChantilly, boolean hasChocolate) {

        int chantillyPreco = 5;
        int chocolatePreco = 5;

        if (hasChantilly == false) {

            chantillyPreco = 0;
        }

        if (hasChocolate == false) {

            chocolatePreco = 0;
        }

        int calculo = num * precoUnitario + chantillyPreco + chocolatePreco;

        return calculo;
    }

    public void increment(View view) {

        num++;
        displayQuantity(num);
    }

    public void decrement(View view) {

        if (num > 0) {

            num--;
        } else {

            num = 0;
        }


        displayQuantity(num);

    }

    private void displayQuantity(int number) {

        TextView quantityTextView = findViewById(R.id.quantidade_apresentada);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {

        TextView pedidoTextView = findViewById(R.id.pedido_apresentado);
        pedidoTextView.setText(message);
    }

}