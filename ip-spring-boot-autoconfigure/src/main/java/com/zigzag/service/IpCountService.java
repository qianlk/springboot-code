package com.zigzag.service;

import com.zigzag.properties.IpProperties;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qlk
 */
public class IpCountService {

    private Map<String, Integer> ipCountMap = new HashMap<>();

    @Resource
    private IpProperties ipProperties;

    @Resource
    private HttpServletRequest httpServletRequest;

    public void count() {
        // 记录ip,增加访问次数
        String ipaddr = httpServletRequest.getRemoteAddr();
        System.out.println("------------" + ipaddr);
        Integer count = ipCountMap.get(ipaddr);
        if (count == null) {
            ipCountMap.put(ipaddr, 1);
        } else {
            ipCountMap.put(ipaddr, ipCountMap.get(ipaddr) + 1);
        }
    }

    @Scheduled(cron = "0/#{ipProperties.cycle} * * * * ?")
    public void print() {

        System.out.println("      ---ip访问控制---");
        if (ipProperties.getModel().equals(IpProperties.LogModel.DETAIL.getValue())) {
            System.out.println("+-----ip-addr-----+---num---+");
            for (Map.Entry<String, Integer> entry : ipCountMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.printf("|%15s  |%7d  |%n", key, value);
            }
        } else if (ipProperties.getModel().equals(IpProperties.LogModel.SIMPLE.getValue())) {
            System.out.println("+-----ip-addr-----+");
            for (String key : ipCountMap.keySet()) {
                System.out.printf("|%15s  |%n", key);
            }
        }
        System.out.println("+-----------------+");


        if (ipProperties.getCycleReset()) {
            ipCountMap.clear();
        }
    }

    public static void main(String[] args) {
        new IpCountService().print();
    }
}
