/** 
 * A jtk kezdett s vgt kezel osztly
*/
public class Game
{
	private Game() {
        // Privát konstruktor
    }
	/**
	 * Megkapja a gameControlert, hogy tudjunk neki sz�lni, hogy rajzolja ki
	 */
	public static GameController ga;
	/** 
	 *  Ellen�rzi, hogy megvan-e az adott virolgusnak a megfelel szm 
	 *  genetikai kdja, az adott virolgusnl lv genetikai kdok szmt 
	 *  kapja meg paramterknt
	 *  @param codeNumber hany darab code-dal rendelkezik a virolgus
	 */
	public static void EndGame(int codeNumber)
	{
		if(codeNumber==4)
		{
			ga.JatekVege();
		}
	}
}
