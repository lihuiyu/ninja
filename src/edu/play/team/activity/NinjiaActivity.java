package edu.play.team.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import edu.play.team.utility.StaticValueManager;
import edu.play.team.view.StartView;

public class NinjiaActivity extends Activity {
    
	private Configuration config;
	private Resources resources;
	private StaticValueManager SVManager;
	private DisplayMetrics disManager;
	public Handler handler;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		resources = this.getResources();
		config = resources.getConfiguration();
		SVManager = new StaticValueManager();

		SVManager.setTouchscreen_Type(config.touchscreen);

		disManager = new DisplayMetrics();
		this.getWindowManager().getDefaultDisplay().getMetrics(disManager);

		SVManager.setScreen_Width(disManager.widthPixels);
		SVManager.setScreen_Height(disManager.heightPixels);
        
        setContentView(new StartView(this).getStartView());
        
    }
}