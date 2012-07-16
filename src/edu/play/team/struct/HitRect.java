package edu.play.team.struct;

import android.graphics.RectF;

/**
 * �ɻ���״ͼƬ�İ�Χ��
 * 
 * @author lhy
 * 
 */
public class HitRect extends RectF {
	/**
	 * ����ڷɻ���״����x����ƫ����
	 */
	public float offsetX;
	/**
	 * ����ڷɻ���״����y����ƫ����
	 */
	public float offsetY;
	/**
	 * �þ��ο��
	 */
	public float width;
	/**
	 * �þ��θ߶�
	 */
	public float height;

	public HitRect() {
		super();
	}
}
