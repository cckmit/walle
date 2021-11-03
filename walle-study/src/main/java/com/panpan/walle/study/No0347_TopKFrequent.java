package com.panpan.walle.study;

import com.panpan.walle.study.tmpuse.conditiondemo.In;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 思路：map统计频率，加大根堆
 */
public class No0347_TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums){
            if (map.containsKey(n)){
                map.put(n, map.get(n)+1);
            } else {
                map.put(n, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer,Integer> entry: map.entrySet())
            heap.add(entry);

        int retSize = Math.min(k, heap.size());
        int[] res = new int[retSize];
        for (int i = 0; i < retSize; i++){
            res[i] = heap.poll().getKey();
        }

        return res;
    }
}
