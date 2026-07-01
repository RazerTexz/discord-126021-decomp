package com.discord.stores;

import d0.t._Collections;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$channels$2 extends Lambda implements Function0<List<? extends Long>> {
    public final /* synthetic */ StoreStream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStream$channels$2(StoreStream storeStream) {
        super(0);
        this.this$0 = storeStream;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends Long> invoke() {
        return _Collections.toList(this.this$0.getLurking().getLurkingGuildIdsSync());
    }
}
