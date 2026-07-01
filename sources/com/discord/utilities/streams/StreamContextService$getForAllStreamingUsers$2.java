package com.discord.utilities.streams;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelApplicationStream;
import d0.t.h0;
import d0.t.o;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: StreamContextService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StreamContextService$getForAllStreamingUsers$2<T, R> implements b<Collection<? extends ModelApplicationStream>, Observable<? extends Map<Long, ? extends StreamContext>>> {
    public final /* synthetic */ StreamContextService this$0;

    public StreamContextService$getForAllStreamingUsers$2(StreamContextService streamContextService) {
        this.this$0 = streamContextService;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends StreamContext>> call(Collection<? extends ModelApplicationStream> collection) {
        return call2(collection);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, StreamContext>> call2(Collection<? extends ModelApplicationStream> collection) {
        if (collection.isEmpty()) {
            return new k(h0.emptyMap());
        }
        m.checkNotNullExpressionValue(collection, "allUserStreams");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(this.this$0.getForUser(((ModelApplicationStream) it.next()).getOwnerId(), false));
        }
        return Observable.b(arrayList, StreamContextService$getForAllStreamingUsers$2$1.INSTANCE);
    }
}
