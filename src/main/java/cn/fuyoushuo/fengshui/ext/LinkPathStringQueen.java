package cn.fuyoushuo.fengshui.ext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by MALIANG on 2016/4/7.
 * 用于产生链接统计文件
 */
public class LinkPathStringQueen {

    public static final Logger logger = LogManager.getLogger(LinkPathStringQueen.class);

    private static final int MAX_QUEUE_SIZE = 10000;

    private LinkedList<String> queue = new LinkedList<String>();

    private Lock lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();

    private Condition notEmpty = lock.newCondition();

    private static LinkPathStringQueen myQueen = new LinkPathStringQueen();

    private LinkPathStringQueen() {}

    //获取自己的队列
    public static LinkPathStringQueen getMyQueen(){
        return myQueen;
    }

    public void put(String item){
        lock.lock();
        try{
            while(queue.size() == MAX_QUEUE_SIZE){
                logger.info("LinkPathStringQueen is full,please wait some minutes");
                notFull.await();
            }
            queue.addFirst(item);
            notEmpty.signal();

        }catch (Exception e){
            logger.info("LinkPathStringQueen has some error,msg={}",e);
        }finally {
            lock.unlock();
        }

    }

    public LinkedList<String> taskAll(){
        lock.lock();
        LinkedList<String> retVal = new LinkedList<String>();
        try{
            if(queue.size() == 0){
                logger.info("LinkPathStringQueen is empty,please wait some minutes");
                notEmpty.await(10,TimeUnit.SECONDS);
            }
            retVal.addAll(queue);
            //清空队列
            queue.clear();
            notFull.signal();
        }catch (Exception e){
            logger.info("LinkPathStringQueen has some error,msg={}",e);
        }finally {
            lock.unlock();
        }
        return retVal;
    }
}
