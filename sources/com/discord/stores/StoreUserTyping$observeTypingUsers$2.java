package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.t.n0;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: StoreUserTyping.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserTyping$observeTypingUsers$2<T, R> implements b<Map<Long, ? extends Set<? extends Long>>, Set<? extends Long>> {
    public final /* synthetic */ long $channelId;

    public StoreUserTyping$observeTypingUsers$2(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends Set<? extends Long>> map) {
        return call2((Map<Long, ? extends Set<Long>>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Set<Long> call2(Map<Long, ? extends Set<Long>> map) {
        m.checkNotNullExpressionValue(map, "typingUsersByChannel");
        Set<Long> setEmptySet = map.get(Long.valueOf(this.$channelId));
        if (setEmptySet == null) {
            setEmptySet = n0.emptySet();
        }
        return setEmptySet;
    }
}
