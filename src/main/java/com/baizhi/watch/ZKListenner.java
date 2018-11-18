package com.baizhi.watch;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.List;

/**
 * Created by wdwhwn on 2018/11/18.
 */
public class ZKListenner {
    public static void main(String[] args) throws LoginException, IOException {
        ZkClient zkClient= new ZkClient("192.168.85.154:2181");
//        订阅子节点改变
            zkClient.subscribeChildChanges("/tencent", new IZkChildListener() {
                @Override
                public void handleChildChange(String s, List<String> list) throws Exception {
                    System.out.println("parentPath:"+s);
                    for (String s1 : list) {
                        System.out.println("监视改变"+s1);
                        
                    }
                }
            });
            zkClient.subscribeDataChanges("/tencent", new IZkDataListener() {
//                订阅当前节点数据的改变
                @Override
                public void handleDataChange(String s, Object o) throws Exception {
                    System.out.println(s+" || "+o);
                }
//              订阅当前节点下数据的删除
                @Override
                public void handleDataDeleted(String s) throws Exception {
                    System.out.println("删除"+s);
                }
            });
        System.in.read();
    }
}
