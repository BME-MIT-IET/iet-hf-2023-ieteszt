# Manuális kódtesztelés
Code smellek: 

## AxeEffect.java, BackPackEffect.java: 
Add a nested comment explaining why this method is empty, throw an UnsupportedOperationException or complete the implementation.
javitas:

## Button.java: 
Make "obj" transient or serializable.
javitas:

## Code.java: 
Replace this use of System.out or System.err by a logger.
javítás: private static final Logger logger = Logger.getLogger(Code.class.getName());
         logger.info("\tgetAgens() Agens gettere lefutt");
       
## Field.java: 
Random rand = new Random(); : Save and re-use this "Random".
 public void setid(String nid): Rename method "setid" to prevent any misunderstanding/clash with method "setId".
 
## Game.java: 
Add a private constructor to hide the implicit public one.
 javítás: private Game() {
        // Privát konstruktor
    }

## GameController.java: 

Rename "x" which hides the field declared at line 14.
javítás int x=1040 => x=1040

Remove this useless assignment to local variable "o".
javítás: OutFrame o = new OutFrame(agens, 3, 0, this); => new OutFrame(agens, 3, 0, this);

Refactor this method to reduce its Cognitive Complexity from 28 to the 15 allowed. [+17 locations]
public void RajzolMinden() {
		Graphics2D g2d = (Graphics2D)g;
		Image image;
		image = Toolkit.getDefaultToolkit().getImage("./Pictures/City.jpg");
		g2d.drawImage(image, 0, 0,1000,550, jatekframe);
		for(Field f: mezok) {
			f.drawNeigbourLine(g, jatekframe);			
		}
		for(Field f: mezok) {
			f.drawField(g, jatekframe);
			f.drawIconOnField(g, jatekframe);
		}
		for(Field f: mezok) {
			if(jatekframe!=null)
				jatekframe.drawVirologinst(f, main,g);
		}
		Inventory i=main.getinventory();
		List<Gear> gears = i.GetGears();
		int glove =0;
		int backPack=0;
		int cape = 0;
		int axe=0;
		for(Gear g1: gears) {
			if(g1.getClass()==Glove.class)
				glove++;
			if(g1.getClass()==BackPack.class)
				backPack++;
			if(g1.getClass()==Cape.class)
				cape++;
			if(g1.getClass()==Axe.class)
				axe++;
		}
		jatekframe.drawInventory(glove, 1,g);//glove
		jatekframe.drawInventory(backPack, 2,g);//BackPack
		jatekframe.drawInventory(cape, 3,g);//Cape
		jatekframe.drawInventory(axe, 4,g);//Axe
		List<Agens> agens = i.GetAgens();
		int memoryLossV=0;
		int vitusDanceV=0;
		int stunV=0;
		int vaccine=0;
		for(Agens a: agens) {
			if(a.getClass()==MemoryLossV.class)
				memoryLossV++;
			if(a.getClass()==VitusDanceV.class)
				vitusDanceV++;
			if(a.getClass()==StunV.class)
				stunV++;
			if(a.getClass()==Vaccine.class)
				vaccine++;
		}
		jatekframe.drawInventory(memoryLossV, 5,g);//MemoryLossV
		jatekframe.drawInventory(vitusDanceV, 6,g);//VitusDanceV
		jatekframe.drawInventory(stunV, 7,g);//StunV
		jatekframe.drawInventory(vaccine, 8,g);//Vaccine
		List<Material> mat = i.getMaterial();
		MaterialVisitor visit= new MaterialVisitor();
		int aminoAcid=0;
		int nucleotid=0;
		for(Material m: mat) {
			if(m.Accept(visit)==1)
				aminoAcid++;
			if(m.Accept(visit)==2)
				nucleotid++;
		}
		jatekframe.drawInventory(aminoAcid, 9,g);//AminoAcid
		jatekframe.drawInventory(nucleotid, 10,g);//Nucleotid
	    ArrayList <Effect> effects = main.getEffect();
		jatekframe.drawEffects(effects,g);
	}
  
  javítás:

  public void RajzolMinden() {
    Graphics2D g2d = (Graphics2D) g;
    Image image = Toolkit.getDefaultToolkit().getImage("./Pictures/City.jpg");
    g2d.drawImage(image, 0, 0, 1000, 550, jatekframe);

    for (Field f : mezok) {
        f.drawNeigbourLine(g, jatekframe);
        f.drawField(g, jatekframe);
        f.drawIconOnField(g, jatekframe);
        if (jatekframe != null)
            jatekframe.drawVirologinst(f, main, g);
    }

    Inventory i = main.getinventory();
    List<Gear> gears = i.GetGears();
    Map<Class<? extends Gear>, Integer> gearCountMap = new HashMap<>();
    gearCountMap.put(Glove.class, 0);
    gearCountMap.put(BackPack.class, 0);
    gearCountMap.put(Cape.class, 0);
    gearCountMap.put(Axe.class, 0);

    for (Gear g1 : gears) {
        Class<? extends Gear> gearClass = g1.getClass();
        gearCountMap.put(gearClass, gearCountMap.getOrDefault(gearClass, 0) + 1);
    }

    for (int gearType = 1; gearType <= 4; gearType++) {
        int count = gearCountMap.getOrDefault(getGearClass(gearType), 0);
        jatekframe.drawInventory(count, gearType, g);
    }

    List<Agens> agens = i.GetAgens();
    Map<Class<? extends Agens>, Integer> agensCountMap = new HashMap<>();
    agensCountMap.put(MemoryLossV.class, 0);
    agensCountMap.put(VitusDanceV.class, 0);
    agensCountMap.put(StunV.class, 0);
    agensCountMap.put(Vaccine.class, 0);

    for (Agens a : agens) {
        Class<? extends Agens> agensClass = a.getClass();
        agensCountMap.put(agensClass, agensCountMap.getOrDefault(agensClass, 0) + 1);
    }

    for (int agensType = 5; agensType <= 8; agensType++) {
        int count = agensCountMap.getOrDefault(getAgensClass(agensType), 0);
        jatekframe.drawInventory(count, agensType, g);
    }

    List<Material> mat = i.getMaterial();
    MaterialVisitor visit = new MaterialVisitor();
    int aminoAcid = 0;
    int nucleotid = 0;

    for (Material m : mat) {
        int materialType = m.Accept(visit);
        if (materialType == 1)
            aminoAcid++;
        if (materialType == 2)
            nucleotid++;
    }

    jatekframe.drawInventory(aminoAcid, 9, g);//AminoAcid
    jatekframe.drawInventory(nucleotid, 10, g);//Nucleotid

    ArrayList<Effect> effects = main.getEffect();
    jatekframe.drawEffects(effects, g);
}

private Class<? extends Gear> getGearClass(int gearType) {
    switch (gearType) {
        case 1:
            return Glove.class;
        case 2:
            return BackPack.class;
        case 3:
            return Cape.class;
        case 4:
            return Axe.class;
        default:
            throw new IllegalArgumentException("Invalid gear type: " + gearType);
    }
}

private Class<? extends Agens> getAgensClass(int agensType) {
    switch (agensType) {
        case 5:
            return MemoryLossV.class;
        case 6:
            return VitusDanceV.class;
        case 7:
            return StunV.class;
        case 8:
            return Vaccine.class;
        default:
            throw new IllegalArgumentException("Invalid agens type: " + agensType);
    }
}

## GameFrame.java
  java: Refactor this method to reduce its Cognitive Complexity from 43 to the 15 allowed. 

	public void drawInventory(int hanydb, int milyen, Graphics g) {
		x = 1040;
		y = 30;
		if (milyen % 2 == 0) {
			x = 1140;
		}
		if (milyen % 2 != 0) {
			y = y + (milyen / 2) * 100;
		} else {
			y = y + ((milyen - 1) / 2) * 100;
		}

		Graphics2D g2d = (Graphics2D) g;
		String imgurl = "";
		if (milyen == 10) {
			if (hanydb == 0)
				imgurl = "./Pictures/NucleotidBW.png";
			else
				imgurl = "./Pictures/NucleotidI.png";
		}
		if (milyen == 1) {
			if (hanydb == 0)
				imgurl = "./Pictures/GloveBW.png";
			else
				imgurl = "./Pictures/GloveI.png";
		}
		if (milyen == 2) {
			if (hanydb == 0)
				imgurl = "./Pictures/BackpackBW.png";
			else
				imgurl = "./Pictures/BackpackI.png";
		}
		if (milyen == 3) {
			if (hanydb == 0)
				imgurl = "./Pictures/CapeBW.png";
			else
				imgurl = "./Pictures/CapeI.png";
		}
		if (milyen == 4) {
			if (hanydb == 0)
				imgurl = "./Pictures/AxeBW.png";
			else
				imgurl = "./Pictures/AxeI.png";
		}
		if (milyen == 5) {
			if (hanydb == 0)
				imgurl = "./Pictures/MemoryLossVBW.png";
			else
				imgurl = "./Pictures/MemoryLossVI.png";
		}
		if (milyen == 6) {
			if (hanydb == 0)
				imgurl = "./Pictures/VitusDanceVBW.png";
			else
				imgurl = "./Pictures/VitusDanceI.png";
		}
		if (milyen == 7) {
			if (hanydb == 0)
				imgurl = "./Pictures/StunVBW.png";
			else
				imgurl = "./Pictures/StunVI.png";
		}
		if (milyen == 8) {
			if (hanydb == 0)
				imgurl = "./Pictures/VaccineBW.png";
			else
				imgurl = "./Pictures/VaccineI.png";
		}
		if (milyen == 9) {
			if (hanydb == 0)
				imgurl = "./Pictures/AminoAcidBW.png";
			else
				imgurl = "./Pictures/AminoAcidI.png";
		}
		Image image;
		image = Toolkit.getDefaultToolkit().getImage(imgurl);
		g2d.drawImage(image, x, y, 100, 100, this);
		g2d.drawString(String.valueOf(hanydb), (x), (y + 10));
	}
  
  javítás:

	private static final Map<Integer, String> IMAGE_MAP = Map.of(
			1, "./Pictures/Glove",
			2, "./Pictures/Backpack",
			3, "./Pictures/Cape",
			4, "./Pictures/Axe",
			5, "./Pictures/MemoryLossV",
			6, "./Pictures/VitusDanceV",
			7, "./Pictures/StunV",
			8, "./Pictures/Vaccine",
			9, "./Pictures/AminoAcid",
			10, "./Pictures/Nucleotid");

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

		String imgurl = IMAGE_MAP.getOrDefault(milyen, "");
		imgurl += (hanydb == 0) ? "BW.png" : "I.png";

		Graphics2D g2d = (Graphics2D) g;
		Image image = Toolkit.getDefaultToolkit().getImage(imgurl);
		g2d.drawImage(image, x, y, 100, 100, this);
		g2d.drawString(String.valueOf(hanydb), x, y + 10);
	}
  
  Refactor this method to reduce its Cognitive Complexity from 17 to the 15 allowed. [+9 locations]
  
  	public void drawEffects(ArrayList<Effect> effects, Graphics g) {
		y = 570;
		x = 1040;
		for (int i = 0; i < effects.size(); i++) {

			y = y + 20;
			EffectVisitor visit = new EffectVisitor();
			if (effects.get(i).Accept(visit) == 1) {
				g.drawString("BackPackEffect", x, y);
			}
			if (effects.get(i).Accept(visit) == 2) {
				g.drawString("GloveEffect", x, y);
			}
			if (effects.get(i).Accept(visit) == 3) {
				g.drawString("CapeEffect", x, y);
			}
			if (effects.get(i).Accept(visit) == 4) {
				g.drawString("VirusResistentEffect", x, y);
			}
			if (effects.get(i).Accept(visit) == 5) {
				g.drawString("VitusDanceEffect", x, y);
			}
			if (effects.get(i).Accept(visit) == 6) {
				g.drawString("ParalyzedEffect", x, y);
			}
			if (effects.get(i).Accept(visit) == 7) {
				g.drawString("MaciEffect", x, y);
			}
			if (effects.get(i).Accept(visit) == 8) {
				g.drawString("AxeEffect", x, y);

			}
		}

	}

  javítás:
  
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

## Main.java: 
Remove this object instantiation and use "Laboratory.class" instead.
fields.get(i).getClass() == new Laboratory.getClass() => fields.get(i) instanceof Laboratory

Remove this object instantiation and use "StunV.class" instead.

if (virologists.get(i).getinventory().GetAgens().get(j).getClass().equals(new StunV().getClass())) {
	statsall += ("StunV]");
}

javítás: 

if (virologists.get(i).getinventory().GetAgens().get(j) instanceof StunV) {
	statsall += ("StunV]");
}
## Refuge.java
gear.getClass()==new BackPack().getClass()
Remove this object instantiation and use "Glove.class" instead.
javítás: gear instanceof BackPack

## WinFrame.java
	ok.addActionListener( new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);	
		}	
	});
Make this anonymous inner class a lambda (sonar.java.source not set. Assuming 8 or greater.)
javítás: 
	ok.addActionListener(e -> System.exit(0));
