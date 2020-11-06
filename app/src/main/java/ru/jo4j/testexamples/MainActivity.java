package ru.jo4j.testexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText text;
    private EditText emailField;
    private Button btnSend;
    private TextView statusLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.edit_text);
        btnSend = findViewById(R.id.send_button);
        emailField = findViewById(R.id.edit_email);
        statusLabel = findViewById(R.id.text_of_status);
        btnSend.setOnClickListener(v -> {
            String email = emailField.getText().toString();
            Validator<String> emailValidator = new EmailValidator();
            if (emailValidator.validate(email)) {
                statusLabel.setText("Succes");
            } else {
                statusLabel.setText("Validation Error!!!");
            }
        });
    }
}