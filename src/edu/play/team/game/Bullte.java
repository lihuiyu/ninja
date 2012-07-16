package edu.play.team.game;

import edu.play.team.struct.HitRect;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Region.Op;

public class Bullte {
	private float x;
	private float y;
	private float cos;
	private float sin;
	private float width;
	private float height;
	private float move_speed;

	private int screenWidth;
	private int screenHeight;

	private boolean isAlive;

	private HitRect bullteRect;

	private Bitmap BullteFrame[];

	public Bullte(Bitmap Frames[], int scW, int scH, float x, float y,
			float cos, float sin) {
		BullteFrame = Frames;
		// planeWidth = Frames[0].getWidth();
		// planeHeight = Frames[0].getHeight();
		width = 6;
		height = 6;

		move_speed = 5.0f;
		screenWidth = scW;
		screenHeight = scH;
		this.x = x;
		this.y = y;
		isAlive = true;
		this.cos = cos;
		this.sin = sin;

		initRects();// ��ʼ����Χ��
	}

	private void initRects() {
		bullteRect = new HitRect();

		float px = x;
		float py = y;
		float pw = width;
		float ph = height;

		bullteRect.width = pw;
		bullteRect.left = px;
		bullteRect.right = pw + px;
		bullteRect.height = ph;
		bullteRect.top = py;
		bullteRect.bottom = py + ph;

	}

	public void move() {
		if (!isAlive)
			return;
		x += cos * move_speed;
		y += sin * move_speed;
		//x+=move_speed;
		//y+=move_speed;
		
		if (x <= -width || x >= screenWidth || y <= -height
				|| y >= screenHeight) {
			this.isAlive = false;
			return;
		}

	}

	public boolean isLive() {
		return isAlive;
	}

	public void draw(Canvas canvas, Paint paint, Matrix matrix) {
		canvas.clipRect(x, y, x + width, y + height, Op.REPLACE);
		int color = paint.getColor();
		paint.setColor(Color.GREEN);
		// canvas.drawCircle(x + width / 2, y + height / 2, width / 2, paint);
		canvas.drawRect(x, y, x + width, y + height, paint);
		paint.setColor(color);
		// canvas.drawBitmap(PlaneFrames[direction], x, y, paint);
	}
}
