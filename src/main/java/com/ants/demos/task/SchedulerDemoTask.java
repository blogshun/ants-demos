package com.ants.demos.task;

import com.ants.common.annotation.service.Service;
import com.ants.common.annotation.service.Value;
import com.ants.common.bean.Log;
import com.ants.plugin.scheduler.FixedDelay;

/**
 * 任务调度 Demo
 * 可以注入Service
 *
 * @author MrShun
 * @version 1.0
 * @Date 2017/12/21
 */
@FixedDelay(delay = 3000)
@Service
public class SchedulerDemoTask implements Runnable {

    @Value("${ants.db.url}")
    private String url;

    @Override
    public void run() {
        Log.info("task demo -> {}", url);
    }
}
