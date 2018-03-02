package com.example.naveen.mp3player;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import java.io.File;
import java.util.ArrayList;

public class player
  extends Activity
  implements View.OnClickListener
{
  static MediaPlayer mp;
  Button btfb;
  Button btff;
  Button btnt;
  Button btplay;
  Button btpv;
  ArrayList<File> mySongs;
  int position;
  SeekBar sb;
  Uri u;
  Thread updateSeekBar;
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131296265: 
      if (mp.isPlaying())
      {
        this.btplay.setText(">");
        mp.pause();
        return;
      }
      mp.start();
      this.btplay.setText("||");
      return;
    case 2131296268: 
      mp.seekTo(5000 + mp.getCurrentPosition());
      return;
    case 2131296266: 
      mp.seekTo(-5000 + mp.getCurrentPosition());
      return;
    case 2131296269: 
      mp.stop();
      mp.release();
      this.position = ((1 + this.position) % this.mySongs.size());
      this.u = Uri.parse(((File)this.mySongs.get(this.position)).toString());
      mp = MediaPlayer.create(getApplicationContext(), this.u);
      mp.start();
      this.sb.setMax(mp.getDuration());
      this.sb.setMax(mp.getDuration());
      return;
    }
    mp.stop();
    mp.release();
    if (-1 + this.position < 0) {}
    for (int i = -1 + this.mySongs.size();; i = -1 + this.position)
    {
      this.position = i;
      this.u = Uri.parse(((File)this.mySongs.get(this.position)).toString());
      mp = MediaPlayer.create(getApplicationContext(), this.u);
      mp.start();
      this.sb.setMax(mp.getDuration());
      this.sb.setMax(mp.getDuration());
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968580);
    this.btplay = ((Button)findViewById(2131296265));
    this.btfb = ((Button)findViewById(2131296266));
    this.btff = ((Button)findViewById(2131296268));
    this.btpv = ((Button)findViewById(2131296267));
    this.btnt = ((Button)findViewById(2131296269));
    this.btplay.setOnClickListener(this);
    this.btfb.setOnClickListener(this);
    this.btff.setOnClickListener(this);
    this.btpv.setOnClickListener(this);
    this.btnt.setOnClickListener(this);
    this.sb = ((SeekBar)findViewById(2131296270));
    this.updateSeekBar = new Thread()
    {
      public void run()
      {
        int i = player.mp.getDuration();
        int j = 0;
        while (j < i) {
          try
          {
            sleep(500L);
            j = player.mp.getCurrentPosition();
            player.this.sb.setProgress(j);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    };
    if (mp != null)
    {
      mp.stop();
      mp.release();
    }
    Bundle localBundle = getIntent().getExtras();
    this.mySongs = localBundle.getParcelableArrayList("songlist");
    this.position = localBundle.getInt("pos", 0);
    Uri localUri = Uri.parse(((File)this.mySongs.get(this.position)).toString());
    mp = MediaPlayer.create(getApplicationContext(), localUri);
    mp.start();
    this.sb.setMax(mp.getDuration());
    this.updateSeekBar.start();
    this.sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean) {}
      
      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
        player.mp.seekTo(paramAnonymousSeekBar.getProgress());
      }
    });
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131230725, paramMenu);
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
 * Qualified Name:     com.example.naveen.mp3player.player
 * JD-Core Version:    0.7.0.1
 */