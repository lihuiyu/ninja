package edu.play.team.game;

import java.util.LinkedList;

import edu.play.team.struct.HitRect;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Region.Op;

/**
 * ��ҿ��Ƶķɻ�
 * 
 * @author lhy
 * 
 */
public class Plane {
	// ��Ӧ�ɻ��ǰ��
	public final static int PLANE_HEAD_NORTH = 0;
	// ��Ӧ�ɻ����ƫ
	public final static int PLANE_HEAD_WEST = 1;
	// ��Ӧ�ɻ����ƫ
	public final static int PLANE_HEAD_EAST = 2;
	// ��Ӧ�ɻ�ĺ���
	public final static int PLANE_HEAD_SOUTH = 3;
	// ��Ӧ�ɻ��ͣ��ԭλ
	public final static int PLANE_STOP = 4;

	public final static int PLANE_FIRE = 5;

	private int Total_Fra_Num;
	private int direction;
	private int screenWidth;
	private int screenHeight;
	/** �ɻ���ʶ����fireFlag=PLANE_FIREʱ���ɻ����ӵ� */
	private int fireFlag;

	private float planeWidth;
	private float planeHeight;
	private float Move_Speed;
	private float x;
	private float y;
	private float preX;
	private float preY;
	private float cos;
	private float sin;
	private float Previous_Index = 0;
	private float Play_Speed;
	private boolean isAlive = true;
	private Bitmap PlaneFrames[];// ��Ӧ�ɻ��ƶ�ʱ��ͼƬ
	/** �ɻ�ǰ�İ�Χ�� */
	private HitRect planeRect;
	/** �ɻ�ǰ֮֡ǰ�İ�Χ�� */
	private HitRect preRect;

	public Plane() {
		Move_Speed = 1.0f;
		direction = PLANE_STOP;
	}

	/**
	 * ���췽��
	 * 
	 * @param Frames
	 *            �ɻ��ͼƬ
	 * @param Total_Fra_Num
	 *            ��֡��
	 * @param Play_Speed
	 *            �����ٶ�
	 * @param scW
	 *            ��Ļ���
	 * @param scH
	 *            ��Ļ�߶�
	 */
	public Plane(Bitmap Frames[], int Total_Fra_Num, float Play_Speed, int scW,
			int scH) {
		PlaneFrames = Frames;
		planeWidth = Frames[0].getWidth();
		planeHeight = Frames[0].getHeight();
		fireFlag = 0;
		this.Total_Fra_Num = Total_Fra_Num;
		this.Play_Speed = Play_Speed;
		Move_Speed = 3.0f;
		screenWidth = scW;
		screenHeight = scH;
		x = (scW - planeWidth) / 2;
		y = scH - planeHeight;
		direction = PLANE_HEAD_NORTH;
		initRects();// ��ʼ����Χ��
	}

	/**
	 * ��ʼ����Χ��,�ѷɻ��Χ�зֳ������,�ɻ�����������
	 */
	private void initRects() {
		planeRect = new HitRect();

		float px = x;
		float py = y;
		float pw = planeWidth;
		float ph = planeHeight;

		float temp = pw / 3;
		planeRect.offsetX = temp;
		planeRect.offsetY = ph / 6;
		planeRect.width = temp;
		planeRect.left = temp + px;
		planeRect.right = temp + pw / 3 + px;
		temp = ph / 6;
		planeRect.height = ph * 5 / 6;
		planeRect.top = py + temp;
		planeRect.bottom = py + ph;

		preRect = planeRect;
	}

	/**
	 * �趨�ɻ��ͼ��
	 * 
	 * @param Frames
	 *            ͼƬ
	 * @param Total_Fra_Num
	 *            ͼƬ������
	 */
	public void setFrames(Bitmap Frames[], int Total_Fra_Num) {
		this.PlaneFrames = Frames;
		this.Total_Fra_Num = Total_Fra_Num;
	}

	/**
	 * �趨��ǰ�Ĳ����ٶ�
	 * 
	 * @param Play_Speed
	 */
	public void setPlaySpeed(float Play_Speed) {
		this.Play_Speed = Play_Speed;
	}

	/**
	 * �趨��ǰ��x���
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * �趨��ǰ��y���
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * �趨�ɻ�ķ���
	 * 
	 * @param direction
	 *            �ɻ�ķ��򣬿���ѡȡ��ֵΪ PLANE_FORWORD-ǰ��
	 *            PLANE_LEFT-���ƣ�PLANE_RIGHT-���ƣ�PLANE_BACK-����
	 */
	public void setDirection(int dir) {
		direction = dir;
	}

	/**
	 * �ɻ���ƶ������ø�ĽǶ��Լ�Ҫ�ƶ��ľ����С�趨x,y
	 * 
	 * @param sin
	 *            ��Ľǵ�sin
	 * @param cos
	 *            ��Ľǵ�cos
	 * @param distance
	 *            ����ƶ�����
	 */
	public void move(float sin, float cos) {
		if (!isAlive)
			return;
		preX = x;
		preY = y;
		this.cos = cos;
		this.sin = sin;
		preRect = planeRect;
		x += cos * Move_Speed;
		y += sin * Move_Speed;

		if (x <= 0)
			x = 0;
		float max = screenWidth - planeWidth;
		if (x >= max)
			x = max;
		if (y <= 0)
			y = 0;
		max = screenHeight - planeHeight;
		if (y >= max)
			y = max;

		float offx = planeRect.offsetX;
		float offy = planeRect.offsetY;
		float width = planeRect.width;
		float height = planeRect.height;

		planeRect.left = x + offx;
		planeRect.top = y + offy;
		planeRect.right = x + width + offx;
		planeRect.bottom = y + height + offy;

		if (Math.abs(sin) > 0.86) {
			if (sin > 0) {// ƫת�Ǵ���60��С��120��
				direction = PLANE_HEAD_SOUTH;
				return;
			} else {// ƫת�Ǵ���240��С��300��
				direction = PLANE_HEAD_NORTH;
				return;
			}
		} else {// ƫת��С��60�����120С��240�����300
			if (cos > 0) {
				direction = PLANE_HEAD_EAST;
				return;
			} else {
				direction = PLANE_HEAD_WEST;
				return;
			}

		}

	}

	/**
	 * ���Ƶ�ǰ�ķɻ�
	 * 
	 * @param canvas
	 *            ����
	 * @param paint
	 *            ����
	 */
	public void draw(Canvas canvas, Paint paint) {
		canvas.clipRect(x, y, x + planeWidth, y + planeHeight, Op.REPLACE);
		canvas.drawBitmap(PlaneFrames[direction], x, y, paint);

	}

	public void fire(LinkedList<Bullte> bulltes) {
		int f = fireFlag;
		fireFlag = (f + 1) % PLANE_FIRE;
		if (fireFlag == 0) {
			Bullte b = new Bullte(null, screenWidth, screenHeight, x, y, 0, -1);
			bulltes.add(b);
		}
	}

	/**
	 * ����move֮ǰ��״̬
	 */
	public void returnPre() {
		x = preX;
		y = preY;
		planeRect = preRect;
	}

	/**
	 * ��ȡx���
	 * 
	 * @return x���
	 */
	public float getX() {
		return x;
	}

	/**
	 * ��ȡy���
	 * 
	 * @return y���
	 */
	public float getY() {
		return y;
	}

	/**
	 * ��ȡ�ɻ�Ŀ��
	 * 
	 * @return ���
	 */
	public float getWidth() {
		return planeWidth;
	}

	/**
	 * ��ȡ�ɻ�ĸ߶�
	 * 
	 * @return �߶�
	 */
	public float getHeight() {
		return planeHeight;
	}

	/**
	 * ��ȡ��Χ��
	 * 
	 * @return ��Χ��
	 */
	public HitRect getHitRects() {
		return planeRect;
	}
}
