package com.discord.widgets.channels.memberlist.adapter;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListAdapter$3 extends o implements Function1<ChannelMembersListAdapter$ListUpdateOperation, Unit> {
    public final /* synthetic */ ChannelMembersListAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListAdapter$3(ChannelMembersListAdapter channelMembersListAdapter) {
        super(1);
        this.this$0 = channelMembersListAdapter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChannelMembersListAdapter$ListUpdateOperation channelMembersListAdapter$ListUpdateOperation) {
        invoke2(channelMembersListAdapter$ListUpdateOperation);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChannelMembersListAdapter$ListUpdateOperation channelMembersListAdapter$ListUpdateOperation) {
        ChannelMembersListAdapter.access$setMemberList$p(this.this$0, channelMembersListAdapter$ListUpdateOperation.getRequest().getRows());
        if (channelMembersListAdapter$ListUpdateOperation instanceof ChannelMembersListAdapter$ListUpdateOperation$DiffUpdate) {
            ((ChannelMembersListAdapter$ListUpdateOperation$DiffUpdate) channelMembersListAdapter$ListUpdateOperation).getDiffResult().dispatchUpdatesTo(this.this$0);
        } else if (channelMembersListAdapter$ListUpdateOperation instanceof ChannelMembersListAdapter$ListUpdateOperation$OverwriteUpdate) {
            this.this$0.notifyDataSetChanged();
        }
    }
}
