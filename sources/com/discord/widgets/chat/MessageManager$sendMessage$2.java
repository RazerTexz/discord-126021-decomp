package com.discord.widgets.chat;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MessageManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageManager$sendMessage$2 extends o implements Function1<MessageManager$MessageSendResult, Unit> {
    public final /* synthetic */ Function1 $messageSendResultHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageManager$sendMessage$2(Function1 function1) {
        super(1);
        this.$messageSendResultHandler = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageManager$MessageSendResult messageManager$MessageSendResult) {
        invoke2(messageManager$MessageSendResult);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageManager$MessageSendResult messageManager$MessageSendResult) {
        Function1 function1 = this.$messageSendResultHandler;
        m.checkNotNullExpressionValue(messageManager$MessageSendResult, "messageSendResult");
        function1.invoke(messageManager$MessageSendResult);
    }
}
