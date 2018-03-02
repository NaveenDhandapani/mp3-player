package com.example.naveen.mp3player;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

public class Album
  extends Activity
{
  ImageView iv3;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968576);
    String str = getIntent().getStringExtra("img");
    this.iv3 = ((ImageView)findViewById(2131296256));
    this.iv3.setImageURI(Uri.parse(str));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131230720, paramMenu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131296274) {
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}


/* Location:           C:\Users\naveen ram\Desktop\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.example.naveen.mp3player.Album
 * JD-Core Version:    0.7.0.1
 */