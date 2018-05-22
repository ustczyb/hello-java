package com.cloud.moon.alg;

import java.util.*;

/**
 * @author zhangyubo02
 * create time : 2018/3/5.
 */
public class ConsistentHash {

    private int nodesPerMachine = 5;

    /**
     * 所有的机器集合
     */
    private HashSet<String> machineSet;

    /**
     * 存储hash值和虚拟节点的对应关系
     */
    private SortedMap<Integer, String> hash_node_map;

    public ConsistentHash() {
        machineSet = new HashSet<>();
        hash_node_map = new TreeMap<>();
    }

    public ConsistentHash(int nodesPerMachine) {
        machineSet = new HashSet<>();
        hash_node_map = new TreeMap<>();
        this.nodesPerMachine = nodesPerMachine;
    }

    public static void main(String[] args) {
        ConsistentHash consistentHash = new ConsistentHash();
        consistentHash.addMachine("machine1");
        consistentHash.addMachine("machine2");
        consistentHash.addMachine("machine3");
        System.out.println(consistentHash.calculateMachine("input"));
        consistentHash.removeMachine("machine3");
        System.out.println(consistentHash.calculateMachine("input"));
    }

    /**
     * 添加新机器
     */
    public void addMachine(String machine) {
        machineSet.add(machine);
        System.out.println("添加新机器：" + machine);
        // 生成虚拟节点
        List<String> nodeList = generateNodeByMachine(machine);
        for (String node : nodeList) {
            hash_node_map.put(genHash(node), node);
            System.out.println("添加新节点" + node + "对应hash值为" + genHash(node));
        }
    }

    /**
     * 移除机器
     */
    public void removeMachine(String machine) {
        machineSet.remove(machine);
        System.out.println("移除机器：" + machine);
        List<String> nodeList = generateNodeByMachine(machine);
        for (String node : nodeList) {
            hash_node_map.remove(genHash(node));
        }
    }

    /**
     * 计算请求所属的机器
     *
     * @param input 请求
     * @return 机器
     */
    public String calculateMachine(String input) {
        int hash = genHash(input);
        String node;
        SortedMap<Integer, String> tailMap = hash_node_map.tailMap(hash);
        // 比虚拟节点hash值的最大值大，映射到最小hash值的虚拟节点上
        if (tailMap.isEmpty()) {
            node = hash_node_map.get(hash_node_map.firstKey());
        } else {
            node = hash_node_map.get(tailMap.firstKey());
        }
        System.out.println("请求所属虚拟节点为" + node);
        return calculateMachineByNode(node);
    }

    /**
     * 根据虚拟节点查找机器
     *
     * @param node 虚拟节点
     * @return 机器
     */
    private String calculateMachineByNode(String node) {
        return node.substring(0, node.indexOf('#'));
    }

    /**
     * 根据机器生成虚拟节点
     *
     * @param machine 机器
     * @return 虚拟节点集
     */
    private List<String> generateNodeByMachine(String machine) {
        List<String> nodeList = new ArrayList<>(nodesPerMachine);
        for (int i = 0; i < nodesPerMachine; i++) {
            String node = machine + "#" + i;
            nodeList.add(node);
        }
        return nodeList;
    }

    /**
     * hash函数 这段代码从网上copy而来
     *
     * @param str
     * @return
     */
    private int genHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

}
