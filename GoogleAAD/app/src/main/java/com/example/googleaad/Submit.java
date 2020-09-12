package com.example.googleaad;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

public class Submit extends AppCompatActivity {
    EditText firstNam, lstName, prohLink, email;
    Button submit;
    ProgressDialog progressDialog;
    RequestQueue queue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_layout);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }
        progressDialog = new PageViewModel(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");
        email = findViewById(R.id.email);
        firstNam = findViewById(R.id.frstName);
        lstName = findViewById(R.id.lstName);
        queue = Volley.newRequestQueue(getApplicationContext());
        prohLink = findViewById(R.id.);
        submit = findViewById(R.id.sub);
        submit.setOnClickListener(v -> openDialog());
    }

    public void postData(final  String name, final String email, final String lastname, final String link) {
    progressDialog.show();
    StringRequest request = new StringRequest(
        Request.Method.POST,
        Constants.url,
        reponse -> {
            Log.d("TAG", "Response: "+ reponse);
            if (reponse.length() > 0) {
               sucessDialog();
               Submit.this.email.setText(null);
               firstNam.setText(null);
               Submit.this.lstName.setText(null);
               prohLink.setText(null);
            }
             progressDialog.dismiss();
            }, error -> {
            progressDialog.dismiss();
            failedDialog();
        }) {
            @Override
            protected Map<String, String> getParams(){
            params.put(Constants.name, name);
            params.put(Constants.email, email);
            params.put(Constants.lastname, lastname);
            params.put(Constants.projectLink, link);
            return params;
          }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(
            60000,
        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
      queue.add(request);
    }

    private void failedDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.failed_popup);
        Button closeDialog = dialog.findViewById(R.id.failImg);
        closeDialog.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }


    private void openDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.confirm);
        Button yesDialog = dialog.findViewById(R.id.yes);
        Button noDialog = dialog.findViewById(R.id.closeimg);
        noDialog.setOnClickListener(v -> dialog.dismiss());
        yesDialog.setOnClickListener(v -> {
            postData(firstNam.getText().toString().trim(), email.getText().toString(), lstName.getText().toString(), prohLink.getText().toString());
            dialog.dismiss();
        });
    }

    private void sucessDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.sucess_popup);
        Button closeDialog = dialog.findViewById(R.id.successImg);
        closeDialog.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

}

}
