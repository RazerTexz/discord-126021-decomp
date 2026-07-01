package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsersViewModel$getUpdatedPruneCount$2<T, R> implements b<Integer, WidgetPruneUsersViewModel$ViewState> {
    public final /* synthetic */ WidgetPruneUsersViewModel this$0;

    public WidgetPruneUsersViewModel$getUpdatedPruneCount$2(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        this.this$0 = widgetPruneUsersViewModel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetPruneUsersViewModel$ViewState call(Integer num) {
        return call2(num);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetPruneUsersViewModel$ViewState call2(Integer num) {
        WidgetPruneUsersViewModel$PruneDays widgetPruneUsersViewModel$PruneDaysAccess$getWhichPruneDays$p = WidgetPruneUsersViewModel.access$getWhichPruneDays$p(this.this$0);
        m.checkNotNullExpressionValue(num, "count");
        return new WidgetPruneUsersViewModel$ViewState$Loaded(widgetPruneUsersViewModel$PruneDaysAccess$getWhichPruneDays$p, num.intValue(), false, 4, null);
    }
}
