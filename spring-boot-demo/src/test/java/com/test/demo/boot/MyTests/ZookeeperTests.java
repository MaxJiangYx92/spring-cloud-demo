package com.test.demo.boot.MyTests;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ThreadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/10/9 18:46
 * @Update -
 * @Description
 */
public class ZookeeperTests {

    private static Logger _logger = LoggerFactory.getLogger(ZookeeperTests.class);

    static String CONNECT_ADDR = "127.0.0.1:2181";
    static String ZK_PATH = "/";
    //毫秒
    static final int SESSION_OUTTIME = 5000;
    static final ThreadFactory defaultThreadFactory = ThreadUtils.newThreadFactory("childWatcher");

    public static void main(String[] args) {
        //重试策略：初试时间为1s 重试10次
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
        CuratorFramework cf = CuratorFrameworkFactory.builder()
                .connectString(CONNECT_ADDR)
                .sessionTimeoutMs(SESSION_OUTTIME)
                .retryPolicy(retryPolicy)
                .build();
        cf.start();

        try {

            ExecutorService service = Executors.newFixedThreadPool(3);
            PathChildrenCache watcher2 = new PathChildrenCache(cf, ZK_PATH, true, false, service);
            watcher2.getListenable().addListener(new PathChildrenCacheListener() {
                @Override
                public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                    System.out.println(pathChildrenCacheEvent);
                }
            });
            watcher2.start();


            /**
             * TreeCache
             * */
//            TreeCache watcher = new TreeCache(cf, ZK_PATH);
//            watcher.getListenable().addListener(new TreeCacheListener() {
//                @Override
//                public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
//                    System.out.println(treeCacheEvent);
//                }
//            });
//
//            watcher.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
