package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import j0.k.b;
import java.util.List;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1<T, R> implements b<Map<Long, ? extends Integer>, Observable<? extends Map<Long, Integer>>> {
    public final /* synthetic */ List $excludeUserIds;
    public final /* synthetic */ WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2 this$0;

    public WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1(WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2 widgetGroupInviteFriends$Model$Companion$getFilteredFriends$2, List list) {
        this.this$0 = widgetGroupInviteFriends$Model$Companion$getFilteredFriends$2;
        this.$excludeUserIds = list;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, Integer>> call(Map<Long, ? extends Integer> map) {
        return call2((Map<Long, Integer>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, Integer>> call2(Map<Long, Integer> map) {
        return StoreStream.Companion.getUsers().observeUsers(map.keySet()).Y(new WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1(this, map));
    }
}
