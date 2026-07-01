package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsersViewModel$getUpdatedPruneCount$4<T, R> implements b<Throwable, WidgetPruneUsersViewModel$ViewState> {
    public static final WidgetPruneUsersViewModel$getUpdatedPruneCount$4 INSTANCE = new WidgetPruneUsersViewModel$getUpdatedPruneCount$4();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetPruneUsersViewModel$ViewState call(Throwable th) {
        return call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetPruneUsersViewModel$ViewState call2(Throwable th) {
        return new WidgetPruneUsersViewModel$ViewState$LoadFailed(false);
    }
}
