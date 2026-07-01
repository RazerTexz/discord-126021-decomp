package com.discord.utilities.streams;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelApplicationStream;
import j0.k.b;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: StreamContextService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StreamContextService$getForAllStreamingUsers$1<T, R> implements b<Map<Long, ? extends ModelApplicationStream>, Collection<? extends ModelApplicationStream>> {
    public static final StreamContextService$getForAllStreamingUsers$1 INSTANCE = new StreamContextService$getForAllStreamingUsers$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Collection<? extends ModelApplicationStream> call(Map<Long, ? extends ModelApplicationStream> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Collection<ModelApplicationStream> call2(Map<Long, ? extends ModelApplicationStream> map) {
        return map.values();
    }
}
