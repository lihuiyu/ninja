package edu.play.team.game;

import edu.play.team.struct.BitmapManger;
import edu.play.team.struct.StaticValueManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region.Op;

final public class Maps {
	/**
	 * ��ͼ�����ͣ�������ͼ��Ϊ12��
	 */
	public final static int MAP_TYPE1 = 0;
	public final static int MAP_TYPE2 = 1;
	public final static int MAP_TYPE3 = 2;
	public final static int MAP_TYPE4 = 3;
	public final static int MAP_TYPE5 = 4;
	public final static int MAP_TYPE6 = 5;
	public final static int MAP_TYPE7 = 6;
	public final static int MAP_TYPE8 = 7;
	public final static int MAP_TYPE9 = 8;
	public final static int MAP_TYPE10 = 9;
	public final static int MAP_TYPE11 = 10;
	public final static int MAP_TYPE12 = 11;
	/**
	 * ��ͼ��ͼ��
	 */
	private Bitmap map;
	/**
	 * ������
	 */
	RectF clipRect;
	/**
	 * �õ�ͼ���������
	 */
	private int mapType;
	/**
	 * �?�ٶ�
	 */
	private int scroll_speed;

	/**
	 * ��ͼ��x���
	 */
	private float map_x = 0;
	/**
	 * ��ͼ��y���
	 */
	private float map_y;

	/**
	 * ���췽��
	 * 
	 * @param bmp
	 *            ��ͼͼ��
	 * @param type
	 *            ��ͼ���� ,ȡֵ MAP_TYPE1 ~ MAP_TYPE12
	 * @param scW
	 *            ��Ļ���
	 * @param scH
	 *            ��Ļ�߶�
	 */
	public Maps(int type, StaticValueManager SVManager, RectF clipR) {
		mapType = type;
		map = BitmapManger.MAPS[type];
		clipRect = clipR;
	}

	/**
	 * ��ͼ�?
	 */
	public void Scroll() {
		float mapy = map_y;
		mapy += scroll_speed;
		if (mapy >= 0)
			mapy = 0;
		map_y = mapy;
	}

	/**
	 * ��ȡx���
	 * 
	 * @return x���
	 */
	final public float getX() {
		return map_x;
	}

	/**
	 * ��ȡy���
	 * 
	 * @return y���
	 */
	final public float getY() {
		return map_y;
	}

	/**
	 * ���Ʒ���
	 * 
	 * @param canvas
	 *            ����
	 * @param paint
	 *            ����
	 */
	public void draw(Canvas canvas, Paint paint) {
		canvas.clipRect(clipRect, Op.REPLACE);
		canvas.drawBitmap(map, map_x, map_y, paint);
	}
	
	

}
