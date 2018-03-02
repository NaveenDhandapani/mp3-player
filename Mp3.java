package com.example.naveen.mp3player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;

public class Mp3
  extends Activity
{
  String[] items;
  ListView lv;
  
  public ArrayList<File> findSongs(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = paramFile.listFiles();
    int i = arrayOfFile.length;
    int j = 0;
    if (j < i)
    {
      File localFile = arrayOfFile[j];
      if ((localFile.isDirectory()) && (!localFile.isHidden())) {
        localArrayList.addAll(findSongs(localFile));
      }
      for (;;)
      {
        j++;
        break;
        if ((localFile.getName().endsWith(".mp3")) || (localFile.getName().endsWith(".mp4")) || (localFile.getName().endsWith(".Wav"))) {
          localArrayList.add(localFile);
        }
      }
    }
    return localArrayList;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968579);
    this.lv = ((ListView)findViewById(2131296262));
    final ArrayList localArrayList = findSongs(Environment.getExternalStorageDirectory());
    this.items = new String[localArrayList.size()];
    for (int i = 0; i < localArrayList.size(); i++) {
      this.items[i] = ((File)localArrayList.get(i)).getName().toString().replace(".mp3", "").replace(".mp4", "").replace(".Wav", "");
    }
    ArrayAdapter localArrayAdapter = new ArrayAdapter(getApplicationContext(), 2130968582, 2131296273, this.items);
    this.lv.setAdapter(localArrayAdapter);
    this.lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        Mp3.this.startActivity(new Intent(Mp3.this.getApplicationContext(), player.class).putExtra("pos", paramAnonymousInt).putExtra("songlist", localArrayList));
      }
    });
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131230724, paramMenu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131296274) {
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void toast(String paramString)
  {
    Toast.makeText(getApplicationContext(), paramString, 0).show();
  }
}


/* Location:           C:\Users\naveen ram\Desktop\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.example.naveen.mp3player.Mp3
 * JD-Core Version:    0.7.0.1
 */