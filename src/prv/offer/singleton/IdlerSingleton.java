package prv.offer.singleton;

/**
 * 懒汉单例模式
 * @author HJH
 *
 * @date 2018年11月14日
 */
public class IdlerSingleton {

	// 懒汉式
//	private static IdlerSingleton singleton;

	private IdlerSingleton() {
		
	}
	
	/*
	 * 这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
	 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
	 */
//	public static IdlerSingleton getSingleton() {
//		if (singletonObject == null) {
//			singleton = new IdlerSingleton();
//		}
//		return singleton;
//	}
	
	// 懒汉安全写法-----双检锁/双重校验锁
	
	/*
	 * 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。getInstance() 的性能对应用程序很关键。
	 */
//	private static volatile IdlerSingleton singleton;
//	
//	public static IdlerSingleton getSafeSingleton() {
//		if (singleton == null) {
//			synchronized (IdlerSingleton.class) {
//				if (singleton == null) {
//					singleton = new IdlerSingleton();
//				}
//			}
//		}
//		return singleton;
//	}
	
	// 静态内部类写法
	/*
	 * 这种方式利用了 classloder 机制来保证初始化 instance 时只有一个线程
	 * SingletonHolder 类没有被主动使用，只有显示通过调用 getInstance 方法时，才会显示装载 SingletonHolder 类，从而实例化 instance。
	 * 想象一下，如果实例化 instance 很消耗资源，所以想让它延迟加载，另外一方面，又不希望在 Singleton 类加载时就实例化，因为不能确保 Singleton 类还可能在其他的地方被主动使用从而被加载，那么这个时候实例化 instance 显然是不合适的。
	 */
	private static class IdlerSingletonHolder {
		private static final IdlerSingleton INSTANCE = new IdlerSingleton();
	}
	
	public static final IdlerSingleton getSingleton() {
		return IdlerSingletonHolder.INSTANCE;
	}
	
}	
