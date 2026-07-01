package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.PruneCountResponse;
import j0.k.b;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsersViewModel$getUpdatedPruneCount$1<T, R> implements b<PruneCountResponse, Integer> {
    public static final WidgetPruneUsersViewModel$getUpdatedPruneCount$1 INSTANCE = new WidgetPruneUsersViewModel$getUpdatedPruneCount$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Integer call(PruneCountResponse pruneCountResponse) {
        return call2(pruneCountResponse);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(PruneCountResponse pruneCountResponse) {
        return Integer.valueOf(pruneCountResponse.getPruned());
    }
}
