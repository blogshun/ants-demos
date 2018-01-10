package cn.jants.demos.task;

import cn.jants.common.annotation.service.Service;
import cn.jants.common.annotation.service.Value;
import cn.jants.common.bean.Log;
import cn.jants.plugin.scheduler.FixedDelay;

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
