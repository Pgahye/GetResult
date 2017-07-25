package com.jx372.getresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CallerActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_CALLEEACTIVITY =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_caller);

        findViewById(R.id.btnCallee).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CallerActivity.this, CalleeActivity.class);
                startActivityForResult(intent, REQUEST_CODE_CALLEEACTIVITY);
            }}


        );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == Activity.RESULT_OK){

            int dataNumber = getIntent().getIntExtra("data-number", -1);
            String dataString = getIntent().getStringExtra("data-String");

            String data = "data number:"+dataNumber + "\ndata String:" + dataString;

            ((TextView)findViewById(R.id.tvData)).setText(data);


        }else if(requestCode == REQUEST_CODE_CALLEEACTIVITY){



        }else{



        }
    }
}
