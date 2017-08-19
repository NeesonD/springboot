package com.neeson.Filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;

/**
 * Created by daile on 2017/8/19.
 */
@Slf4j
public class HeartBeatFilter implements KeepAliveMessageFactory {

    private static final String HEART_BEAT = "HB";

    @Override
    public boolean isRequest(IoSession session, Object message) {
        try {
            String heartBeat = message.toString();
            if (heartBeat.equals(HEART_BEAT)){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public boolean isResponse(IoSession session, Object message) {
        return false;
    }

    @Override
    public Object getRequest(IoSession session) {
        return null;
    }

    @Override
    public Object getResponse(IoSession session, Object request) {
        return request;
    }
}
