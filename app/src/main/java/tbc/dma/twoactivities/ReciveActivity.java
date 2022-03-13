package tbc.dma.twoactivities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ReciveActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "Reply";
    private EditText mReply;
    private static final String LOG_TAG = ReciveActivity.class.getSimpleName();

    @Override
    public void onStart() {

        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recive);

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        mReply = findViewById(R.id.editText_second);

        Intent i=getIntent();
        String message = i.getStringExtra(MainActivity.EXTRA_MESSAGE);


        TextView textView = findViewById(R.id.textView3);
        textView.setText(message);
    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();

    }


    @Override
    protected void onPause() {

        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }
    @Override
    protected void onRestart() {

        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }
    @Override
    protected void onResume() {

        super.onResume();
        Log.d(LOG_TAG,"Resume");
    }
    @Override
    protected void onStop() {

        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }
}