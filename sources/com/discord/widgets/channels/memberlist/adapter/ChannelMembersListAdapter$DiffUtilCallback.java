package com.discord.widgets.channels.memberlist.adapter;

import androidx.recyclerview.widget.DiffUtil$Callback;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$MemberList;
import d0.z.d.m;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListAdapter$DiffUtilCallback extends DiffUtil$Callback {
    private final WidgetChannelMembersListViewModel$MemberList nextMemberList;
    private final WidgetChannelMembersListViewModel$MemberList prevMemberList;

    public ChannelMembersListAdapter$DiffUtilCallback(WidgetChannelMembersListViewModel$MemberList widgetChannelMembersListViewModel$MemberList, WidgetChannelMembersListViewModel$MemberList widgetChannelMembersListViewModel$MemberList2) {
        m.checkNotNullParameter(widgetChannelMembersListViewModel$MemberList, "prevMemberList");
        m.checkNotNullParameter(widgetChannelMembersListViewModel$MemberList2, "nextMemberList");
        this.prevMemberList = widgetChannelMembersListViewModel$MemberList;
        this.nextMemberList = widgetChannelMembersListViewModel$MemberList2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return m.areEqual(this.prevMemberList.get(oldItemPosition), this.nextMemberList.get(newItemPosition));
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return m.areEqual(this.prevMemberList.get(oldItemPosition).getRowId(), this.nextMemberList.get(newItemPosition).getRowId());
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public int getNewListSize() {
        return this.nextMemberList.getSize();
    }

    @Override // androidx.recyclerview.widget.DiffUtil$Callback
    public int getOldListSize() {
        return this.prevMemberList.getSize();
    }
}
