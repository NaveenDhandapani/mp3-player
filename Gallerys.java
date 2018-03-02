package com.example.naveen.mp3player;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import java.io.File;
import java.util.ArrayList;

public class Gallerys
  extends Activity
{
  GridView gv;
  ArrayList<File> list;
  
  ArrayList<File> imageReader(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = paramFile.listFiles();
    int i = 0;
    if (i < arrayOfFile.length)
    {
      if (arrayOfFile[i].isDirectory()) {
        localArrayList.addAll(imageReader(arrayOfFile[i]));
      }
      for (;;)
      {
        i++;
        break;
        if (arrayOfFile[i].getName().endsWith(".jpg")) {
          localArrayList.add(arrayOfFile[i]);
        }
      }
    }
    return localArrayList;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968578);
    this.list = imageReader(Environment.getExternalStorageDirectory());
    this.gv = ((GridView)findViewById(2131296261));
    this.gv.setAdapter(new GridAdapter());
    this.gv.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        Gallerys.this.startActivity(new Intent(Gallerys.this.getApplicationContext(), Album.class).putExtra("img", ((File)Gallerys.this.list.get(paramAnonymousInt)).toString()));
      }
    });
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131230723, paramMenu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131296274) {
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  class GridAdapter
    extends BaseAdapter
  {
    GridAdapter() {}
    
    public int getCount()
    {
      return Gallerys.this.list.size();
    }
    
    public Object getItem(int paramInt)
    {
      return Gallerys.this.list.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = Gallerys.this.getLayoutInflater().inflate(2130968581, paramViewGroup, false);
      ((ImageView)localView.findViewById(2131296271)).setImageURI(Uri.parse(getItem(paramInt).toString()));
      return localView;
    }
  }
}


/* Location:           C:\Users\naveen ram\Desktop\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.example.naveen.mp3player.Gallerys
 * JD-Core Version:    0.7.0.1
 */