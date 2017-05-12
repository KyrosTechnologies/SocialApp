package com.kyrostechnologies.template.social;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.kyrostechnologies.template.social.data.Tools;

public class ActivityRegistration extends AppCompatActivity {

    private EditText inputName, inputEmail, inputCountry, inputCity;
    private Button btnSignUp;
    private View parent_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        parent_view = findViewById(android.R.id.content);


        inputName = (EditText) findViewById(R.id.input_name);
        inputCountry = (EditText) findViewById(R.id.input_country);
        inputCity = (EditText) findViewById(R.id.input_city);
        inputEmail = (EditText) findViewById(R.id.input_email);

        btnSignUp = (Button) findViewById(R.id.btn_signup);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

        // for system bar in lollipop
        Tools.systemBarLolipop(this);
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateName()) {
            return;
        }

        if (!validateEmail()) {
            return;
        }

        if (!validateCountry()) {
            return;
        }

        if (!validateCity()) {
            return;
        }

        Snackbar.make(parent_view, "Registration Success", Snackbar.LENGTH_SHORT).show();
        hideKeyboard();
    }

    private boolean validateName() {
        if (inputName.getText().toString().trim().isEmpty()) {
            //inputLayoutName.setError(getString(R.string.err_msg_name));
            Snackbar.make(parent_view, getString(R.string.err_msg_name), Snackbar.LENGTH_SHORT).show();
            requestFocus(inputName);
            return false;
        }
        return true;
    }

    private boolean validateCountry() {
        if (inputCountry.getText().toString().trim().isEmpty()) {
            Snackbar.make(parent_view, getString(R.string.err_msg_country), Snackbar.LENGTH_SHORT).show();
            requestFocus(inputCountry);
            return false;
        }
        return true;
    }

    private boolean validateCity() {
        if (inputCity.getText().toString().trim().isEmpty()) {
            Snackbar.make(parent_view, getString(R.string.err_msg_city), Snackbar.LENGTH_SHORT).show();
            requestFocus(inputCity);
            return false;
        }
        return true;
    }

    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            Snackbar.make(parent_view, getString(R.string.err_msg_email), Snackbar.LENGTH_SHORT).show();
            requestFocus(inputEmail);
            return false;
        }
        return true;
    }
    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
