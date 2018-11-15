/**
 * 
 */
package prv.offer.singleton.expansion;


/**
 * @author HJH
 *
 * @date 2018年11月15日
 */
public class AmericanPresident extends President {

	private static class AmericanPresidentHolder {
		private static final AmericanPresident INSTANCE = new AmericanPresident();
	}

	public static final AmericanPresident getInstance() {
		return AmericanPresidentHolder.INSTANCE;
	}
	
}
