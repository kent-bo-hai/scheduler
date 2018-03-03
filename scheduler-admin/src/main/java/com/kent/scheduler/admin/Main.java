package com.kent.scheduler.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.support.CronSequenceGenerator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kent on 2018/2/6.
 */
@Slf4j
public class Main {

    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator("0 */12 * * * *");
        Date date = new Date();
        for (int i = 0; i < 7; i++) {
            date = cronSequenceGenerator.next(date);
            System.out.println(dateFormat.format(date));
        }

    }
}
