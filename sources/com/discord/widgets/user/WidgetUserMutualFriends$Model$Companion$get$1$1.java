package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import rx.functions.Func6;

/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualFriends$Model$Companion$get$1$1<T1, T2, T3, T4, T5, T6, R> implements Func6<Map<Long, ? extends List<? extends Guild>>, Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends Integer>, Map<Long, ? extends ModelApplicationStream>, User, WidgetUserMutualFriends$Model> {
    public static final WidgetUserMutualFriends$Model$Companion$get$1$1 INSTANCE = new WidgetUserMutualFriends$Model$Companion$get$1$1();

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetUserMutualFriends$Model call(Map<Long, ? extends List<? extends Guild>> map, Map<Long, ? extends User> map2, Map<Long, ? extends Presence> map3, Map<Long, ? extends Integer> map4, Map<Long, ? extends ModelApplicationStream> map5, User user) {
        return call2((Map<Long, ? extends List<Guild>>) map, map2, (Map<Long, Presence>) map3, (Map<Long, Integer>) map4, map5, user);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetUserMutualFriends$Model call2(Map<Long, ? extends List<Guild>> map, Map<Long, ? extends User> map2, Map<Long, Presence> map3, Map<Long, Integer> map4, Map<Long, ? extends ModelApplicationStream> map5, User user) {
        m.checkNotNullExpressionValue(map2, "users");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, ? extends User> map$Entry : map2.entrySet()) {
            if (map4.containsKey(Long.valueOf(map$Entry.getKey().longValue()))) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map$Entry map$Entry2 : linkedHashMap.entrySet()) {
            long jLongValue = ((Number) map$Entry2.getKey()).longValue();
            User user2 = (User) map$Entry2.getValue();
            Presence presence = map3.get(Long.valueOf(jLongValue));
            List<Guild> listEmptyList = map.get(Long.valueOf(jLongValue));
            if (listEmptyList == null) {
                listEmptyList = n.emptyList();
            }
            arrayList.add(new WidgetUserMutualFriends$Model$Item$MutualFriend(user2, presence, listEmptyList, Boolean.valueOf(map5.containsKey(Long.valueOf(jLongValue)))));
        }
        return new WidgetUserMutualFriends$Model(user, arrayList.isEmpty() ? u.plus((Collection<? extends WidgetUserMutualFriends$Model$Item$Empty>) arrayList, WidgetUserMutualFriends$Model$Item$Empty.INSTANCE) : arrayList, arrayList.size());
    }
}
