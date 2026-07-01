package com.discord.widgets.guilds.leave;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetLeaveGuildDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetLeaveGuildDialog$onResume$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetLeaveGuildDialog this$0;

    public WidgetLeaveGuildDialog$onResume$1(WidgetLeaveGuildDialog widgetLeaveGuildDialog) {
        this.this$0 = widgetLeaveGuildDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetLeaveGuildDialog.access$getViewModel$p(this.this$0).leaveGuild();
    }
}
