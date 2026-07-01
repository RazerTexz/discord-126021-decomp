package com.discord.stores;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreClientVersion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreClientVersion$init$2 extends k implements Function1<Integer, Unit> {
    public StoreClientVersion$init$2(StoreClientVersion storeClientVersion) {
        super(1, storeClientVersion, StoreClientVersion.class, "setClientMinVersion", "setClientMinVersion(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        StoreClientVersion.access$setClientMinVersion((StoreClientVersion) this.receiver, i);
    }
}
