package tbc.dma.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShoppingList extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;
    private LinearLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        parent = (LinearLayout) findViewById(R.id.Layout);

        if (savedInstanceState != null) {
            for (int i = 0; i < parent.getChildCount(); i++) {
                final TextView child = (TextView) parent.getChildAt(i);
                boolean isVisibleChild = savedInstanceState.getBoolean(Integer.toString(i) + "_visible");

                if (isVisibleChild) {
                    child.setVisibility(View.VISIBLE);
                    String text = savedInstanceState.getString(Integer.toString(i) + "_text");
                    child.setText(text);
                }
            }
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        for (int i = 0; i < parent.getChildCount(); i++) {
            final TextView child = (TextView) parent.getChildAt(i);

            if (child.getVisibility() == View.VISIBLE) {
                outState.putBoolean(Integer.toString(i) + "_visible", true);
                outState.putString(Integer.toString(i) + "_text", child.getText().toString());
            }
        }
    }

    public void requestAddItem(View view) {
        Intent intent = new Intent(this, AddItem.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {

            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(AddItem.EXTRA_REPLY);

                for (int i = 0; i < parent.getChildCount(); i++) {
                    final TextView child = (TextView) parent.getChildAt(i);

                    if (child.getVisibility() == View.INVISIBLE) {
                        child.setText(Integer.toString(i+1)+"."+reply);
                        child.setVisibility(View.VISIBLE);
                        break;
                    }
                }
            }
        }
    }
}