package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.t.u;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreMentions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMentions$observeTotalMentions$1<T, R> implements b<Map<Long, ? extends Integer>, Integer> {
    public static final StoreMentions$observeTotalMentions$1 INSTANCE = new StoreMentions$observeTotalMentions$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Integer call(Map<Long, ? extends Integer> map) {
        return call2((Map<Long, Integer>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(Map<Long, Integer> map) {
        return Integer.valueOf(u.sumOfInt(map.values()));
    }
}
