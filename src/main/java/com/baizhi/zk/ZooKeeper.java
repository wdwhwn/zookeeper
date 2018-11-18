package com.baizhi.zk;

import org.I0Itec.zkclient.ZkClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wdwhwn on 2018/11/18.
 */
public class ZooKeeper {
    private ZkClient zkClient=null;
    @Before
    public void before(){
        zkClient=new ZkClient("192.168.85.154");
    }
    /*
    * 增删改查
    * */
    @Test
    public void zkCRUD(){
//        创建持久节点  true表示 当去节点不存在时自动创建
//        zkClient.createPersistent("/tencent",true);
//         创建临时节点
//        zkClient.createEphemeral("/zpark","bzjy");
//          更新节点内容
//        zkClient.writeData("/tencent","n5");
//          删除节点
        zkClient.delete("/tencent/node2");

    }
    @After
    public void after(){
        zkClient.close();
    }
}
