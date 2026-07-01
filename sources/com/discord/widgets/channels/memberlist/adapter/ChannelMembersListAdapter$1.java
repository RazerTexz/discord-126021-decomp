package com.discord.widgets.channels.memberlist.adapter;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$MemberList;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListAdapter$1 extends o implements Function2<ChannelMembersListAdapter$ListUpdateRequest, ChannelMembersListAdapter$ListUpdateRequest, ChannelMembersListAdapter$ListUpdateOperation> {
    public static final ChannelMembersListAdapter$1 INSTANCE = new ChannelMembersListAdapter$1();

    public ChannelMembersListAdapter$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ ChannelMembersListAdapter$ListUpdateOperation invoke(ChannelMembersListAdapter$ListUpdateRequest channelMembersListAdapter$ListUpdateRequest, ChannelMembersListAdapter$ListUpdateRequest channelMembersListAdapter$ListUpdateRequest2) {
        return invoke2(channelMembersListAdapter$ListUpdateRequest, channelMembersListAdapter$ListUpdateRequest2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ChannelMembersListAdapter$ListUpdateOperation invoke2(ChannelMembersListAdapter$ListUpdateRequest channelMembersListAdapter$ListUpdateRequest, ChannelMembersListAdapter$ListUpdateRequest channelMembersListAdapter$ListUpdateRequest2) {
        m.checkNotNullParameter(channelMembersListAdapter$ListUpdateRequest, "prevRequest");
        m.checkNotNullParameter(channelMembersListAdapter$ListUpdateRequest2, "nextRequest");
        if (channelMembersListAdapter$ListUpdateRequest2.getForceOverwrite()) {
            return new ChannelMembersListAdapter$ListUpdateOperation$OverwriteUpdate(channelMembersListAdapter$ListUpdateRequest2);
        }
        String listId = channelMembersListAdapter$ListUpdateRequest.getListId();
        WidgetChannelMembersListViewModel$MemberList rows = channelMembersListAdapter$ListUpdateRequest.getRows();
        String listId2 = channelMembersListAdapter$ListUpdateRequest2.getListId();
        WidgetChannelMembersListViewModel$MemberList rows2 = channelMembersListAdapter$ListUpdateRequest2.getRows();
        if (!m.areEqual(listId, listId2) || Math.abs(rows.getSize() - rows2.getSize()) >= 255) {
            return new ChannelMembersListAdapter$ListUpdateOperation$OverwriteUpdate(channelMembersListAdapter$ListUpdateRequest2);
        }
        DiffUtil$DiffResult diffUtil$DiffResultCalculateDiff = DiffUtil.calculateDiff(new ChannelMembersListAdapter$DiffUtilCallback(rows, rows2));
        m.checkNotNullExpressionValue(diffUtil$DiffResultCalculateDiff, "DiffUtil.calculateDiff(diffUtilCallback)");
        return new ChannelMembersListAdapter$ListUpdateOperation$DiffUpdate(diffUtil$DiffResultCalculateDiff, channelMembersListAdapter$ListUpdateRequest2);
    }
}
