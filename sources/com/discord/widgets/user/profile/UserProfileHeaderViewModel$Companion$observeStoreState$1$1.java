package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import j0.k.b;
import kotlin.Pair;

/* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderViewModel$Companion$observeStoreState$1$1<T, R> implements b<User, Pair<? extends MeUser, ? extends User>> {
    public final /* synthetic */ MeUser $meUser;

    public UserProfileHeaderViewModel$Companion$observeStoreState$1$1(MeUser meUser) {
        this.$meUser = meUser;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Pair<? extends MeUser, ? extends User> call(User user) {
        return call2(user);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<MeUser, User> call2(User user) {
        return new Pair<>(this.$meUser, user);
    }
}
