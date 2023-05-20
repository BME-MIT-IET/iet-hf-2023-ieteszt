import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
/**
 * Egy j�t�k k�perny�n l�v� gombot reprezent�l� oszt�ly
 * Kezeli, hogy milyen gomb �s mit t�rt�nik, ha megnyomj�k
 */
public class MyButton extends JButton{
	/**
	 * Milyen tipus� a gomb, mit t�rt�njen ha megnyomj�k
	 */
	int milyen;
	/**
	 * GameConrtoller, a grafikus vez�rtl�t jegyzi meg, hogy minek kell sz�lnia ha megnyomj�k
	 */
	transient GameController controll;
	/**
	 * Inizcializ�lja a gombot
	 * @param p megkapja, hogy milyen tipus� a gomb, minek kell rajta lennie
	 * @param c megkapja GaemController-t akinek sz�lnia kell ha lenyomt�k
	 */
	public void init(int p,GameController c){
		milyen=p;
		controll=c;
		if(milyen==1) {
			this.setText("Attack");
		}
		if(milyen==2) {
			this.setText("Drop Item");
		}
		if(milyen==3) {
			this.setText("Move");
		}
		if(milyen==4) {
			this.setText("PickUp");
		}
		if(milyen==6) {
			this.setText("Craft");
		}
		if(milyen==0) {
			this.setText("Steal");
		}
		this.addActionListener(new Push());
	}
	/**
	 * JButton-os bels� ActionListener kezeli ha lenyomj�k a gombot
	 */
	public class Push implements ActionListener{
		/**
		 * Fel�ldefini�lt bels� f�ggv�ny, hogy mi t�rt�njen ha megnyomj�k a gombot
		 * jelen eset�nkben sz�lunk a GameControllernek
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
				controll.ButtonPushd(milyen);
		}  
		
	}
}
