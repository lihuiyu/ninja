package edu.play.team.game;

import edu.play.team.struct.HitRect;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Region.Op;

final public class Enemy {
	/** �������� */
	public final static int ENEMY_TYPE_SMALL = 0;
	public final static int ENEMY_TYPE_MIDDLE = 1;
	public final static int ENEMY_TYPE_BIG = 2;
	public final static int ENEMY_TYPE_BOSS = 3;
	/** ����״̬ */
	public final static int STS_ATTACK = 1;
	public final static int STS_STOP = 2;
	public final static int STS_TEST_DISTANCE = 3;
	public final static int STS_TRACK = 4;
	public final static int STS_EVADE = 5;
	public final static int STS_END = 9;
	/** �л����״̬ */
	public final static int ENEMY_HEAD_NORTH = 0;
	public final static int ENEMY_HEAD_WEST = 2;
	public final static int ENEMY_HEAD_EAST = 1;
	public final static int ENEMY_HEAD_SOUTH = 3;
	/** �������� */
	private int type;
	/** ���˵�ǰ״̬ */
	private int state;
	/** �л��� */
	private int direction;
	/** ���˵�x��� */
	private float x;
	/** ���˵�y��� */
	private float y;
	/** ��ǰ֡ǰһ֡��x��� */
	private float preX;
	/** ��ǰ֡ǰһ֡��y��� */
	private float preY;
	/** �л��� */
	private float enemy_width;
	/** �л�߶� */
	private float enemy_height;
	/** ���˷����ٶ� */
	private float move_speed;
	/** ������ */
	private float stop_time = 0;
	/** �����Ѱ״̬���������л����С���������ʱ���л��Զ���������״̬������ʱ���Զ�����׷�پ��� */
	public final static float MIN_SEARCH_DIST = 80.0f;
	/** �л�İ�Χ�� */
	private HitRect enemyRect;
	/** �л�ǰ֡ǰһ֡�İ�Χ�� */
	private HitRect preRect;
	/** �л��ͼƬ��Դ */
	private Bitmap EnemyFrames[];
	
	private boolean isLive;

	
	
	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	/**
	 * ���췽��
	 */
	public Enemy(Bitmap Frames[]) {
		EnemyFrames = Frames;

		enemy_width = EnemyFrames[0].getWidth();
		enemy_height = EnemyFrames[0].getHeight();

		move_speed = 2.0f;
		state = STS_TEST_DISTANCE;
		direction = ENEMY_HEAD_NORTH;
		type = ENEMY_TYPE_MIDDLE;
		
		this.isLive=true;

		x = 240;
		y = 450;
		initRects();
	}

	public void draw(Canvas canvas, Matrix matrix, Paint paint) {

		canvas.clipRect(x, y, x + enemy_width, y + enemy_height, Op.REPLACE);
		matrix.reset();
		matrix.setScale(1.0f, -1.0f);
		matrix.postScale(-1.0f, 1.0f);
		matrix.postTranslate(x + enemy_width, y + enemy_height);

		canvas.drawBitmap(EnemyFrames[direction], matrix, paint);
	}

	/**
	 * ��ʼ����Χ��,�ѷɻ��Χ�зֳ������,�ɻ�����������
	 */
	private void initRects() {
		enemyRect = new HitRect();

		float px = x;
		float py = y;
		float pw = enemy_width;
		float ph = enemy_height;

		float temp = pw / 3;
		enemyRect.offsetX = temp;
		enemyRect.offsetY = ph / 6;
		enemyRect.width = temp;
		enemyRect.left = temp + px;
		enemyRect.right = temp + pw / 3 + px;
		temp = ph / 6;
		enemyRect.height = ph * 5 / 6;
		enemyRect.top = py + temp;
		enemyRect.bottom = py + ph;

		preRect = enemyRect;
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
	 * ��ȡ�л�����
	 * 
	 * @return �л�����
	 */
	public int getType() {
		return type;
	}

	/**
	 * ��ȡ��Χ��
	 * 
	 * @return ��Χ��
	 */
	public HitRect getHitRects() {
		return enemyRect;
	}

	/**
	 * �л�Ŀ������
	 * 
	 * @param targetX
	 *            Ŀ��x���
	 * @param targetY
	 *            Ŀ��y���
	 */
	public void move(float targetX, float targetY) {
		if(!isLive){
			return;
		}
		preX = x;
		preY = y;
		preRect = enemyRect;

		float tx = targetX - x;
		float ty = targetY - y;
		float dist = tx * tx + ty * ty;
		switch (state) {
		case STS_TEST_DISTANCE:
			if (MIN_SEARCH_DIST * MIN_SEARCH_DIST >= dist)
				state = STS_EVADE;
			else
				state = STS_TRACK;
			break;
		case STS_STOP:
			stop_time++;
			direction = ENEMY_HEAD_NORTH;
			if (stop_time > 60) {
				stop_time = 0;
				state = STS_TEST_DISTANCE;
			}
			break;
		case STS_TRACK:
			if (400 >= dist) {
				state = STS_STOP;
				break;
			}
			if (targetX > x) {
				x += move_speed;
				direction = ENEMY_HEAD_EAST;
			} else {
				x -= move_speed;
				direction = ENEMY_HEAD_WEST;
			}
			if (targetY > y) {
				y += move_speed;
			} else {
				y -= move_speed;
			}

			updateHitRect(x, y);

			break;
		case STS_EVADE:
			if (40000 <= dist) {
				state = STS_STOP;
				break;
			}
			if (targetX <= x) {
				x += move_speed;
				direction = ENEMY_HEAD_EAST;
			} else {
				x -= move_speed;
				direction = ENEMY_HEAD_WEST;
			}
			if (targetY <= y)
				y += move_speed;
			else
				y -= move_speed;

			updateHitRect(x, y);

			break;
		}
	}

	private void updateHitRect(float x, float y) {
		float offx = enemyRect.offsetX;
		float offy = enemyRect.offsetY;
		float width = enemyRect.width();
		float height = enemyRect.height();

		enemyRect.left = x + offx;
		enemyRect.top = y + offy;
		enemyRect.right = x + width + offx;
		enemyRect.bottom = y + height + offy;
	}

	/**
	 * ����move֮ǰ��״̬
	 */
	public void returnPre() {
		x = preX;
		y = preY;
		enemyRect = preRect;
	}
}
