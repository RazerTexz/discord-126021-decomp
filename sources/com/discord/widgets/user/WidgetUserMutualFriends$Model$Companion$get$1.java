package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import d0.t.o;
import d0.z.d.m;
import j0.k.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualFriends$Model$Companion$get$1<T, R> implements b<List<? extends ModelUserRelationship>, Observable<? extends WidgetUserMutualFriends$Model>> {
    public final /* synthetic */ long $userId;

    public WidgetUserMutualFriends$Model$Companion$get$1(long j) {
        this.$userId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetUserMutualFriends$Model> call(List<? extends ModelUserRelationship> list) {
        return call2(list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetUserMutualFriends$Model> call2(List<? extends ModelUserRelationship> list) {
        m.checkNotNullExpressionValue(list, "relationshipsApiResponse");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((ModelUserRelationship) it.next()).getId()));
        }
        Observable<Map<Long, List<Guild>>> observableObserveMutualGuilds = new UserMutualGuildsManager(null, null, null, 7, null).observeMutualGuilds(arrayList);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveMutualGuilds, storeStream$Companion.getUsers().observeUsers(arrayList), storeStream$Companion.getPresences().observePresencesForUsers(arrayList), storeStream$Companion.getUserRelationships().observe(), storeStream$Companion.getApplicationStreaming().observeStreamsByUser(), storeStream$Companion.getUsers().observeUser(this.$userId), WidgetUserMutualFriends$Model$Companion$get$1$1.INSTANCE, 1000L, TimeUnit.MILLISECONDS);
    }
}
