package com.leknos.androidfundamentals;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private Button sendButton;
    private EditText mMessageEditText;
    private TextView result;
    public static final String EXTRA_MESSAGE =
            "com.leknos.androidfundamentals.extra.MESSAGE";
    public static final int REQUEST_FOR_TEXT_DATA = 1;
    public static final int REQUEST_FOR_COLOR_DATA = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendButton = findViewById(R.id.button_main);
        mMessageEditText = findViewById(R.id.editText_main);
        result = findViewById(R.id.reply_article_subheading);
        getResources().getString(R.string.article_text);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mMessageEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivityForResult(intent, REQUEST_FOR_TEXT_DATA);
            }
        });
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        Intent intent = getIntent();
        Uri uri = intent.getData();
        if(uri != null){
            String uri_string = "URI: " + uri.toString();
            TextView textView = findViewById(R.id.text_uri_message);
            textView.setText(uri_string);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_FOR_TEXT_DATA) {
            if (resultCode == RESULT_OK) {
                    result.setText(data.getStringExtra(SecondActivity.EXTRA_REPLY));
            }
            else {
                result.setText("ERROR");
            }
        }

    }

    public void implicitIntent(View view) {
        Intent intent = new Intent(MainActivity.this, ImplicitIntentsActivity.class);
        startActivity(intent);
    }
}
