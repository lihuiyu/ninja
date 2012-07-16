package edu.play.team.struct;

/**
 * �洢��Ϸ����ʱ���õľ�̬����
 * 
 * @author lhy
 * 
 */
public class StaticValueManager {
	/**
	 * ��ҷɻ�ͼƬ�Ŀ��
	 */
	public final static float BMP_PLAYER_WIDTH = 50;
	/**
	 * ��ҷɻ�ͼƬ�ĸ߶�
	 */
	public final static float BMP_PLAYER_HEIGHT = 60;
	/**
	 * �л���С�ͷɻ�ʱͼƬ�Ŀ��
	 */
	public final static float BMP_SMALL_WIDTH = 30;
	/**
	 * �л���С�ͷɻ�ʱͼƬ�ĸ߶�
	 */
	public final static float BMP_SMALL_HEIGHT = 40;
	/**
	 * �л������ͷɻ�ʱͼƬ�Ŀ��
	 */
	public final static float BMP_MIDDLE_WIDTH = 50;
	/**
	 * �л������ͷɻ�ʱͼƬ�ĸ߶�
	 */
	public final static float BMP_MIDDLE_HEIGHT = 60;
	/**
	 * �л��Ǵ��ͷɻ�ʱͼƬ�Ŀ��
	 */
	public final static float BMP_BIG_WIDTH = 70;
	/**
	 * �л��Ǵ��ͷɻ�ʱͼƬ�ĸ߶�
	 */
	public final static float BMP_BIG_HEIGHT = 80;
	/**
	 * �л���bossʱͼƬ�Ŀ��
	 */
	public final static float BMP_BOSS_WIDTH = 90;
	/**
	 * �л���bossʱͼƬ�ĸ߶�
	 */
	public final static float BMP_BOSS_HEIGHT = 100;
	/**
	 * ��Ļ����
	 */
	private int Touchscreen_Type;
	/**
	 * ��Ļ���
	 */
	private int Screen_Width;
	/**
	 * ��Ļ�߶�
	 */
	private int Screen_Height;

	public void setTouchscreen_Type(int Touchscreen_type) {
		this.Touchscreen_Type = Touchscreen_type;
	}

	public int getTouchscreen_Type() {

		return Touchscreen_Type;
	}

	public void setScreen_Width(int screen_Width) {
		Screen_Width = screen_Width;
	}

	public int getScreen_Width() {
		return Screen_Width;
	}

	public void setScreen_Height(int screen_Height) {
		Screen_Height = screen_Height;
	}

	public int getScreen_Height() {
		return Screen_Height;
	}

}
