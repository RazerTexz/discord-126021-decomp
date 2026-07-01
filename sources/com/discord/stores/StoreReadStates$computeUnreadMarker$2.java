package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReadStates$computeUnreadMarker$2 extends o implements Function1<Long, Boolean> {
    public static final StoreReadStates$computeUnreadMarker$2 INSTANCE = new StoreReadStates$computeUnreadMarker$2();

    public StoreReadStates$computeUnreadMarker$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
        return Boolean.valueOf(invoke(l.longValue()));
    }

    public final boolean invoke(long j) {
        return j <= 0;
    }
}
