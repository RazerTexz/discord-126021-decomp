package com.discord.widgets.chat.input;

import com.discord.widgets.chat.MessageManager;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$sendMessage$1$synchronousValidationSucceeded$1 extends Lambda implements Function1<MessageManager.MessageSendResult, Unit> {
    public final /* synthetic */ ChatInputViewModel$sendMessage$sendMessage$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendMessage$sendMessage$1$synchronousValidationSucceeded$1(ChatInputViewModel$sendMessage$sendMessage$1 chatInputViewModel$sendMessage$sendMessage$1) {
        super(1);
        this.this$0 = chatInputViewModel$sendMessage$sendMessage$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageManager.MessageSendResult messageSendResult) {
        invoke2(messageSendResult);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageManager.MessageSendResult messageSendResult) {
        Intrinsics3.checkNotNullParameter(messageSendResult, "messageSendResult");
        this.this$0.$messageSendResultHandler.invoke(messageSendResult.getMessageResult(), messageSendResult.getGuild());
    }
}
