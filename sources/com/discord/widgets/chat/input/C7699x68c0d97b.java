package com.discord.widgets.chat.input;

import com.discord.widgets.chat.MessageManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.ChatInputViewModel$sendMessage$sendMessage$1$synchronousValidationSucceeded$1 */
/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7699x68c0d97b extends AbstractC12240o implements Function1<MessageManager.MessageSendResult, Unit> {
    public final /* synthetic */ ChatInputViewModel$sendMessage$sendMessage$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7699x68c0d97b(ChatInputViewModel$sendMessage$sendMessage$1 chatInputViewModel$sendMessage$sendMessage$1) {
        super(1);
        this.this$0 = chatInputViewModel$sendMessage$sendMessage$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageManager.MessageSendResult messageSendResult) {
        invoke2(messageSendResult);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageManager.MessageSendResult messageSendResult) {
        C12238m.checkNotNullParameter(messageSendResult, "messageSendResult");
        this.this$0.$messageSendResultHandler.invoke(messageSendResult.getMessageResult(), messageSendResult.getGuild());
    }
}
