package com.discord.widgets.channels.invite;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.stores.StoreUser;
import j0.k.b;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: GroupInviteFriendsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheetViewModel$Companion$observeFriends$1<T, R> implements b<Map<Long, ? extends Integer>, Observable<? extends Map<Long, ? extends User>>> {
    public final /* synthetic */ StoreUser $storeUser;

    public GroupInviteFriendsSheetViewModel$Companion$observeFriends$1(StoreUser storeUser) {
        this.$storeUser = storeUser;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends User>> call(Map<Long, ? extends Integer> map) {
        return call2((Map<Long, Integer>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, User>> call2(Map<Long, Integer> map) {
        return this.$storeUser.observeUsers(map.keySet());
    }
}
