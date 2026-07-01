package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUser$observeMeId$1 extends o implements Function0<Long> {
    public final /* synthetic */ StoreUser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUser$observeMeId$1(StoreUser storeUser) {
        super(0);
        this.this$0 = storeUser;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return StoreUser.access$getMe$p(this.this$0).getId();
    }
}
