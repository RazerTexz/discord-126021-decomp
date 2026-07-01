package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserGuildSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserGuildSettings$handleGuildSettings$2 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ StoreUserGuildSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserGuildSettings$handleGuildSettings$2(StoreUserGuildSettings storeUserGuildSettings) {
        super(1);
        this.this$0 = storeUserGuildSettings;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        StoreUserGuildSettings.access$getDispatcher$p(this.this$0).schedule(new StoreUserGuildSettings$handleGuildSettings$2$1(this));
    }
}
