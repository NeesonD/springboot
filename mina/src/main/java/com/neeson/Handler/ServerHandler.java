package com.neeson.Handler;

import com.neeson.Session.SessionCache;
import lombok.extern.slf4j.Slf4j;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by daile on 2017/6/28.
 */
@Slf4j
public class ServerHandler extends IoHandlerAdapter {


    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        log.error(session.getRemoteAddress().toString() + " : " + cause.toString());
        session.closeNow();
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        log.info("连接创建 : " + session.getRemoteAddress().toString());
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        log.info("连接打开：" + session.getRemoteAddress().toString());
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {

        String text = message.toString();
        log.info("接收消息内容 : " + text);
        SessionCache.getInstance().save("", session);
        String result = "server";
        session.write(result);

    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        log.info("发送消息内容 : " + message.toString());
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        log.info(MessageFormat.format("连接Idle [{0}] from {1} ", status, session.getRemoteAddress()));
        if (status == IdleStatus.READER_IDLE) {
            log.info("进入读空闲状态");
            session.closeNow();
        } else if (status == IdleStatus.BOTH_IDLE) {
            log.info("BOTH空闲");
            session.closeNow();
        }
    }


    @Override
    public void sessionClosed(IoSession session) throws Exception {
        log.info("连接关闭 : " + session.getRemoteAddress().toString());
        int size = session.getService().getManagedSessions().values().size();
        log.info("连接关闭时session数量==》" + size);
        List<String> sessions = (List<String>) session.getAttribute("mac");
        if (sessions != null) {
            for (String key : sessions) {
                SessionCache.getInstance().remove(key, session);
            }
        }
    }

}
