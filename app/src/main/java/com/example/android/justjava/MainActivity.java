package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
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

        EditText name = findViewById(R.id.nome_view);
        String nome = name.getText().toString();

        CheckBox chantilly = findViewById(R.id.checkbox_chantilly);
        boolean hasChantilly = chantilly.isChecked();

        CheckBox chocolate = findViewById(R.id.checkbox_chocolate);
        boolean hasChocolate = chocolate.isChecked();

        double price = calcularPreco(hasChantilly, hasChocolate);

        String resumo = resumoPedido(nome, price, hasChantilly, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(intent.EXTRA_SUBJECT, "Just Java for " + nome);
        intent.putExtra(intent.EXTRA_TEXT, resumo);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }


    }

    private String resumoPedido(String nome, double price, boolean hasChantilly, boolean hasChocolate) {


        String chantillySN = "SIM";
        String chocolateSN = "SIM";

        if (!hasChantilly) {
            chantillySN = "NÃO";
        }
        if (!hasChocolate) {
            chocolateSN = "NÃO";
        }

        return "Nome: " + nome +
                "\nChantilly? :" + chantillySN +
                "\nChocolate? :" + chocolateSN +
                "\nQuantidade: " + num +
                "\nTotal: R$" + price +
                "\nObrigado!";
    }

    private int calcularPreco(boolean hasChantilly, boolean hasChocolate) {

        int chantillyPreco = 2;
        int chocolatePreco = 1;

        if (!hasChantilly) {
            chantillyPreco = 0;
        }

        if (!hasChocolate) {
            chocolatePreco = 0;
        }

        return num * (precoUnitario + chantillyPreco + chocolatePreco);
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


}