package org.enodeframework.ons.message;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.google.common.collect.Lists;
import org.enodeframework.queue.IMessageHandler;

/**
 * @author anruence@gmail.com
 */
public class OnsMessageListener implements MessageListener {

    private final IMessageHandler messageHandler;

    public OnsMessageListener(IMessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        OnsTool.handle(Lists.newArrayList(message), messageHandler);
        return Action.CommitMessage;
    }
}