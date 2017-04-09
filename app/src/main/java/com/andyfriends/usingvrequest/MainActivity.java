package com.andyfriends.usingvrequest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.Response;
import com.andyfriends.vrequest.VRequest;

public class MainActivity extends AppCompatActivity {

    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status = (TextView) findViewById(R.id.status);

        fetchSomething();
    }

    private void fetchSomething() {
        status.setText("SENDING REQUEST...");

        new VRequest()
                .with(this)
                .load("http://echo.jsontest.com/key/value/one/two")
                .onSuccess(new Response.Listener<MyObject>() {
                    @Override
                    public void onResponse(MyObject myObject) {
                        status.setText("Response OK: " + myObject.toString());
                    }
                })
                .onError(new Response.Listener() {
                    @Override
                    public void onResponse(Object response) {
                        status.setText("error - check Internet permission on Manifest");
                    }
                })
                .fetch();
    }
}
