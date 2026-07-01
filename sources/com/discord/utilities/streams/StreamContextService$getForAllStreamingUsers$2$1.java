package com.discord.utilities.streams;

import androidx.core.app.NotificationCompat;
import d0.d0.f;
import d0.t.g0;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import rx.functions.FuncN;

/* JADX INFO: compiled from: StreamContextService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StreamContextService$getForAllStreamingUsers$2$1<R> implements FuncN<Map<Long, ? extends StreamContext>> {
    public static final StreamContextService$getForAllStreamingUsers$2$1 INSTANCE = new StreamContextService$getForAllStreamingUsers$2$1();

    @Override // rx.functions.FuncN
    public /* bridge */ /* synthetic */ Map<Long, ? extends StreamContext> call(Object[] objArr) {
        return call2(objArr);
    }

    @Override // rx.functions.FuncN
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends StreamContext> call2(Object[] objArr) {
        m.checkNotNullExpressionValue(objArr, "allUserStreamContexts");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (!(obj instanceof StreamContext)) {
                obj = null;
            }
            StreamContext streamContext = (StreamContext) obj;
            if (streamContext != null) {
                arrayList.add(streamContext);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj2 : arrayList) {
            linkedHashMap.put(Long.valueOf(((StreamContext) obj2).getUser().getId()), obj2);
        }
        return linkedHashMap;
    }
}
