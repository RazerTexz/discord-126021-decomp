package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.media.MediaFrecencyTracker;
import d0.t.o;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: StoreStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStickers$observeFrequentlyUsedStickerIds$1<T, R> implements b<MediaFrecencyTracker, List<? extends Long>> {
    public static final StoreStickers$observeFrequentlyUsedStickerIds$1 INSTANCE = new StoreStickers$observeFrequentlyUsedStickerIds$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends Long> call(MediaFrecencyTracker mediaFrecencyTracker) {
        return call2(mediaFrecencyTracker);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Long> call2(MediaFrecencyTracker mediaFrecencyTracker) {
        Collection sortedKeys$default = FrecencyTracker.getSortedKeys$default(mediaFrecencyTracker, 0L, 1, null);
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(sortedKeys$default, 10));
        Iterator<T> it = sortedKeys$default.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(Long.parseLong((String) it.next())));
        }
        return arrayList;
    }
}
