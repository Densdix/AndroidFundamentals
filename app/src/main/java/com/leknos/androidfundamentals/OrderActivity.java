package com.leknos.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {
    private TextView orderTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        orderTextView = findViewById(R.id.order_textview);

        Intent intent = getIntent();
        String message = "Order: "+ intent.getStringExtra(ClickableImagesActivity.EXTRA_MESSAGE);
        orderTextView.setText(message);

    }
}
