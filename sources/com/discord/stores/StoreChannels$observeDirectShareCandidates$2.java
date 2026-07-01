package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.utilities.frecency.FrecencyTracker;
import d0.t.u;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: StoreChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannels$observeDirectShareCandidates$2<T, R> implements b<Map<Long, ? extends Channel>, List<? extends Channel>> {
    public final /* synthetic */ Context $context;

    public StoreChannels$observeDirectShareCandidates$2(Context context) {
        this.$context = context;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends Channel> call(Map<Long, ? extends Channel> map) {
        return call2((Map<Long, Channel>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Channel> call2(Map<Long, Channel> map) {
        Collection sortedKeys$default = FrecencyTracker.getSortedKeys$default(StoreStream.Companion.getChannelsSelected().getFrecency(), 0L, 1, null);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = sortedKeys$default.iterator();
        while (it.hasNext()) {
            Channel channel = map.get(Long.valueOf(((Number) it.next()).longValue()));
            if (channel != null) {
                arrayList.add(channel);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (T t : arrayList) {
            if (ChannelUtils.m((Channel) t)) {
                arrayList2.add(t);
            }
        }
        return u.take(arrayList2, ShortcutManagerCompat.getMaxShortcutCountPerActivity(this.$context));
    }
}
