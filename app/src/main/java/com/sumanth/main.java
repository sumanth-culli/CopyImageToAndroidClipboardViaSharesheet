package com.sumanth;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class main extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        ClipboardManager mClipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        if (Intent.ACTION_SEND.equals(getIntent().getAction()) && extras.containsKey(Intent.EXTRA_STREAM)){
            try{
                mClipboardManager.setPrimaryClip(ClipData.newUri(getContentResolver(),"text",extras.getParcelable(Intent.EXTRA_STREAM)));
                Toast.makeText(this, "Copied image to clipboard", Toast.LENGTH_SHORT).show();
            } catch (Exception e){}
        }
    this.finish();
    }
}