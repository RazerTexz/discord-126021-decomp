package com.discord.stores;

import d0.z.d.Lambda;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$channels$1 extends Lambda implements Function1<Long, Observable<Map<Long, ? extends Long>>> {
    public final /* synthetic */ StoreStream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStream$channels$1(StoreStream storeStream) {
        super(1);
        this.this$0 = storeStream;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Observable<Map<Long, ? extends Long>> invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Observable<Map<Long, Long>> invoke(long j) {
        return this.this$0.getPermissions().observeChannelPermissionsForGuild(j);
    }
}
