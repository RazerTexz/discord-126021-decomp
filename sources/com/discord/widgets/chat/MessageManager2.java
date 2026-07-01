package com.discord.widgets.chat;

import b.a.d.AppToast;
import com.discord.R;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.rest.SendUtils;
import com.discord.widgets.chat.MessageManager;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.MessageManager$defaultMessageResultHandler$1, reason: use source file name */
/* JADX INFO: compiled from: MessageManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageManager2 extends Lambda implements Function1<MessageManager.MessageSendResult, Unit> {
    public final /* synthetic */ MessageManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageManager2(MessageManager messageManager) {
        super(1);
        this.this$0 = messageManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageManager.MessageSendResult messageSendResult) {
        invoke2(messageSendResult);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageManager.MessageSendResult messageSendResult) {
        Intrinsics3.checkNotNullParameter(messageSendResult, "messageSendResult");
        MessageQueue4 messageResult = messageSendResult.getMessageResult();
        if (messageResult instanceof MessageQueue4.CaptchaRequired) {
            SendUtils.INSTANCE.handleCaptchaRequired((MessageQueue4.CaptchaRequired) messageResult);
        } else if (messageResult instanceof MessageQueue4.UnknownFailure) {
            SendUtils.handleSendError$default(SendUtils.INSTANCE, ((MessageQueue4.UnknownFailure) messageResult).getError(), this.this$0.context, null, null, 12, null);
        } else if (messageResult instanceof MessageQueue4.Slowmode) {
            AppToast.g(this.this$0.context, R.string.channel_slowmode_desc_short, 0, null, 12);
        }
    }
}
