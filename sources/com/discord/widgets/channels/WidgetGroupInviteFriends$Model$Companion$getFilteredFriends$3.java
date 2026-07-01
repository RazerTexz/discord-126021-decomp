package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import j0.k.b;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3<T, R> implements b<Map<Long, Integer>, Observable<? extends WidgetGroupInviteFriends$Model$ModelAppUserRelationship>> {
    public static final WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3 INSTANCE = new WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends$Model$ModelAppUserRelationship> call(Map<Long, Integer> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetGroupInviteFriends$Model$ModelAppUserRelationship> call2(Map<Long, Integer> map) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.i(storeStream$Companion.getPresences().observePresencesForUsers(map.keySet()), storeStream$Companion.getUsers().observeUsers(map.keySet()), storeStream$Companion.getApplicationStreaming().observeStreamsByUser(), new WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3$1(map));
    }
}
