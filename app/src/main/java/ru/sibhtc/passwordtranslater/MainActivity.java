package ru.sibhtc.passwordtranslater;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText rusTranscriptText;
    private TextView engTranscriptText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button translateButton = (Button) findViewById(R.id.translateButtonId);
        Button copyToClipboardButton = (Button) findViewById(R.id.btnCopyToClipboardId);
        rusTranscriptText = (EditText)findViewById(R.id.rusTranscriptTextId);
        engTranscriptText = (TextView)findViewById(R.id.engTranscriptTextId);

        translateButton.setOnClickListener(this);
        copyToClipboardButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.aboutButtonId) {
            AboutButtonClickHandler();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.translateButtonId:
                TranslateButtonClickHandler();
                break;
            case R.id.btnCopyToClipboardId:
                CopyToClipboardButtonClickHandler();
                break;
            default:
                break;
        }
    }

    private void TranslateButtonClickHandler(){
        String rusTranscriptionStr = rusTranscriptText.getText().toString();
        String engTranscriptionStr = TextEncodingHelper.getEngPasswordTranscription(rusTranscriptionStr);
        engTranscriptText.setText(engTranscriptionStr);
    }

    private void CopyToClipboardButtonClickHandler(){
        String transcriptText = engTranscriptText.getText().toString();
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("transcriptPass", transcriptText);
        clipboard.setPrimaryClip(clip);
        Toast toast = Toast.makeText(getApplicationContext(), "Текст скопирован!", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void AboutButtonClickHandler(){
        AlertDialog dialog = DialogBuilderHelper.getDialog(this, DialogBuilderHelper.ABOUT_DIALOG);
        if (dialog != null)
            dialog.show();
    }
}
