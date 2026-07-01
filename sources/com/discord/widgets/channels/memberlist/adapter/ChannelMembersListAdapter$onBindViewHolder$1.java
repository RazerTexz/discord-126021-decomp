package com.discord.widgets.channels.memberlist.adapter;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListAdapter$onBindViewHolder$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ChannelMembersListAdapter$Item$Member $item;
    public final /* synthetic */ ChannelMembersListAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListAdapter$onBindViewHolder$1(ChannelMembersListAdapter channelMembersListAdapter, ChannelMembersListAdapter$Item$Member channelMembersListAdapter$Item$Member) {
        super(0);
        this.this$0 = channelMembersListAdapter;
        this.$item = channelMembersListAdapter$Item$Member;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Function1 function1Access$getOnUserClicked$p = ChannelMembersListAdapter.access$getOnUserClicked$p(this.this$0);
        if (function1Access$getOnUserClicked$p != null) {
        }
    }
}
