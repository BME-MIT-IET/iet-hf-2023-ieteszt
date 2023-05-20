

import java.awt.Graphics;

/**
 *	Field oszt�ly �r�k�l bel�le, �s kezeli a p�lya mez�inek a megjelen�t�s�t
 */
public interface FieldView {
	/**
	 * kirajzolja a mez�ket
	 */
	public void drawField(Graphics g, GameFrame frame);
	/**
	 * kiraljzolja a mez�ket �sszek�t�vonalakat
	 */
	public void drawNeigbourLine(Graphics g, GameFrame frame);
	
	/**
	 * kirajzolja a macit �s a virol�gust a mez�re
	 */
	public void drawIconOnField(Graphics g, GameFrame frame);	


}
