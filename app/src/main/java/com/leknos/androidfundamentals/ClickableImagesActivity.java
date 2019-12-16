package com.leknos.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ClickableImagesActivity extends AppCompatActivity {
    private String mOrderMessage;
    public static final String EXTRA_MESSAGE = "com.leknos.androidfundamentals.clickableimagesactivity.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickable_images);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClickableImagesActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
    }

    public void displayToast (String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showDonutOrder(View view) {
        mOrderMessage = getString(R.string.donut_order_message);
        displayToast(mOrderMessage);
        Intent intent = new Intent(ClickableImagesActivity.this, OrderActivity.class);
        intent.putExtra(ClickableImagesActivity.EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);
    }

    public void showIceCreamOrder(View view) {
        mOrderMessage = getString(R.string.ice_cream_order_message);
        displayToast(mOrderMessage);
        Intent intent = new Intent(ClickableImagesActivity.this, OrderActivity.class);
        intent.putExtra(ClickableImagesActivity.EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);
    }

    public void showFroyoOrder(View view) {
        mOrderMessage = getString(R.string.froyo_order_message);
        displayToast(mOrderMessage);
        Intent intent = new Intent(ClickableImagesActivity.this, OrderActivity.class);
        intent.putExtra(ClickableImagesActivity.EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);
    }

}
