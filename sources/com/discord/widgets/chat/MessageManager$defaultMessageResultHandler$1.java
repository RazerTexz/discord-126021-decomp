package com.discord.widgets.chat;

import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.messagesend.MessageResult$CaptchaRequired;
import com.discord.utilities.messagesend.MessageResult$Slowmode;
import com.discord.utilities.messagesend.MessageResult$UnknownFailure;
import com.discord.utilities.rest.SendUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MessageManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageManager$defaultMessageResultHandler$1 extends o implements Function1<MessageManager$MessageSendResult, Unit> {
    public final /* synthetic */ MessageManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageManager$defaultMessageResultHandler$1(MessageManager messageManager) {
        super(1);
        this.this$0 = messageManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageManager$MessageSendResult messageManager$MessageSendResult) {
        invoke2(messageManager$MessageSendResult);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageManager$MessageSendResult messageManager$MessageSendResult) {
        m.checkNotNullParameter(messageManager$MessageSendResult, "messageSendResult");
        MessageResult messageResult = messageManager$MessageSendResult.getMessageResult();
        if (messageResult instanceof MessageResult$CaptchaRequired) {
            SendUtils.INSTANCE.handleCaptchaRequired((MessageResult$CaptchaRequired) messageResult);
        } else if (messageResult instanceof MessageResult$UnknownFailure) {
            SendUtils.handleSendError$default(SendUtils.INSTANCE, ((MessageResult$UnknownFailure) messageResult).getError(), MessageManager.access$getContext$p(this.this$0), null, null, 12, null);
        } else if (messageResult instanceof MessageResult$Slowmode) {
            b.a.d.m.g(MessageManager.access$getContext$p(this.this$0), 2131887611, 0, null, 12);
        }
    }
}
