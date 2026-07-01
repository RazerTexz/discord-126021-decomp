package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: StoreChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannels$observeDMs$1<T, R> implements b<Map<Long, ? extends Channel>, List<? extends Channel>> {
    public static final StoreChannels$observeDMs$1 INSTANCE = new StoreChannels$observeDMs$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends Channel> call(Map<Long, ? extends Channel> map) {
        return call2((Map<Long, Channel>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Channel> call2(Map<Long, Channel> map) {
        Collection<Channel> collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        for (T t : collectionValues) {
            if (ChannelUtils.m((Channel) t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}
