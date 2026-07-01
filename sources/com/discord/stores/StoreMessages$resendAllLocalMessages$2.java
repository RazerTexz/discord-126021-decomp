package com.discord.stores;

import com.discord.utilities.messagesend.MessageResult;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$resendAllLocalMessages$2 extends o implements Function1<MessageResult, Unit> {
    public static final StoreMessages$resendAllLocalMessages$2 INSTANCE = new StoreMessages$resendAllLocalMessages$2();

    public StoreMessages$resendAllLocalMessages$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult) {
        invoke2(messageResult);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageResult messageResult) {
    }
}
