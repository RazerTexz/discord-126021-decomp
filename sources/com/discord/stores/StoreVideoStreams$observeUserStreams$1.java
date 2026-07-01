package com.discord.stores;

import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreVideoStreams.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVideoStreams$observeUserStreams$1 extends o implements Function0<Map<Long, ? extends StoreVideoStreams$UserStreams>> {
    public final /* synthetic */ StoreVideoStreams this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreVideoStreams$observeUserStreams$1(StoreVideoStreams storeVideoStreams) {
        super(0);
        this.this$0 = storeVideoStreams;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends StoreVideoStreams$UserStreams> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends StoreVideoStreams$UserStreams> invoke2() {
        return StoreVideoStreams.access$getUserStreamsByUserSnapshot$p(this.this$0);
    }
}
