package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import rx.Observable;

/* JADX INFO: compiled from: StoreChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannels$observeChannelsForGuild$1<T, R> implements b<Map<Long, ? extends Channel>, Observable<? extends Map<Long, ? extends Channel>>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Integer $type;

    public StoreChannels$observeChannelsForGuild$1(long j, Integer num) {
        this.$guildId = j;
        this.$type = num;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends Channel>> call(Map<Long, ? extends Channel> map) {
        return call2((Map<Long, Channel>) map);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0043  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, Channel>> call2(Map<Long, Channel> map) {
        boolean z2;
        m.checkNotNullExpressionValue(map, "channels");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Channel> map$Entry : map.entrySet()) {
            Channel value = map$Entry.getValue();
            if (value.getGuildId() != this.$guildId) {
                z2 = false;
            } else {
                if (this.$type != null) {
                    int type = value.getType();
                    Integer num = this.$type;
                    if (num == null || type != num.intValue()) {
                        z2 = false;
                    }
                }
                z2 = true;
            }
            if (z2) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        return new k(linkedHashMap);
    }
}
