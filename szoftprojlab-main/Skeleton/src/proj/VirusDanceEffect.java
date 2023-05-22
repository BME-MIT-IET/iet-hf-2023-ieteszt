/** 
 * Ez hat�s, amit a v�rologus, kap ha bizonyos �genssel kenik meg,
 *  ekkor bizonyos k�rig ha m�s keni meg �genssel nem kapja meg az adott �gens hat�s�t. 
 * (Kiv�ve: ha keszty�vel dobj�k r� vissza).
 */
public class VirusDanceEffect extends Effect
{
	/** 
	 * Ez a f�ggv�ny teszi lehet�v�, hogy az oszt�ly fogadni tudjon IVisitort.
	 * @param v Megkapja, hogy melyik IVisitor l�togatja meg
	 * @return Visszat�r, hogy sikeres volt-e a l�togat�s
	 */
	@Override
	public int Accept(IVisitor v)
	{
		int x=v.Visit(this);
		return x;
	}
	/**
	 * Az oszt�ly konstruktora
	 */
	public VirusDanceEffect() {
		id="virusDanceEffect";
	}
	/** 
	 *  Az effect leboml�s�t kezeli
	 *  �s random szomsz�dos mez�re mozgatja a virol�gust
	 *  @param v Megkapja, hogy melyik virol�gushoz tartozik az effect
	 */
	@Override
	public void Decrease(Virologist v)
	{
		duration=duration-1;
		if(duration<=0)
			v.RemoveEffect(this);
		v.MoveRandom();
	}
}
