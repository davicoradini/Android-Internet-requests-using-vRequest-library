package com.andyfriends.android_internet_requests_using_vrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Response;
import com.andyfriends.vrequest.VRequest;

public class MainActivity extends AppCompatActivity {

    private TextView status;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status = (TextView) findViewById(R.id.status);

        fetchSomething();
    }

    private void fetchSomething() {
        status.setText("SENDING REQUEST...\n");

        final VRequest request = new VRequest();
        request
                .with(this)
                .load("http://echo.jsontest.com/key/value/one/two?page=1")
                .onSuccess(new Response.Listener<MyObject>() {
                    @Override
                    public void onResponse(MyObject myObject) {
                        status.setText(status.getText() + "response " +  String.valueOf(count) + ": " + myObject.toString() + "\n");

                        if (++count < 10) {
                            request.fetch();
                        }
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
