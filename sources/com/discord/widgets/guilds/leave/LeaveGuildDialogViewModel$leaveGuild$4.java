package com.discord.widgets.guilds.leave;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LeaveGuildDialogViewModel$leaveGuild$4 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ LeaveGuildDialogViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeaveGuildDialogViewModel$leaveGuild$4(LeaveGuildDialogViewModel leaveGuildDialogViewModel) {
        super(1);
        this.this$0 = leaveGuildDialogViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        LeaveGuildDialogViewModel.access$onLeaveFailed(this.this$0);
    }
}
