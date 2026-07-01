package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import java.util.Collection;
import java.util.Map;
import rx.functions.Action1;

/* JADX INFO: compiled from: StoreUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUser$observeUsers$1<T> implements Action1<Map<Long, ? extends User>> {
    public final /* synthetic */ boolean $fetchUserIfMissing;
    public final /* synthetic */ Collection $userIds;
    public final /* synthetic */ StoreUser this$0;

    public StoreUser$observeUsers$1(StoreUser storeUser, boolean z2, Collection collection) {
        this.this$0 = storeUser;
        this.$fetchUserIfMissing = z2;
        this.$userIds = collection;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Map<Long, ? extends User> map) {
        call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Map<Long, ? extends User> map) {
        if (this.$fetchUserIfMissing) {
            StoreUser.access$fetchMissing(this.this$0, this.$userIds, map.keySet());
        }
    }
}
