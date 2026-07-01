package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelCall;
import j0.k.b;
import java.util.HashMap;

/* JADX INFO: compiled from: StoreCalls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCalls$get$1<T, R> implements b<HashMap<Long, ModelCall>, ModelCall> {
    public final /* synthetic */ long $channelId;

    public StoreCalls$get$1(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ ModelCall call(HashMap<Long, ModelCall> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ModelCall call2(HashMap<Long, ModelCall> map) {
        return map.get(Long.valueOf(this.$channelId));
    }
}
