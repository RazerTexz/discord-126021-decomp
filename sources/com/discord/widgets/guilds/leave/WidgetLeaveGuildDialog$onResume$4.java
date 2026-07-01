package com.discord.widgets.guilds.leave;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetLeaveGuildDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetLeaveGuildDialog$onResume$4 extends o implements Function1<LeaveGuildDialogViewModel$Event, Unit> {
    public final /* synthetic */ WidgetLeaveGuildDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetLeaveGuildDialog$onResume$4(WidgetLeaveGuildDialog widgetLeaveGuildDialog) {
        super(1);
        this.this$0 = widgetLeaveGuildDialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LeaveGuildDialogViewModel$Event leaveGuildDialogViewModel$Event) {
        invoke2(leaveGuildDialogViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LeaveGuildDialogViewModel$Event leaveGuildDialogViewModel$Event) {
        m.checkNotNullParameter(leaveGuildDialogViewModel$Event, "event");
        WidgetLeaveGuildDialog.access$handleEvent(this.this$0, leaveGuildDialogViewModel$Event);
    }
}
