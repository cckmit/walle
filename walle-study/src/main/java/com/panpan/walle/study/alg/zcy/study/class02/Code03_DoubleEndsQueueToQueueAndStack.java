package com.panpan.walle.study.alg.zcy.study.class02;

import com.panpan.walle.study.alg.common.DNode;

public class Code03_DoubleEndsQueueToQueueAndStack {
    //模拟实现双向队列
    public static class DoubleEndsQueue<T>{
        private DNode<T> head;
        private DNode<T> tail;

        public void addFromHead(T value) {
            DNode<T> newNode = new DNode<>(value);
        }

        public void addFromBottom(T value){

        }

        public void removeFromHead(){

        }

        public void removeFromBottom(){

        }
    }
}