package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$observeCommunicationDisabledGuildMembers$1<T1, T2, R> implements Func2<Set<? extends Long>, Map<Long, ? extends Map<Long, ? extends GuildMember>>, List<? extends GuildMember>> {
    public static final StoreGuilds$observeCommunicationDisabledGuildMembers$1 INSTANCE = new StoreGuilds$observeCommunicationDisabledGuildMembers$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ List<? extends GuildMember> call(Set<? extends Long> set, Map<Long, ? extends Map<Long, ? extends GuildMember>> map) {
        return call2((Set<Long>) set, (Map<Long, ? extends Map<Long, GuildMember>>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<GuildMember> call2(Set<Long> set, Map<Long, ? extends Map<Long, GuildMember>> map) {
        ArrayList arrayList;
        Collection<GuildMember> collectionValues;
        m.checkNotNullExpressionValue(set, "guildIds");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            Map<Long, GuildMember> map2 = map.get(Long.valueOf(((Number) it.next()).longValue()));
            if (map2 == null || (collectionValues = map2.values()) == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (Object obj : collectionValues) {
                    if (((GuildMember) obj).isCommunicationDisabled()) {
                        arrayList.add(obj);
                    }
                }
            }
            if (arrayList != null) {
                arrayList2.add(arrayList);
            }
        }
        return o.flatten(arrayList2);
    }
}
