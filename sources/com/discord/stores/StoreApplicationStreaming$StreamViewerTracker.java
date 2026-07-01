package com.discord.stores;

import d0.z.d.m;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: StoreApplicationStreaming.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreaming$StreamViewerTracker {
    private final Map<String, Integer> maxViewersByStream = new HashMap();

    public final void clear() {
        this.maxViewersByStream.clear();
    }

    public final Integer getMaxViewers(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        return this.maxViewersByStream.get(streamKey);
    }

    public final void onStreamUpdated(String streamKey, int viewerCount) {
        m.checkNotNullParameter(streamKey, "streamKey");
        Integer num = this.maxViewersByStream.get(streamKey);
        this.maxViewersByStream.put(streamKey, Integer.valueOf(Math.max(num != null ? num.intValue() : 0, viewerCount)));
    }

    public final void remove(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        this.maxViewersByStream.remove(streamKey);
    }
}
