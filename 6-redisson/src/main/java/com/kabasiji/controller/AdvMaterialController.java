package com.kabasiji.controller;

import com.kabasiji.component.redis.DistributedLocker;
import org.redisson.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redisson")
public class AdvMaterialController {
	private final static Logger logger = LoggerFactory.getLogger(AdvMaterialController.class);

	@Autowired
	private DistributedLocker distributedLocker;
	
	@RequestMapping("/test")
	public void redissonTest() {
		String key = "redisson_key";
		for (int i = 0; i < 10; i++) {
		new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					logger.info("=============线程开启============" + Thread.currentThread().getName());
					/*distributedLocker.lock(key,10L); //直接加锁，获取不到锁则一直等待获取锁
					 Thread.sleep(100); //获得锁之后可以进行相应的处理
					 System.err.println("======获得锁后进行相应的操作======"+Thread.currentThread().getName());
					 distributedLocker.unlock(key);  //解锁
					 System.err.println("============================="+Thread.currentThread().getName());*/
					boolean isGetLock =  distributedLocker.tryLock(key, TimeUnit.SECONDS,1L,10L);
					////测试看门狗
					//Future future = distributedLocker.tryLockAsync(key+"1", 0,10);
					//boolean flag = (boolean) future.get();
					//if(flag) {
					//	isGetLock = true;
					//}
					//尝试获取锁，等待1秒，自己获得锁后一直不解锁则5秒后自动解锁
					if(isGetLock){
						 Thread.sleep(100); //获得锁之后可以进行相应的处理
						logger.info("======获得锁后进行相应的操作======" + Thread.currentThread().getName());
						//logger.info(Thread.currentThread().getName() + "我自己测试还能不能加锁<" + distributedLocker.tryLock(key, TimeUnit.SECONDS, 0L, 5L) + ">");
						logger.info("开始睡眠" + Thread.currentThread().getName());
						for (int j = 0; j < 20; j++) {
							Thread.sleep(1000); //获得锁之后可以进行相应的处理
							logger.info("睡眠" + Thread.currentThread().getName() + " >> j = " + j);
						}
						logger.info("======释放锁======" + Thread.currentThread().getName());
						distributedLocker.unlock(key);
						//distributedLocker.unlock(key+"1");
					} else {
						logger.info(Thread.currentThread().getName() + "未拿到锁不操作。。。。。");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	}

	@Autowired
	private RedissonClient redisson;


	@RequestMapping("/test2")
	public void redissonTest2() {




		//RAtomicDouble
//		RAtomicDouble atomicDouble = redisson.getAtomicDouble("myDouble");
//		atomicDouble.getAndDecrement();
//		atomicDouble.getAndIncrement();
//
//		atomicDouble.addAndGet(10.323);
//		atomicDouble.compareAndSet(29.4, 412.91);
//
//		atomicDouble.decrementAndGet();
//		atomicDouble.incrementAndGet();
//
//		atomicDouble.getAndAdd(302.00);
//		atomicDouble.getAndDecrement();
//		atomicDouble.getAndIncrement();
//
//		redisson.shutdown();


		RMap<String, Integer> map =  redisson.getMap("myMap");
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);

		boolean contains = map.containsKey("a");

		Integer value = map.get("c");
		Integer updatedValue = map.addAndGet("a", 32);

		Integer valueSize = map.valueSize("c");

		Set<String> keys = new HashSet<String>();
		keys.add("a");
		keys.add("b");
		keys.add("c");
		Map<String, Integer> mapSlice = map.getAll(keys);

		// use read* methods to fetch all objects
		Set<String> allKeys = map.readAllKeySet();
		Collection<Integer> allValues = map.readAllValues();
		Set<Map.Entry<String, Integer>> allEntries = map.readAllEntrySet();

		// use fast* methods when previous value is not required
		boolean isNewKey = map.fastPut("a", 100);
		boolean isNewKeyPut = map.fastPutIfAbsent("d", 33);
		long removedAmount = map.fastRemove("b");


        //RAtomicLong
		RAtomicLong atomicLong = redisson.getAtomicLong("myLong");
		atomicLong.getAndDecrement();
		atomicLong.getAndIncrement();

		atomicLong.addAndGet(10L);
		atomicLong.compareAndSet(29, 412);

//		atomicLong.decrementAndGet();
//		atomicLong.incrementAndGet();
//
//		atomicLong.getAndAdd(302);
//		atomicLong.getAndDecrement();
//		atomicLong.getAndIncrement();

//		redisson.shutdown();




		RBitSet bs = redisson.getBitSet("testbitset");
		bs.set(0, 5);
		bs.clear(0, 1);
		bs.length();

		bs.clear();
		bs.set(28);
		bs.get(28);

		bs.not();

		bs.cardinality();

		bs.set(3, true);
		bs.set(41, false);

		RBitSet bs1 = redisson.getBitSet("testbitset1");
		bs1.set(3, 5);

		RBitSet bs2 = redisson.getBitSet("testbitset2");
		bs2.set(4);
		bs2.set(10);
		bs1.and(bs2.getName());
		bs1.or(bs2.getName());
		bs1.xor(bs2.getName());

		redisson.shutdown();
	}

	/**
	 * 可续期的分布式锁
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	@RequestMapping("/test3")
	public void redissonTest3() throws ExecutionException, InterruptedException {
		String key = "test11";
		Future future = distributedLocker.tryLockAsync(key, 0,10);
		boolean flag = (boolean) future.get();
		if(flag) {
			System.out.println("获取到了锁");
			for (int i = 0; i < 15; i++) {
				Thread.sleep(1000);
				System.out.println(i);
			}
			distributedLocker.unlock(key);
		} else {
			System.out.println("没有获取到锁");
		}

	}
}
