package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserTyping.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserTyping$setUserTyping$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $messageSendCooldownSecs;
    public final /* synthetic */ StoreUserTyping$setUserTyping$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserTyping$setUserTyping$1$1(StoreUserTyping$setUserTyping$1 storeUserTyping$setUserTyping$1, long j) {
        super(0);
        this.this$0 = storeUserTyping$setUserTyping$1;
        this.$messageSendCooldownSecs = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStream.Companion.getSlowMode().onCooldown(this.this$0.$channelId, this.$messageSendCooldownSecs, StoreSlowMode$Type$MessageSend.INSTANCE);
    }
}
