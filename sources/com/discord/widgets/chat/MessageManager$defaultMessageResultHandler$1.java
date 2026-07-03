package com.discord.widgets.chat;

import com.discord.C5419R;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.rest.SendUtils;
import com.discord.widgets.chat.MessageManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0876m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MessageManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageManager$defaultMessageResultHandler$1 extends AbstractC12240o implements Function1<MessageManager.MessageSendResult, Unit> {
    public final /* synthetic */ MessageManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageManager$defaultMessageResultHandler$1(MessageManager messageManager) {
        super(1);
        this.this$0 = messageManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageManager.MessageSendResult messageSendResult) {
        invoke2(messageSendResult);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageManager.MessageSendResult messageSendResult) {
        C12238m.checkNotNullParameter(messageSendResult, "messageSendResult");
        MessageResult messageResult = messageSendResult.getMessageResult();
        if (messageResult instanceof MessageResult.CaptchaRequired) {
            SendUtils.INSTANCE.handleCaptchaRequired((MessageResult.CaptchaRequired) messageResult);
        } else if (messageResult instanceof MessageResult.UnknownFailure) {
            SendUtils.handleSendError$default(SendUtils.INSTANCE, ((MessageResult.UnknownFailure) messageResult).getError(), this.this$0.context, null, null, 12, null);
        } else if (messageResult instanceof MessageResult.Slowmode) {
            C0876m.m169g(this.this$0.context, C5419R.string.channel_slowmode_desc_short, 0, null, 12);
        }
    }
}
