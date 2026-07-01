package com.discord.widgets.channels.memberlist;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel$Companion$observeStoreState$1$2<T1, T2, R> implements Func2<PrivateChannelMemberListService$State, Boolean, WidgetChannelMembersListViewModel$StoreState$Private> {
    public final /* synthetic */ WidgetChannelMembersListViewModel$Companion$observeStoreState$1 this$0;

    public WidgetChannelMembersListViewModel$Companion$observeStoreState$1$2(WidgetChannelMembersListViewModel$Companion$observeStoreState$1 widgetChannelMembersListViewModel$Companion$observeStoreState$1) {
        this.this$0 = widgetChannelMembersListViewModel$Companion$observeStoreState$1;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel$StoreState$Private call(PrivateChannelMemberListService$State privateChannelMemberListService$State, Boolean bool) {
        return call2(privateChannelMemberListService$State, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelMembersListViewModel$StoreState$Private call2(PrivateChannelMemberListService$State privateChannelMemberListService$State, Boolean bool) {
        m.checkNotNullExpressionValue(bool, "isPanelOpen");
        return new WidgetChannelMembersListViewModel$StoreState$Private(bool.booleanValue(), privateChannelMemberListService$State.getChannel(), privateChannelMemberListService$State.getUsers(), privateChannelMemberListService$State.getPresences(), privateChannelMemberListService$State.getApplicationStreams(), this.this$0.$storeUserRelationships.getRelationships());
    }
}
