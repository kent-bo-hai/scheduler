package com.kent.scheduler.admin.web;

import com.kent.scheduler.admin.common.api.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kent on 2018/2/6.
 */
@Slf4j
@RestController
@RequestMapping(value = "/scheduled/api")
public class ScheduledApi {

    private static final int CALC_RUN_TIME_TIMES = 5;


    @RequestMapping("/calcRunTime")
    public ApiResult calcRunTimeByExpression(String expression) {

        List<String> runTimeList = new LinkedList<>();
        try {
            CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(expression);
            Date date = new Date();
            for (int i = 0; i < CALC_RUN_TIME_TIMES; i++) {
                date = cronSequenceGenerator.next(date);
                runTimeList.add(date.toString());
            }

            return ApiResult.succ(runTimeList);
        } catch (Exception e) {
            log.error("", e);
        }
        return ApiResult.fail("expression error.");

    }

    public static void main(String[] args) {
        log.info("afa");
    }
}
