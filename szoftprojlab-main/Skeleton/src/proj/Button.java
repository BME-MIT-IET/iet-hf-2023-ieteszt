import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 *	Kezeli az �sszes OutFramen megjelen� gombot
 * Egy konkr�t gombot reprezent�l
 */
public class Button extends JButton{
	/**
	 * Itt t�rolja el amit kap adatokat, hogy � mit reprezent�l
	 */
	private transient Object obj;
	private OutFrame frame;
	/**
	 * 	Ezt kapja meg az OutFrameb�l, ebb�l tudja, hogy lennyom�s eset�n minek kell megh�vnia
	 */
	private int mithiv;
	/**
	 * A GameController megjegyzi
	 */
	private transient GameController controller;
	/**
	 * lenyom�s funkci�j�t val�s�tja meg
	 */
	public void Push() {
		if(mithiv==0) {
			controller.steal((Virologist) obj);
			this.setText("Rablas");
		}
		if(mithiv==1) {
			controller.steal((Gear) obj);
			this.setText("Gear rablas");
		}
		if(mithiv==2) {
			controller.attack((Virologist) obj);
			this.setText("Attack");
		}
		if(mithiv==3) {
			controller.attack((Agens)obj);
			this.setText("Attack");
		}
		if(mithiv==4) {
			controller.dropitem((Gear)obj);
			this.setText("Dropitem");
		}
		if(mithiv==5) {
			controller.move((Field)obj);
			this.setText("Move");
		}
		if(mithiv==6) {
			controller.craft((Code) obj);
			this.setText("Craft");
		}
		frame.dispose();
		controller.lep();
	}
	/**
	 * konstruktor, amikor egy Virol�gust reprezent�l a gomb
	 * @param v amit reprezent�l
	 * @param mithiv hogy mit kell hivnia mikor megtamadjak
	 * @param controller a GameController oszt�ly hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public Button(Virologist v, int mithiv, GameController controller,OutFrame f) {
		this.controller = controller;
		obj = v;
		this.mithiv=mithiv;
		this.addActionListener(new Push());
		frame=f;
	}
	/**
	 * konstruktor, amikor egy Agenst reprezent�l a gomb
	 * @param a amit reprezent�l
	 * @param mithiv hogy mit kell hivnia mikor megtamadjak
	* @param controller a GameController oszt�ly hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public Button(Agens a, int mithiv, GameController controller,OutFrame f) {
		this.controller = controller;
		obj = a;
		this.mithiv=mithiv;
		this.addActionListener(new Push());
		frame=f;
		}
	/**
	 * konstruktor, amikor egy Code reprezent�l a gomb
	 * @param c amit reprezent�l
	 * @param mithiv hogy mit kell hivnia mikor megtamadjak
	 * @param controller a GameController oszt�ly hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public Button(Code c, int mithiv, GameController controller,OutFrame f) {
		this.controller = controller;
		obj = c;
		this.mithiv = mithiv;
		this.addActionListener(new Push());
		frame=f;
	}
	/**
	 * konstruktor, amikor egy Gear reprezent�l a gomb
	 * @param g amit reprezent�l
	 * @param mithiv hogy mit kell hivnia mikor megtamadjak
	  * @param controller a GameController oszt�ly hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public Button(Gear g, int mithiv, GameController controller,OutFrame f) {
		this.controller = controller;
		obj = g;
		this.mithiv = mithiv;
		this.addActionListener(new Push());
		frame=f;
	}
	/**
	 * konstruktor, amikor egy Field reprezent�l a gomb
	 * @param f amit reprezent�l
	 * @param mithiv hogy mit kell hivnia mikor megtamadjak
	* @param controller a GameController oszt�ly hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public Button(Field f, int mithiv, GameController controller,OutFrame ff) {
		this.controller = controller;
		obj = f;
		this.mithiv = mithiv;
		frame=ff;
		this.addActionListener(new Push());
	}
	/**
	 * Az implement�l oszt�ly, ami a lenyomast kezeli
	 *
	 */
	public class Push implements ActionListener{
		/**
		 * A gomblenyomast kezeli
		 * @param e milyen event tortent
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			Push();
		}
	}
}
