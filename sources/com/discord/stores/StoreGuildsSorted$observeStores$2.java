package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.functions.Func4;

/* JADX INFO: compiled from: StoreGuildsSorted.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildsSorted$observeStores$2<T1, T2, T3, T4, R> implements Func4<Map<Long, ? extends Guild>, Set<? extends Long>, Map<Long, ? extends Long>, List<? extends ModelGuildFolder>, StoreGuildsSorted$State> {
    public static final StoreGuildsSorted$observeStores$2 INSTANCE = new StoreGuildsSorted$observeStores$2();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ StoreGuildsSorted$State call(Map<Long, ? extends Guild> map, Set<? extends Long> set, Map<Long, ? extends Long> map2, List<? extends ModelGuildFolder> list) {
        return call2((Map<Long, Guild>) map, (Set<Long>) set, (Map<Long, Long>) map2, (List<ModelGuildFolder>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StoreGuildsSorted$State call2(Map<Long, Guild> map, Set<Long> set, Map<Long, Long> map2, List<ModelGuildFolder> list) {
        m.checkNotNullExpressionValue(set, "mutedGuilds");
        m.checkNotNullExpressionValue(map2, "joinedAt");
        m.checkNotNullExpressionValue(list, "folders");
        return new StoreGuildsSorted$State(set, map2, list);
    }
}
