package com.piptest2;

import android.util.Log;

import com.facebook.react.ReactActivity;

public class MainActivity extends ReactActivity {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "piptest2";
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.e("MAIN", "PAUSE");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.e("MAIN", "RESUME");
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    Log.e("MAIN", "BACK PRESS");
  }
}
