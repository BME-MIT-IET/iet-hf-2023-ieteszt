import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class GameFrame extends JFrame {

	private int x;
	private int y;
	ArrayList<MyButton> gombok = new ArrayList<MyButton>();
	transient GameController controller;

	/**
	 * Letrehoz egy gamecontrollert
	 */
	public GameFrame(GameController contr) {
		SwingUtilities.updateComponentTreeUI(this);
		controller = contr;
		x = 0;
		y = 0;
		this.add(new PaintComp());
		this.setSize(1290, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		gombok.add(new MyButton());
		gombok.get(gombok.size() - 1).setVisible(true);
		gombok.get(gombok.size() - 1).init(0, contr);
		gombok.get(gombok.size() - 1).setBounds(10, 600, 150, 50);
		this.add(gombok.get(gombok.size() - 1));
		gombok.add(new MyButton());
		gombok.get(gombok.size() - 1).setVisible(true);
		gombok.get(gombok.size() - 1).init(1, contr);
		gombok.get(gombok.size() - 1).setBounds(170, 600, 150, 50);
		this.add(gombok.get(gombok.size() - 1));
		gombok.add(new MyButton());
		gombok.get(gombok.size() - 1).setVisible(true);
		gombok.get(gombok.size() - 1).setVisible(true);
		gombok.get(gombok.size() - 1).init(2, contr);
		gombok.get(gombok.size() - 1).setBounds(330, 600, 150, 50);
		this.add(gombok.get(gombok.size() - 1));
		gombok.add(new MyButton());
		gombok.get(gombok.size() - 1).setVisible(true);
		gombok.get(gombok.size() - 1).setVisible(true);
		gombok.get(gombok.size() - 1).init(3, contr);
		gombok.get(gombok.size() - 1).setBounds(490, 600, 150, 50);
		this.add(gombok.get(gombok.size() - 1));
		gombok.add(new MyButton());
		gombok.get(gombok.size() - 1).setVisible(true);
		gombok.get(gombok.size() - 1).setVisible(true);
		gombok.get(gombok.size() - 1).init(4, contr);
		gombok.get(gombok.size() - 1).setBounds(650, 600, 150, 50);
		this.add(gombok.get(gombok.size() - 1));
		gombok.add(new MyButton());
		gombok.get(gombok.size() - 1).setVisible(true);
		gombok.get(gombok.size() - 1).setVisible(true);
		gombok.get(gombok.size() - 1).init(6, contr);
		gombok.get(gombok.size() - 1).setBounds(810, 600, 150, 50);
		this.add(gombok.get(gombok.size() - 1));
		MyButton temp = new MyButton();
		temp.setVisible(false);
		this.add(temp);
	}

	/**
	 * Kirajzolja a virológusokat
	 * 
	 * @param f         meghatarozza a fieldet amire ki kell rajzolni a virologust
	 * @param onthemove meghatarozza, hogy a jelen virologus jon
	 */
	public void drawVirologinst(Field f, Virologist onthemove, Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		List<Virologist> vir = f.getVirologist();
		x = f.getX() + 150 - 40;
		y = f.getY() + 100 - 40;
		int kepX = 40;
		int kepY = 40;
		for (Virologist v : vir) {
			boolean maci = false;
			ArrayList<Effect> effects = v.getEffect();
			EffectVisitor visitor = new EffectVisitor();
			for (Effect e : effects) {
				if (e.Accept(visitor) == 7)
					maci = true;
			}
			if (maci) {
				Image image;
				image = Toolkit.getDefaultToolkit().getImage("./Pictures/Maci.png");
				g2d.drawImage(image, x, y, kepX, kepY, this);
			} else {
				if (v == onthemove) {
					Image image;
					image = Toolkit.getDefaultToolkit().getImage("./Pictures/Virologist_Main.png");

					g2d.drawImage(image, x, y, kepX, kepY, this);
				} else {
					Image image;
					image = Toolkit.getDefaultToolkit().getImage("./Pictures/Virologist.png");
					g2d.drawImage(image, x, y, kepX, kepY, this);
				}
			}
			x = x - kepX - 5;
		}
	}

	/**
	 * Kirajzolja az inventoryt
	 * 
	 * @param hanydb meghatarozza mennyi van a virologusnal az adott dologbol
	 * @param milyen meghatarozza milyen dolog van a virologusnal
	 */
	public void drawInventory(int hanydb, int milyen, Graphics g) {
		x = 1040;
		y = 30;
	
		if (milyen % 2 == 0) {
			x = 1140;
		} else {
			y += ((milyen - 1) / 2) * 100;
		}
	
		Map<Integer, String> imageMap = new HashMap<>();
		imageMap.put(1, "./Pictures/Glove");
		imageMap.put(2, "./Pictures/Backpack");
		imageMap.put(3, "./Pictures/Cape");
		imageMap.put(4, "./Pictures/Axe");
		imageMap.put(5, "./Pictures/MemoryLossV");
		imageMap.put(6, "./Pictures/VitusDanceV");
		imageMap.put(7, "./Pictures/StunV");
		imageMap.put(8, "./Pictures/Vaccine");
		imageMap.put(9, "./Pictures/AminoAcid");
		imageMap.put(10, "./Pictures/Nucleotid");
	
		String imgurl = imageMap.getOrDefault(milyen, "");
		imgurl += (hanydb == 0) ? "BW.png" : "I.png";
	
		Graphics2D g2d = (Graphics2D) g;
		Image image = Toolkit.getDefaultToolkit().getImage(imgurl);
		g2d.drawImage(image, x, y, 100, 100, this);
		g2d.drawString(String.valueOf(hanydb), x, y + 10);
	}

	/**
	 * Kirajzolja az effekteket
	 * 
	 * @param virologus aminek ki kell rajzolni az effectjeit
	 */
	public void drawEffects(ArrayList<Effect> effects, Graphics g) {
		y = 570;
		x = 1040;
	
		Map<Integer, String> effectStrings = new HashMap<>();
		effectStrings.put(1, "BackPackEffect");
		effectStrings.put(2, "GloveEffect");
		effectStrings.put(3, "CapeEffect");
		effectStrings.put(4, "VirusResistentEffect");
		effectStrings.put(5, "VitusDanceEffect");
		effectStrings.put(6, "ParalyzedEffect");
		effectStrings.put(7, "MaciEffect");
		effectStrings.put(8, "AxeEffect");
	
		for (Effect effect : effects) {
			y += 20;
			EffectVisitor visit = new EffectVisitor();
			int effectId = effect.Accept(visit);
			if (effectStrings.containsKey(effectId)) {
				g.drawString(effectStrings.get(effectId), x, y);
			}
		}
	}

	class PaintComp extends Component {
		@Override
		public void paint(Graphics g) {
			controller.setG(g);
			if (g != null)
				controller.RajzolMinden();
			this.repaint();
		}
	}

}
