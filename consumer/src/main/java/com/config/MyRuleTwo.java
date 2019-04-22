package com.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRuleTwo  extends AbstractLoadBalancerRule {

    private int count = 0;

    /**
     * 定义策略：1,2次请求9200、3,4,5次请求9201,以后都请求9202
     * @param key
     * @return
     */
    public Server choose(ILoadBalancer lb, Object key) {

        count ++;

        //TODO 因为我这里是自测,能够保证服务都是ok的，所以就使用getAllServers这个方法了
        List<Server> allServers = lb.getAllServers();
        if(count < 3){
            return chooseServerByPort(allServers, 9200);
        }
        if(count < 6){
            return chooseServerByPort(allServers, 9201);
        }
        return chooseServerByPort(allServers, 9202);
    }

    private Server chooseServerByPort(List<Server> servers,Integer port){
        for (Server server : servers) {
            if(server.getPort() == port){
                return server;
            }
        }
        return null;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub
    }

}
