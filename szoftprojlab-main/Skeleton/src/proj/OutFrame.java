import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 	Kezeli a k�perny�n l�v� gombokat, �s hogy azok lenyom�s�n�l mi fog t�rt�nni
 *
 */
public class OutFrame extends JFrame {
	/**
	 *  Ezt adjuk, majd �t a hozz� tartoz� gomboknak ezt t�rolja, hogy milyen f�ggv�nyt kell a gomb lenyom�s eset�n megh�vni
	 */
	int mithiv;
	ArrayList<Button> gombok = new ArrayList<Button>();
	//Konstruktoroknak az�rt van 3 param�terre, mert k�l�nben azonosak lenn�nek hi�aba k�l�nb�z�k a list�k
	/**
	 * konstruktor, amikor a felhaszn�l� Virologusok k�z�l tud v�lasztani
	 * @param vir megkapja hogy melyik virologusok kozul kell valasztani
	 * @param mithiv megkapja, hogy milyen tevekenyseghez kell ez a valasztas
	 * @param controller a GameController oszt�ly hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public OutFrame(List<Virologist> vir, int mithiv, GameController controller) {
		this.setSize(450, 470);
		JPanel panel = new JPanel();
		int c=0;
		for(Virologist v: vir) {
			c++;
			Button b= new Button(v,mithiv, controller,this);
			b.setVisible(true);
			b.setText("Virologus"+c);
			this.setSize(600,600);
	        this.setLocationRelativeTo(null);  
	        this.setVisible(true);  
			b.setBounds(200,c*100,150,50);
			gombok.add(b);
			panel.add(b);
		}
		this.add(panel);
		this.setVisible(true);
	}
	/**
	 * konstruktor, amikor a felhaszn�l� Gearek k�z�l tud v�lasztani
	 * @param gears megkapja milyen felszerel�sek k�z�l kell v�lasztani
	 * @param mithiv megkapja, hogy milyen tevekenyseghez kell ez a valasztas
	 * @param i csak az�rt van, hogy ne legyen gond az azonos konstruktorrokkal
	 * @param controller a GameController oszt�ly hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public OutFrame(List<Gear> gears, int mithiv, int i, GameController controller) {
		this.setSize(450, 470);
		JPanel panel = new JPanel();
		int c=0;
		for(Gear g: gears) {
			c++;
			Button b= new Button(g,mithiv, controller,this);
			b.setVisible(true);
			b.setText("Gear"+c);
			this.setSize(600,600);
	        this.setLocationRelativeTo(null);  
	        this.setVisible(true);  
			b.setBounds(200,c*100,150,50);
			gombok.add(b);
			panel.add(b);
		}
		this.add(panel);
		this.setVisible(true);
		//TODO grafika
	}
	/**
	 * konstruktor, amikor a felhaszn�l� Agens k�z�l tud v�lasztani
	 * @param agens megkapja milyen �gensek k�z�l kell v�lasztani
	 * @param mithiv megkapja, hogy milyen tevekenyseghez kell ez a valasztas
	 * @param i csak az�rt van, hogy ne legyen gond az azonos konstruktorrokkal
	 * @param controller a GameController oszt�ly hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public OutFrame(List<Agens> agens, int mithiv, double i, GameController controller) {
		this.setSize(450, 470);
		JPanel panel = new JPanel();
		int c=0;
		for(Agens a: agens) {
			c++;
			Button b= new Button(a,mithiv, controller,this);
			b.setVisible(true);
			b.setText("Agens"+c);
			this.setSize(600,600);
	        this.setLocationRelativeTo(null);  
	        this.setVisible(true);  
			b.setBounds(200,c*100,150,50);
			gombok.add(b);
			panel.add(b);
		}
		this.add(panel);
		this.setVisible(true);
	}
	/**
	 * konstruktor, amikor a felhaszn�l� Field k�z�l tud v�lasztani
	 * @param fields megkapja milyen mez�k k�z�l kell v�lasztani
	 * @param mithiv megkapja, hogy milyen tevekenyseghez kell ez a valasztas
	 * @param i csak az�rt van, hogy ne legyen gond az azonos konstruktorrokkal
	 * @param controller a GameController oszt�ly hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public OutFrame(List<Field> fields, int mithiv, float i, GameController controller) {
		this.setSize(450, 470);
		JPanel panel = new JPanel();
		int c=0;
		for(Field f:fields) {
			c++;
			Button b= new Button(f,mithiv, controller,this);
			this.setSize(1240,720);
	        this.setLocationRelativeTo(null);   
	        this.setVisible(true); 
			b.setVisible(true);
			b.setText(f.getid());
	        b.setBounds(200,c*100,150,50);
			gombok.add(b);
			panel.add(b);
		}
		this.add(panel);
		this.setVisible(true);
	}
	/**
	 * konstruktor, amikor a felhaszn�l� Code k�z�l tud v�lasztani
	 * @param codes megkapja milyen k�dok k�z�l kell v�lasztani
	 * @param mithiv megkapja, hogy milyen tevekenyseghez kell ez a valasztas
	 * @param i csak az�rt van, hogy ne legyen gond az azonos konstruktorrokkal
	 * @param controller a GameController oszt�ly hogy tudja a gomb, minek kell jelezni ha megnyomtak
	 */
	public OutFrame(List<Code> codes, int mithiv, char i, GameController controller) {
		this.setSize(450, 470);
		JPanel panel = new JPanel();
		int cc=0;
		for(Code c: codes) {
			cc++;
			Button b= new Button(c,mithiv, controller,this);
			b.setVisible(true);
			b.setText("Code"+c);
			this.setSize(600,600);
	        this.setLocationRelativeTo(null);  
	        this.setVisible(true);  
			b.setBounds(200,cc*100,150,50);
			gombok.add(b);
			panel.add(b);
		}
		this.add(panel);
		this.setVisible(true);
	}
}
