package tbc.dma.twoactivities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ReciveActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "Reply";
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recive);

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
        finish();

    }
}