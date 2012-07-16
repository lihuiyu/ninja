package edu.play.team.game;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorControl implements SensorEventListener {

	private Sensor gravitySensor;

	private SensorManager gravityManager;
	private Context context;

	private float preX=0;
	private float preY=0;
	private float preZ=0;

	private float x=0;
	private float y=0;
	private float z=0;

	private float sin;

	private float cos;

	private boolean isGravity;

	private boolean isControl = false;

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public boolean isControl() {
		return isControl;
	}

	public void setControl(boolean isControl) {
		this.isControl = isControl;
	}


	public float getSin() {
		float dis = (float) Math.sqrt(x * x + y * y);
		if (dis == 0)
			return 0;
		else {
			float sin = y / dis;
			return sin;
		}
	}

	public float getCos() {
		float dis = (float) Math.sqrt(x * x + y * y);
		if (dis == 0)
			return 0;
		else {
			float cos = 0 - x / dis;
			return cos;
		}
	}

	

	public SensorControl(Context context) {
		this.context = context;
		gravityManager = (SensorManager) context
				.getSystemService(Context.SENSOR_SERVICE);
		gravitySensor = gravityManager
				.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		isGravity = gravityManager.registerListener(this, gravitySensor,
				SensorManager.SENSOR_DELAY_GAME);
	}

	public boolean isGravity() {
		return isGravity;
	}

	public void setGravity(boolean isGravity) {
		this.isGravity = isGravity;
	}

	public void unregisterService() {
		if (isGravity) {
			gravityManager.unregisterListener(this);
			gravityManager = null;
		}
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		if (event.sensor == null) {
			return;
		}

		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			//preZ = z;
			x = event.values[SensorManager.DATA_X]*10;
			y = event.values[SensorManager.DATA_Y]*10;
			
			preX = x;
			preY = y;			
		}
	}

}
