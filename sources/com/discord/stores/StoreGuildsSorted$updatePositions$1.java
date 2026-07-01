package com.discord.stores;

import com.discord.models.guild.Guild;
import d0.g0.t;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: compiled from: StoreGuildsSorted.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildsSorted$updatePositions$1<T> implements Comparator<Long> {
    public final /* synthetic */ Map $guilds;
    public final /* synthetic */ StoreGuildsSorted$State $state;

    public StoreGuildsSorted$updatePositions$1(StoreGuildsSorted$State storeGuildsSorted$State, Map map) {
        this.$state = storeGuildsSorted$State;
        this.$guilds = map;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Long l, Long l2) {
        return compare2(l, l2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(Long l, Long l2) {
        String name;
        String name2;
        boolean zContains = this.$state.getMutedGuilds().contains(l);
        if (this.$state.getMutedGuilds().contains(l2) != zContains) {
            return zContains ? 1 : -1;
        }
        Long l3 = this.$state.getJoinedAt().get(l);
        long jLongValue = l3 != null ? l3.longValue() : Long.MIN_VALUE;
        Long l4 = this.$state.getJoinedAt().get(l);
        long jLongValue2 = l4 != null ? l4.longValue() : Long.MIN_VALUE;
        if (jLongValue != jLongValue2) {
            return (int) (jLongValue - jLongValue2);
        }
        Guild guild = (Guild) this.$guilds.get(l);
        String str = "";
        if (guild == null || (name = guild.getName()) == null) {
            name = "";
        }
        Guild guild2 = (Guild) this.$guilds.get(l2);
        if (guild2 != null && (name2 = guild2.getName()) != null) {
            str = name2;
        }
        return t.compareTo(name, str, false);
    }
}
