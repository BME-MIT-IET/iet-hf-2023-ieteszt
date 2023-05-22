import java.util.ArrayList;

/** 
 * A virol�gusnak a �rakt�ra�, 
 * ami mindig n�la van ebben t�rolja a felszerel�seit, 
 * anyagait �s �genseit. 
 */
public class Inventory
{
	/**
	 * Az inventoryhoz tartoz� �gensek list�ja
	 */
	private ArrayList<Agens> agens;
	/**
	 * Az inventoryhoz tartoz� anyagok list�ja
	 */
	private ArrayList<Material> mat;
	/**
	 * Azz inventoryhoz tartoz� felszerel�sek list�ja
	 */
	private ArrayList<Gear> gears;
	/** 
	 * A maxim�lis anyag mennyis�ge, amit a virol�gus t�rolni tud
	 */
	private int max_material;
	
	/** 
	 * A maxim�lis felszerel�s mennyis�ge amit a virol�gus t�rolni tud
	 */
	private int max_gear;
	/**
	 * Inventory konstruktora
	 * be�ll�tja, hogy mennyi lehet a maxim�lis felszerel�s �s maxim�lis anyag a virol�gusn�l 
	 * �s l�trehozza az �res list�kat.
	 */
	public Inventory() {
		agens =new ArrayList<Agens>();
		mat  = new ArrayList<Material>();
		gears = new ArrayList<Gear>();
		max_material= 16;
		max_gear=3;
	}
	/**
	 * visszaadja a materialokat
	 */
	public ArrayList<Material> getMaterial(){
		return mat;
	}
	/**
	 * mat m�ret�tt adja vissza
	 * Visszat�r, hogy mennyi anyagot tartalmaz az Inventory.
	 * @return mat m�rete
	 */
	public int MatSize() 
	{
		return mat.size();
	}
	/**
	 * max_material settere
	 * ezzel lehet be�ll�tani, hogy mennyi anyag lehet maxim�lisan az inventoryban. 
	 * @param i max_material m�rete
	 */
	public void setmax_material(int i)
	{
		max_material=i;
	}
	/**
	 * max_material gettere
	 * megmondja, hogy maximum mennyi  felszerel�s lehet az inventoryban.
	 * @return max_material v�ltoz�
	 */
	public int Getmax_Material() 
	{
		return max_material;
	}
	/**
	 * Gearsizie, gear darabsz�m�t adja meg
	 * Visszat�r, hogy az Inventory mennyi felszerel�st tartalmaz.
	 * @return gears.size() gears darabsz�ma
	 */
	public int Gearssize()
	{
		return gears.size();
	}
	/**
	 * max_gear getterer
	 * megmondja, hogy maximum mennyi  felszerel�s lehet az inventoryban.
	 * @return max_gear
	 */
	public int Getmax_Gear()
	{
		return max_gear;
	}
	/** 
	 * Az invenotry-hoz hozz� ad�dik egy �j felszerel�s.
	 * @param g Melyik felszerl�s adottik hozz� az inventoryhoz
	 */
	public void AddGear(Gear g)
	{
		gears.add(g);
	}
	
	/** 
	 * Felszerel�s elv�tele az inventory-b�l.
	 * @param g melyik felszerl�s legyen elv�tele az inventoryb�l
	 */
	public void RemoveGear(Gear g)
	{
		gears.remove(g);
	}
	/** 
	 * Anyag hozz�ad�sa az inventoryhoz
	 * @param m Melyik anyag ker�l az inventoryba*/
	public void AddMaterial(Material m)
	{
		mat.add(m);
	}
	
	/** 
	 * Egy �genst vesz el(t�r�l) az inventoryb�l
	 * @param a Melyik �genst t�rli az inventoryb�l*/
	public void RemoveAgens(Agens a)
	{
		agens.remove(a);
	}
	
	/** 
	 * Az �gens boml�s�t kezeli, sz�l, hogy cs�kkenteni kell az �gens 
	 * durationj�t
	 * @param v Melyik virol�gushoz tartozik az �gens
	 */
	public void DecreaseAgens(Virologist v)
	{
		for(int i=0; i<agens.size();i++)
			agens.get(i).Decrase(this);
	}
	
	/** 
	 * Az �gens craftol�sa, param�terk�nt megkapja a receptet, amib�l 
	 * craftolni kell
	 * @param c Melyik receptb�l kell craftolni
	 */
	public void Craft(Code c)
	{
		int amino=0;
		int nuc=0;
		for(int i=0;i<mat.size();i++) 
		{
			int a=mat.get(i).Accept(new MaterialVisitor());
			if(a==1)
				amino++;
			else if(a==2)
				nuc++;
		}
		if(amino>=c.getCost_to_make_A() && nuc>=c.getCost_to_make_N())
		{
			Agens a = c.getAgens();
			agens.add(a);
		} else return;
		int costA=c.getCost_to_make_A();
		int costN=c.getCost_to_make_N();
		int size= mat.size();
				for(int d=size-1;d>=0;d--) 
				{
					int b=mat.get(d).Accept(new MaterialVisitor());
					if(b==1 && costA!=0) {
						costA--;
						mat.remove(mat.get(d));
					}
					if(b==2 && costN!=0) {
						costN--;
						mat.remove(mat.get(d));
					}
				}
	}
	
	/** 
	 * �gens hozz�ad�sa az inventory-hoz
	 * @param a Melyik �gens legyen az inventoryhoz addva*/
	public void AddAgens(Agens a)
	{
		agens.add(a);
	}
	/**
	 * Visszat�r, az Agenseket tartalmaz� list�val
	 * @return agens a List�val t�r vissza ami a az agenseket tartalmaza
	 */
	public ArrayList<Agens> GetAgens()
	{
		return agens;
		
	}
	/**
	 * Visszat�r, az Gear tartalmaz� list�val
	 * @return gears a List�val t�r vissza ami a az Gear tartalmaza
	 */
	public ArrayList<Gear> GetGears()
	{
		return gears;
		
	}
}
