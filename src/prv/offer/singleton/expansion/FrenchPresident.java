/**
 * 
 */
package prv.offer.singleton.expansion;


/**
 * @author HJH
 *
 * @date 2018年11月15日
 */
public class FrenchPresident extends President{

	private static class FrenchPresidentHolder {
		private static final FrenchPresident INSTANCE = new FrenchPresident();
	}

	public static final FrenchPresident getInstance() {
		return FrenchPresidentHolder.INSTANCE;
	}
	
}
