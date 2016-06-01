package cn.fuyoushuo.fengshui.ext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by MALIANG on 2015/11/23.
 */
@Component
public class SpringPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

    public static final Logger logger = LogManager.getLogger(SpringPostProcessor.class);

    @Autowired
    InitStarData initStarData;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("spring context:{} init success", event.getApplicationContext().getDisplayName());
        if (event.getApplicationContext().getParent() == null) {
            logger.info("system init after spring root context inti");
            systemInit();
        }
    }

    /**
     *  系统初始化
     */
    private void systemInit(){
        initStarData.initCates();
        initStarData.initSite();
        initStarData.initIndexImgs();
        initStarData.initTodayTopics();
        logger.info("导入明星网站开始启动!");
    }
}
