package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreUser;
import j0.k.b;
import j0.l.e.k;
import kotlin.Pair;
import rx.Observable;

/* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderViewModel$Companion$observeStoreState$1<T, R> implements b<MeUser, Observable<? extends Pair<? extends MeUser, ? extends User>>> {
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ long $userId;

    public UserProfileHeaderViewModel$Companion$observeStoreState$1(long j, StoreUser storeUser) {
        this.$userId = j;
        this.$storeUser = storeUser;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Pair<? extends MeUser, ? extends User>> call(MeUser meUser) {
        return call2(meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Pair<MeUser, User>> call2(MeUser meUser) {
        long j = this.$userId;
        return j == -1 ? new k(new Pair(meUser, meUser)) : this.$storeUser.observeUser(j).G(new UserProfileHeaderViewModel$Companion$observeStoreState$1$1(meUser));
    }
}
