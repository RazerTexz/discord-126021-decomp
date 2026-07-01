package com.discord.widgets.guilds.leave;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetLeaveGuildDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetLeaveGuildDialog$onResume$3 extends o implements Function1<LeaveGuildDialogViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetLeaveGuildDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetLeaveGuildDialog$onResume$3(WidgetLeaveGuildDialog widgetLeaveGuildDialog) {
        super(1);
        this.this$0 = widgetLeaveGuildDialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LeaveGuildDialogViewModel$ViewState leaveGuildDialogViewModel$ViewState) {
        invoke2(leaveGuildDialogViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LeaveGuildDialogViewModel$ViewState leaveGuildDialogViewModel$ViewState) {
        m.checkNotNullParameter(leaveGuildDialogViewModel$ViewState, "viewState");
        WidgetLeaveGuildDialog.access$configureUI(this.this$0, leaveGuildDialogViewModel$ViewState);
    }
}
