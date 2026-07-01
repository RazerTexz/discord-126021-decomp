package com.discord.widgets.channels.memberlist.adapter;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListAdapter$onBindViewHolder$2 extends o implements Function0<Unit> {
    public final /* synthetic */ ChannelMembersListAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListAdapter$onBindViewHolder$2(ChannelMembersListAdapter channelMembersListAdapter) {
        super(0);
        this.this$0 = channelMembersListAdapter;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Function0 function0Access$getOnAddMemberClicked$p = ChannelMembersListAdapter.access$getOnAddMemberClicked$p(this.this$0);
        if (function0Access$getOnAddMemberClicked$p != null) {
        }
    }
}
