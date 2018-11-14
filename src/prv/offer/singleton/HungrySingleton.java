package prv.offer.singleton;

/**
 * 饱汉单例模式
 * 线程安全，但无延迟加载
 * @author HJH
 *
 * @date 2018年11月14日
 */
public class HungrySingleton {

	/*
	 * 它基于 classloder 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，
	 * 虽然导致类装载的原因有很多种，在单例模式中大多数都是调用 getInstance 方法，
	 * 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化 instance 显然没有达到 lazy loading 的效果。
	 */
	private static HungrySingleton singleton = new HungrySingleton();
	
	private HungrySingleton() {}
	
	public static HungrySingleton getSingleton() {
		return singleton;
	}
	
}
