//package edu.play.team.game;
//
//import edu.play.team.struct.StaticValueManager;
//import edu.play.team.view.GameView;
//import edu.play.team.view.LogoView;
//import edu.play.team.view.ReaderView;
//import android.app.Activity;
//import android.content.pm.ActivityInfo;
//import android.content.res.Configuration;
//import android.content.res.Resources;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.util.DisplayMetrics;
//import android.view.Window;
//import android.view.WindowManager;
//
//public class PlaneActivity extends Activity {
//
//	private Configuration config;
//	private Resources resources;
//	private StaticValueManager SVManager;
//	private DisplayMetrics disManager;
//	public Handler handler;
//
//	/** Called when the activity is first created. */
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//
//		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//				WindowManager.LayoutParams.FLAG_FULLSCREEN);
//		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//		resources = this.getResources();
//		config = resources.getConfiguration();
//		SVManager = new StaticValueManager();
//
//		SVManager.setTouchscreen_Type(config.touchscreen);
//
//		disManager = new DisplayMetrics();
//		this.getWindowManager().getDefaultDisplay().getMetrics(disManager);
//
//		SVManager.setScreen_Width(disManager.widthPixels);
//		SVManager.setScreen_Height(disManager.heightPixels);
//
//		this.setContentView(new LogoView(this, SVManager));
//
//		/**
//		 * ����ά��һ�����̵߳�handlerThraed����
//		 */
//		handler = new Handler() {
//			@Override
//			public void handleMessage(Message msg) {
//				int info = msg.what;
//
//				switch (info) {
//				case 0:// logo������ϣ�׼��������Ϸ�˵�����
//					PlaneActivity.this.setContentView(new ReaderView(
//							PlaneActivity.this, SVManager));
//					break;
//				case 1:// �˵�����ѡ��ʼ��Ϸ��������Ϸ����
//					PlaneActivity.this.setContentView(new GameView(
//							PlaneActivity.this, SVManager,
//							GameView.OPERATION_TYPE_GRAVITY));
//					break;
//				case 2:// �˵�����ѡ�����ã��������ý���
//					break;
//				case 3:// �˵�����ѡ���˳����˳�
//					break;
//				case 4:
//					break;
//				}
//
//			}
//
//		};
//	}
//
//	final public Handler getHandler() {
//		return handler;
//	}
//
//	@Override
//	protected void onStart() {
//		// TODO Auto-generated method stub
//
//		super.onStart();
//		// System.out.println("start");
//
//	}
//
//	@Override
//	protected void onResume() {
//		// TODO Auto-generated method stub
//
//		super.onResume();
//		// System.out.println("resume");
//	}
//
//	@Override
//	protected void onPause() {
//		// TODO Auto-generated method stub
//
//		super.onPause();
//		// System.out.println("pause");
//	}
//
//	@Override
//	protected void onRestart() {
//		// TODO Auto-generated method stub
//
//		super.onRestart();
//		// System.out.println("restart");
//	}
//
//	@Override
//	protected void onStop() {
//		// TODO Auto-generated method stub
//
//		super.onStop();
//		// System.out.println("stop");
//		// System.out.println("aaa");
//
//	}
//
//	@Override
//	protected void onDestroy() {
//		// TODO Auto-generated method stub
//
//		super.onDestroy();
//		// System.out.println("destroy");
//
//	}
//}