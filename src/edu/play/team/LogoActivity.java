package edu.play.team;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.Toast;

public class LogoActivity extends Activity{
	public static final int COMPEITITON_LOGO_OUT=0;
	public static final int TEAM_LOGO_IN=1;
	public static final int ENTER_GAME=2;

	private ImageView tlogoImage;
	Handler mhandler;
	private Message msg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.logo_layout);	
		tlogoImage=(ImageView)findViewById(R.id.team_logo_image);
		
		mhandler = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				int info=msg.what;
				System.out.println(info);
				switch(info){
				case COMPEITITON_LOGO_OUT:													
					Animation animation_out = AnimationUtils.loadAnimation(
							LogoActivity.this, R.anim.fadeout);
					tlogoImage.startAnimation(animation_out);
					animation_out.setAnimationListener(new AnimationListener() {
						public void onAnimationStart(Animation animation) {
						}
						public void onAnimationRepeat(Animation animation) {

						}
						public void onAnimationEnd(Animation animation) {
							LogoActivity.this.msg=mhandler.obtainMessage();
							LogoActivity.this.msg.what = TEAM_LOGO_IN;
							mhandler.sendMessage(LogoActivity.this.msg);
						}
					});				
					break;
				case TEAM_LOGO_IN:
					tlogoImage.setImageResource(R.drawable.ic_launcher);				
					Animation animation_in = AnimationUtils.loadAnimation(
							LogoActivity.this, R.anim.fadein);
					tlogoImage.startAnimation(animation_in);
					animation_in.setAnimationListener(new AnimationListener() {
						public void onAnimationStart(Animation animation) {
						}
						public void onAnimationRepeat(Animation animation) {

						}
						public void onAnimationEnd(Animation animation) {
							LogoActivity.this.msg=mhandler.obtainMessage();
							LogoActivity.this.msg.what = ENTER_GAME;
							mhandler.sendMessage(LogoActivity.this.msg);
						}
					});					
					break;				
				case ENTER_GAME:
					Intent i = new Intent();
					i.setClass(LogoActivity.this, NinjiaActivity.class);
					LogoActivity.this.startActivity(i);
					overridePendingTransition(R.anim.fadein, R.anim.fadeout);
					LogoActivity.this.finish();
					break;
				}
			}	
		};
		
		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					msg = mhandler.obtainMessage();
					msg.what = COMPEITITON_LOGO_OUT;
					mhandler.sendMessage(msg);
				} catch (Exception e) {
					Toast.makeText(LogoActivity.this, "启动失败，请重试", Toast.LENGTH_LONG).show();
					LogoActivity.this.finish();
				}
			}
		}.start();	
	}
	
	

}
