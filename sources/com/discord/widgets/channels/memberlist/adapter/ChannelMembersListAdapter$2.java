package com.discord.widgets.channels.memberlist.adapter;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListAdapter$2<T1, T2, R> implements Func2<ChannelMembersListAdapter$ListUpdateOperation, ChannelMembersListAdapter$ListUpdateRequest, ChannelMembersListAdapter$ListUpdateOperation> {
    public static final ChannelMembersListAdapter$2 INSTANCE = new ChannelMembersListAdapter$2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ ChannelMembersListAdapter$ListUpdateOperation call(ChannelMembersListAdapter$ListUpdateOperation channelMembersListAdapter$ListUpdateOperation, ChannelMembersListAdapter$ListUpdateRequest channelMembersListAdapter$ListUpdateRequest) {
        return call2(channelMembersListAdapter$ListUpdateOperation, channelMembersListAdapter$ListUpdateRequest);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ChannelMembersListAdapter$ListUpdateOperation call2(ChannelMembersListAdapter$ListUpdateOperation channelMembersListAdapter$ListUpdateOperation, ChannelMembersListAdapter$ListUpdateRequest channelMembersListAdapter$ListUpdateRequest) {
        ChannelMembersListAdapter$1 channelMembersListAdapter$1 = ChannelMembersListAdapter$1.INSTANCE;
        ChannelMembersListAdapter$ListUpdateRequest request = channelMembersListAdapter$ListUpdateOperation.getRequest();
        m.checkNotNullExpressionValue(channelMembersListAdapter$ListUpdateRequest, "nextUpdate");
        return channelMembersListAdapter$1.invoke2(request, channelMembersListAdapter$ListUpdateRequest);
    }
}
