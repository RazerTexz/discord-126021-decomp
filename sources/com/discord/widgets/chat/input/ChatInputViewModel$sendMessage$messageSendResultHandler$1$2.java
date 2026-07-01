package com.discord.widgets.chat.input;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$messageSendResultHandler$1$2 extends o implements Function0<Unit> {
    public final /* synthetic */ ChatInputViewModel$sendMessage$messageSendResultHandler$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendMessage$messageSendResultHandler$1$2(ChatInputViewModel$sendMessage$messageSendResultHandler$1 chatInputViewModel$sendMessage$messageSendResultHandler$1) {
        super(0);
        this.this$0 = chatInputViewModel$sendMessage$messageSendResultHandler$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ChatInputViewModel.access$getEventSubject$p(this.this$0.this$0).k.onNext((T) ChatInputViewModel$Event$FailedDeliveryToRecipient.INSTANCE);
    }
}
