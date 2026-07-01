package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreRequestedStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreRequestedStageChannels$observeRequestedStageChannel$1<T, R> implements b<Map<Long, ? extends StoreRequestedStageChannels$StageInstanceState>, StoreRequestedStageChannels$StageInstanceState> {
    public final /* synthetic */ long $channelId;

    public StoreRequestedStageChannels$observeRequestedStageChannel$1(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ StoreRequestedStageChannels$StageInstanceState call(Map<Long, ? extends StoreRequestedStageChannels$StageInstanceState> map) {
        return call2((Map<Long, StoreRequestedStageChannels$StageInstanceState>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StoreRequestedStageChannels$StageInstanceState call2(Map<Long, StoreRequestedStageChannels$StageInstanceState> map) {
        return map.get(Long.valueOf(this.$channelId));
    }
}
