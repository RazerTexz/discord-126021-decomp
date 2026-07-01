package com.discord.stores;

import com.discord.utilities.messagesend.MessageResult;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$resendMessageWithCaptcha$1 extends o implements Function1<MessageResult, Unit> {
    public static final StoreMessages$resendMessageWithCaptcha$1 INSTANCE = new StoreMessages$resendMessageWithCaptcha$1();

    public StoreMessages$resendMessageWithCaptcha$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult) {
        invoke2(messageResult);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageResult messageResult) {
        m.checkNotNullParameter(messageResult, "it");
    }
}
