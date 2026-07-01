package com.discord.utilities.streams;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: StreamContextService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StreamContextService$getForActiveStream$1<T, R> implements b<StoreApplicationStreaming$ActiveApplicationStream, Observable<? extends StreamContext>> {
    public final /* synthetic */ StreamContextService this$0;

    public StreamContextService$getForActiveStream$1(StreamContextService streamContextService) {
        this.this$0 = streamContextService;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends StreamContext> call(StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream) {
        return call2(storeApplicationStreaming$ActiveApplicationStream);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends StreamContext> call2(StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream) {
        if (storeApplicationStreaming$ActiveApplicationStream == null) {
            return new k(null);
        }
        return this.this$0.getForUser(storeApplicationStreaming$ActiveApplicationStream.getStream().getOwnerId(), false);
    }
}
