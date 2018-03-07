package com.yxkj.yqcp.util;
import java.util.Properties;
//import com.jdd.fm.core.annotations.scn.*;
//import javax.servlet.ServletContext;

public class BaseContext {
//	public static ServletContext sc;
    /**
     * 定时任务
     */
    public static final String STATUS_RUNNING = "1";
    public static final String STATUS_NOT_RUNNING = "0";
    public static final String CONCURRENT_IS = "1";
    public static final String CONCURRENT_NOT = "0";
    public static final String SCHEDLERS_FALG="1";
    public static final String SCHEDLERS_KEY="scheduler.start";
    public static final String SCHEDULE_JOB_CONTEXT="scheduleJob";
    public final static String SCHEDULES="scheduler";
    public final static String MEMCACHE_CLIENT_MANGER="memcacheClientManager";
    public final static String SHARDED_JEDIS_POOL="shardedJedisPool";
    public final static String REDIS_MANAGER="redisManager";

    public static Properties configProperties;
    public static Properties messageProperties;

//	public static Map<String,ClassModel> actions=new HashMap<>();
}
