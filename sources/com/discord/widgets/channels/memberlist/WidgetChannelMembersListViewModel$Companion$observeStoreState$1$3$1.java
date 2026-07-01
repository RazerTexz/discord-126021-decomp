package com.discord.widgets.channels.memberlist;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3$1<T, R> implements b<Boolean, WidgetChannelMembersListViewModel$StoreState$None> {
    public static final WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3$1 INSTANCE = new WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel$StoreState$None call(Boolean bool) {
        return call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelMembersListViewModel$StoreState$None call2(Boolean bool) {
        m.checkNotNullExpressionValue(bool, "isPanelOpen");
        return new WidgetChannelMembersListViewModel$StoreState$None(bool.booleanValue());
    }
}
