package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$Companion$observeStores$3<T, R> implements b<MeUser, Boolean> {
    public final /* synthetic */ Clock $clock;

    public WidgetGuildsListViewModel$Companion$observeStores$3(Clock clock) {
        this.$clock = clock;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
        return call2(meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(MeUser meUser) {
        UserUtils userUtils = UserUtils.INSTANCE;
        m.checkNotNullExpressionValue(meUser, "meUser");
        return Boolean.valueOf(userUtils.getAgeMs(meUser, this.$clock) < 1209600000);
    }
}
