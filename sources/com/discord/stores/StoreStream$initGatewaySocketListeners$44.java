package com.discord.stores;

import com.discord.api.user.TypingUser;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$44 extends k implements Function1<TypingUser, Unit> {
    public StoreStream$initGatewaySocketListeners$44(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleTypingStart", "handleTypingStart(Lcom/discord/api/user/TypingUser;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TypingUser typingUser) {
        invoke2(typingUser);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TypingUser typingUser) {
        m.checkNotNullParameter(typingUser, "p1");
        StoreStream.access$handleTypingStart((StoreStream) this.receiver, typingUser);
    }
}
