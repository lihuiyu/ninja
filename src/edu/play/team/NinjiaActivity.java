package edu.play.team;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
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
        setContentView(new StartView(this).getStartView());
        
    }
}