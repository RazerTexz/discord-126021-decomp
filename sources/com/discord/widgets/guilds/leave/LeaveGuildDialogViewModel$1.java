package com.discord.widgets.guilds.leave;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class LeaveGuildDialogViewModel$1 extends k implements Function1<LeaveGuildDialogViewModel$StoreState, Unit> {
    public LeaveGuildDialogViewModel$1(LeaveGuildDialogViewModel leaveGuildDialogViewModel) {
        super(1, leaveGuildDialogViewModel, LeaveGuildDialogViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LeaveGuildDialogViewModel$StoreState leaveGuildDialogViewModel$StoreState) {
        invoke2(leaveGuildDialogViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LeaveGuildDialogViewModel$StoreState leaveGuildDialogViewModel$StoreState) {
        m.checkNotNullParameter(leaveGuildDialogViewModel$StoreState, "p1");
        LeaveGuildDialogViewModel.access$handleStoreState((LeaveGuildDialogViewModel) this.receiver, leaveGuildDialogViewModel$StoreState);
    }
}
