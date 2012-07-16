package edu.play.team.struct;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * 
 * 
 * �洢λͼ����
 * 
 * @author lhy
 * 
 */
public class BitmapStruct {

	public static Matrix matrix = new Matrix();

	/**
	 * λͼ
	 */
	private Bitmap srcBitmap;
	/**
	 * λͼ����
	 */
	private int[] srcPixels;
	/**
	 * λͼ���
	 */
	private int width;
	/**
	 * λͼ�߶�
	 */
	private int height;

	/**
	 * ���췽��
	 * 
	 * @param src
	 *            λͼ��Դ
	 */
	public BitmapStruct(Bitmap src) {
		this.srcBitmap = src;
		width = src.getWidth();
		height = src.getHeight();
		srcPixels = new int[width * height];
		src.getPixels(srcPixels, 0, width, 0, 0, width, height);
	}

	/**
	 * ��ȡ����
	 * 
	 * @return ��������
	 */
	public int[] getPiexls() {
		return srcPixels;
	}

	/**
	 * ��ȡλͼ
	 * 
	 * @return λͼ��Դ
	 */
	public Bitmap getBitmap() {
		return srcBitmap;
	}

	/**
	 * ��ȡά��λͼ�Ŀ��
	 * 
	 * @return λͼ���
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * ��ȡά��λͼ�ĸ߶�
	 * 
	 * @return λͼ�߶�
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * �趨������ά����λͼ��Դ������͸����
	 * 
	 * @param alpha
	 *            ͸����
	 */
	public int[] setAlpha(int alpha) {
		alpha = alpha << 24;
		alpha = alpha & 0xff000000;
		int l = 0, r = 0;
		for (int i = 0; i < width * height; i++) {
			if ((srcPixels[l * width + r] & 0xff000000) != 0) {
				srcPixels[l * width + r] = ((srcPixels[l * width + r] & 0x00ffffff) | alpha);
			}
			r++;
			if (r == width) {
				r = 0;
				l++;
			}
			if (l == height)
				break;
		}
		return srcPixels;
	}

	/**
	 * �ṩ���ⲿ���������ڵ�����λͼ���ص�͸����
	 * 
	 * @param pixels
	 *            λͼ����
	 * @param width
	 *            λͼ��
	 * @param height
	 *            λͼ��
	 * @param alpha
	 *            λͼ͸����
	 * @return ����������
	 */
	public static int[] setAlpha(int pixels[], int width, int height, int alpha) {
		alpha = alpha << 24;
		alpha = alpha & 0xff000000;
		int l = 0, r = 0;
		for (int i = 0; i < width * height; i++) {
			if ((pixels[l * width + r] & 0xff000000) != 0) {
				pixels[l * width + r] = ((pixels[l * width + r] & 0x00ffffff) | alpha);
			}
			r++;
			if (r == width) {
				r = 0;
				l++;
			}
			if (l == height)
				break;
		}
		return pixels;
	}

}
