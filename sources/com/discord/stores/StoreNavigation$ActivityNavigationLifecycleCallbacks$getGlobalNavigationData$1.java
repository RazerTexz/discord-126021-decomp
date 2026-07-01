package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$1<T, R> implements b<MeUser, Boolean> {
    public static final StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$1 INSTANCE = new StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
        return call2(meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(MeUser meUser) {
        UserUtils userUtils = UserUtils.INSTANCE;
        m.checkNotNullExpressionValue(meUser, "me");
        return Boolean.valueOf(userUtils.getHasPhone(meUser));
    }
}
