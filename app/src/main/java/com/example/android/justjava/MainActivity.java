package com.example.android.justjava;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    double num = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        double price = num * 5;
        String message = "Total: R$" + price + "\nObrigado!";
        displayMessage (message);
    }

    public void increment(View view) {
        num++;
        display(num);
        }

    public void decrement(View view) {
        num--;
        display(num);
        }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(double number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantidade_apresentada);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(double number) {
        TextView priceTextView = (TextView) findViewById(R.id.preco_apresentada);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.preco_apresentada);
        priceTextView.setText(message);
    }

}