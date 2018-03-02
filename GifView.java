package com.example.naveen.mp3player;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import java.io.InputStream;

public class GifView
  extends View
{
  private InputStream gifInputStream;
  private Movie gifMovie;
  private long movieDuration;
  private int movieHeight;
  private long movieStart;
  private int movieWidth;
  
  public GifView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public GifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public GifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    setFocusable(true);
    this.gifInputStream = paramContext.getResources().openRawResource(2130837505);
    this.gifMovie = Movie.decodeStream(this.gifInputStream);
    this.movieWidth = this.gifMovie.width();
    this.movieHeight = this.gifMovie.height();
    this.movieDuration = this.gifMovie.duration();
  }
  
  public long getMovieDuration()
  {
    return this.movieDuration;
  }
  
  public int getMovieHeight()
  {
    return this.movieHeight;
  }
  
  public int getMovieWidth()
  {
    return this.movieWidth;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    long l = SystemClock.uptimeMillis();
    if (this.movieStart == 0L) {
      this.movieStart = l;
    }
    if (this.gifMovie != null)
    {
      int i = this.gifMovie.duration();
      if (i == 0) {
        i = 1000;
      }
      int j = (int)((l - this.movieStart) % i);
      this.gifMovie.setTime(j);
      this.gifMovie.draw(paramCanvas, 0.0F, 0.0F);
      invalidate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(this.movieWidth, this.movieHeight);
  }
}


/* Location:           C:\Users\naveen ram\Desktop\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.example.naveen.mp3player.GifView
 * JD-Core Version:    0.7.0.1
 */