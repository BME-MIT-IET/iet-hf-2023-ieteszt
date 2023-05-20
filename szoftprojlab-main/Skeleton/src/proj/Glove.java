

/** 
 * Egy felszerel�s, ami a �v�helyen tal�lhat�, amit ha felvesz a virol�gus, 
 * akkor a r� kent �genst k�pes lesz visszadobni arra, aki r� kente.
*/
public class Glove extends Gear
{
	
	/**
	 * A keszty�h�z tartoz� effektus
	 * l�trehozza a hozz� tartoz� effektust is
	 */
	private GloveEffect ge;
	/**
	 * Glove konstruktorra
	 */
	public Glove()
	{
		ge= new GloveEffect(this);
		id="glove";
	}
	/**
	 * ge gettere
	 * Visszat�r a keszty�h�z tartoz� effektussal.
	 * @return ge
	 */
	public GloveEffect getGe()
	{
		return ge;
	}
	/** 
	 * Adott gear felv�tel�t szolg�l� f�ggv�ny
	 * Mikor a virol�gus felveszi akkor megkapja a hozz� tartoz� effektust is.
	 * @param v Megkapja, hogy melyik virol�gus veszi fel
	 * */
	public void TakeGear(Virologist v)
	{
		v.getinventory().AddGear(this);
		v.AddEffect(ge);
	}
	
	/** 
	 * Adott gear lev�tel�re, megsemmis�t�s�re szolg�l� f�ggv�ny
	 *  Adott felszerel�s kiker�l a Virol�gus Inventoryb�l �s leker�l r�la a hozz� tartoz� effekt.
	 * @param v Megkapja, hogy melyik virol�gus vette le
	 * */
	public void TakeGearOff(Virologist v)
	{
		v.RemoveEffect(ge);
		v.getinventory().RemoveGear(this);
	}
	
	/**
	 * Adott gear ellop�s�t szolg�l� f�ggv�ny
	 * @param whoV melyik virol�gus lopott el
	 * @param fromV melyik virol�gust�l loptak el
	 *  */
	public void Steal(Virologist whoV, Virologist fromV)
	{
		this.TakeGearOff(fromV);
		fromV.RemoveEffect(ge);
		whoV.AddGearFromSteal(this);
		whoV.AddEffect(ge);
	}
}
