package com.example.naveen.mp3player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Files
  extends Activity
{
  Button button;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968577);
    this.button = ((Button)findViewById(2131296259));
    this.button.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(Files.this, Mp3.class);
        Files.this.startActivity(localIntent);
      }
    });
    this.button = ((Button)findViewById(2131296260));
    this.button.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(Files.this, Gallerys.class);
        Files.this.startActivity(localIntent);
      }
    });
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131230721, paramMenu);
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
 * Qualified Name:     com.example.naveen.mp3player.Files
 * JD-Core Version:    0.7.0.1
 */