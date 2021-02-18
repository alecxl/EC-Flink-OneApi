package top.bestcx.logger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: 曹旭
 * @date: 2020/12/2 11:30 上午
 * @description:
 */
@RestController
@Slf4j
public class LoggerController {


    @PostMapping("/applog")
    public String loggerDel(@RequestBody String strLogger) {
        setLogToKafka(strLogger);
        return "ok";
    }


    @Autowired
    private KafkaTemplate kafkaTemplate;

    private void setLogToKafka(String strLogger) {
        JSONObject obj = JSON.parseObject(strLogger);
        //   启动日志和事件日志进入到不同的   topic
        if (obj.getString("start") != null && obj.getString("start").length() > 0) {
            kafkaTemplate.send("gmall_startup_topic", strLogger);
        } else {
            kafkaTemplate.send("gmall_event_topic", strLogger);
        }
    }

}
