//package edu.play.team.game;
//
//import edu.play.team.struct.StaticValueManager;
//import android.content.res.Resources;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.graphics.RectF;
//import android.graphics.Region.Op;
//
///**
// * �����ϵ�ҡ��
// * 
// * @author lhy
// * 
// */
//public final class Rudder {
//	/** ҡ�˵����ͼƬ */
//	private Bitmap rudder_base;
//	/** ҡ��ͼƬ */
//	private Bitmap rudder;
//	/** ��ΧRudder����С���� */
//	private RectF OutRect;
//	/** ҡ�˰��� */
//	private boolean rudderTouched = false;
//	/** ҡ�˰뾶 */
//	private float rudder_radius;
//	/** ҡ�˻�뾶 */
//	public float move_radius = 60.0f;
//	/** ҡ�˵���뾶 */
//	private float base_radius = 120.0f;
//	/** ����Բ��xλ�� */
//	private float base_x;
//	/** ����Բ��yλ�� */
//	private float base_y;
//	/** ҡ��Բ��xλ�� */
//	private float rudder_x;
//	/** ҡ��Բ��yλ�� */
//	private float rudder_y;
//
//	public Rudder(StaticValueManager SVManager) {
//
//		rudder_radius = rudder.getHeight() >> 1;
//		base_radius = rudder_base.getHeight() >> 1;
//
//		base_x = rudder_radius + move_radius + 8.0f;
//		base_y = SVManager.getScreen_Height() - base_x;
//		rudder_x = base_x;
//		rudder_y = base_y;
//		float halfRect = rudder_radius + move_radius;
//		OutRect = new RectF(base_x - halfRect, base_y - halfRect, base_x
//				+ halfRect, base_y + halfRect);
//	}
//
//	public Rudder(Resources resources, StaticValueManager SVManager) {
//		rudder_base = BitmapFactory.decodeResource(resources,
//				R.drawable.rudder_base);
//
//		rudder = BitmapFactory.decodeResource(resources,
//				R.drawable.rudder_press);
//
//		rudder_radius = rudder.getHeight() >> 1;
//		base_radius = rudder_base.getHeight() >> 1;
//
//		base_x = rudder_radius + move_radius + 8.0f;
//		base_y = SVManager.getScreen_Height() - base_x;
//		rudder_x = base_x;
//		rudder_y = base_y;
//		float halfRect = rudder_radius + move_radius;
//		OutRect = new RectF(base_x - halfRect, base_y - halfRect, base_x
//				+ halfRect, base_y + halfRect);
//	}
//
//	public Rudder(Bitmap rud_b, Bitmap rud, StaticValueManager SVManager) {
//		rudder_base = rud_b;
//		rudder = rud;
//
//		rudder_radius = rud.getHeight() >> 1;
//		base_radius = rud_b.getHeight() >> 1;
//
//		base_x = rudder_radius + move_radius + 8.0f;
//		base_y = SVManager.getScreen_Height() - base_x;
//		rudder_x = base_x;
//		rudder_y = base_y;
//		float halfRect = rudder_radius + move_radius;
//		OutRect = new RectF(base_x - halfRect, base_y - halfRect, base_x
//				+ halfRect, base_y + halfRect);
//	}
//
//	/**
//	 * �趨ҡ�˵�Բ��λ��
//	 * 
//	 * @param ru_x
//	 *            ҡ��Բ��x���
//	 * @param ru_y
//	 *            ҡ��Բ��y���
//	 */
//	public void setLoc(float ru_x, float ru_y) {
//		rudder_x = ru_x;
//		rudder_y = ru_y;
//	}
//
//	public void draw(Canvas canvas, Paint paint) {
//		canvas.clipRect(OutRect, Op.REPLACE);
//		canvas.drawBitmap(rudder_base, base_x - base_radius, base_y
//				- base_radius, paint);
//		canvas.drawBitmap(rudder, rudder_x - rudder_radius, rudder_y
//				- rudder_radius, paint);
//	}
//	
//	final public void setTouched(boolean touch) {
//		rudderTouched = touch;
//	}
//
//	/**
//	 * �趨ҡ�˵���x
//	 * 
//	 * @param x
//	 *            x���
//	 */
//	final public void setBaseX(float x) {
//		base_x = x;
//	}
//
//	/**
//	 * �趨ҡ�˵���y
//	 * 
//	 * @param y
//	 *            y���
//	 */
//	final public void setBaseY(float y) {
//		base_y = y;
//	}
//
//	/**
//	 * �趨ҡ��Բ��x
//	 * 
//	 * @param x
//	 *            x���
//	 */
//	final public void setRudderX(float x) {
//		rudder_x = x;
//	}
//
//	/**
//	 * �趨ҡ��Բ��y
//	 * 
//	 * @param y
//	 *            y���
//	 */
//	final public void setRudderY(float y) {
//		rudder_y = y;
//	}
//
//	/**
//	 * �趨��Χ����
//	 * 
//	 * @param out
//	 *            ��Χ����
//	 */
//	final public void setOutRect(RectF out) {
//		OutRect = out;
//	}
//
//	/**
//	 * ���°�Χ����,��ҡ�˵����λ�÷���仯�����
//	 * 
//	 */
//	final public void updateOutRect() {
//		float halfRect = rudder_radius + move_radius;
//		OutRect.top = base_y - halfRect;
//		OutRect.left = base_x - halfRect;
//		OutRect.right = base_x + halfRect;
//		OutRect.bottom = base_y + halfRect;
//	}
//
//	/**
//	 * ��ȡ�����Բ��x
//	 * 
//	 * @return x���
//	 */
//	final public float getBaseX() {
//		return base_x;
//	}
//
//	/**
//	 * ��ȡ�����Բ��
//	 * 
//	 * @return y���
//	 */
//	final public float getBaseY() {
//		return base_y;
//	}
//
//	/**
//	 * ��ȡ�����Բ�뾶
//	 * 
//	 * @return �뾶
//	 */
//	final public float getBaseR() {
//		return base_radius;
//	}
//
//	/**
//	 * ��ȡҡ�˵�Բ��x
//	 * 
//	 * @return x���
//	 */
//	final public float getRudderX() {
//		return rudder_x;
//	}
//
//	/**
//	 * ��ȡҡ�˵�Բ��y
//	 * 
//	 * @return y���
//	 */
//	final public float getRudderY() {
//		return rudder_y;
//	}
//
//	/**
//	 * ��ȡ��뾶
//	 * 
//	 * @return ��뾶
//	 */
//	final public float getMoveR() {
//		return move_radius;
//	}
//
//	/**
//	 * ��ȡҡ�˰뾶
//	 * 
//	 * @return ҡ�˰뾶
//	 */
//	final public float getRudderR() {
//		return rudder_radius;
//	}
//
//	/**
//	 * ��ȡ��Χ����
//	 * 
//	 * @return ��Χ����
//	 */
//	final public RectF getOutRect() {
//		return OutRect;
//	}
//
//}
