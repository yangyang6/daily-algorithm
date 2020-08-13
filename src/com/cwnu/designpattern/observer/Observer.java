package com.cwnu.designpattern.observer;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 订阅者
 */
public interface Observer {
    void update(Subject subject);
}
