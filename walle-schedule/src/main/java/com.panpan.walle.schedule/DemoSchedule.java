package com.panpan.walle.schedule;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DemoSchedule {

    private Logger log = LoggerFactory.getLogger(getClass());
    /**
     * 1、注解任务
     */
    @XxlJob(value = "demoTask",init = "init", destroy = "destroy")
    public ReturnT<String> demoTask(String param) throws Exception {
        XxlJobLogger.log("XXL-JOB-ANNOTATION, myJobAnnotationHandler.");

        log.info("my first annotation job run, param: {}", param);

        return ReturnT.SUCCESS;
    }

    public void init(){
        log.info("my annotation job  init");
    }

    public void destroy(){
        log.info("my job annotation job destory");
    }
}
