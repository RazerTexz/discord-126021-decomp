package com.discord.widgets.friends;

import androidx.core.app.NotificationCompat;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby$ModelProvider$getUserModels$1<T1, T2, T3, R> implements Func3<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends Integer>, WidgetFriendsFindNearby$Model$NearbyUsers> {
    public static final WidgetFriendsFindNearby$ModelProvider$getUserModels$1 INSTANCE = new WidgetFriendsFindNearby$ModelProvider$getUserModels$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetFriendsFindNearby$Model$NearbyUsers call(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2, Map<Long, ? extends Integer> map3) {
        return call2(map, (Map<Long, Presence>) map2, (Map<Long, Integer>) map3);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetFriendsFindNearby$Model$NearbyUsers call2(Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, Integer> map3) {
        m.checkNotNullExpressionValue(map, "users");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map$Entry<Long, ? extends User> map$Entry : map.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            User value = map$Entry.getValue();
            List listEmptyList = n.emptyList();
            Presence presence = map2.get(Long.valueOf(jLongValue));
            Integer num = map3.get(Long.valueOf(jLongValue));
            boolean z2 = true;
            if (num == null || num.intValue() != 1) {
                z2 = false;
            }
            arrayList.add(new WidgetFriendsAddUserAdapter$ItemUser(value, listEmptyList, presence, z2));
        }
        return new WidgetFriendsFindNearby$Model$NearbyUsers(arrayList);
    }
}
