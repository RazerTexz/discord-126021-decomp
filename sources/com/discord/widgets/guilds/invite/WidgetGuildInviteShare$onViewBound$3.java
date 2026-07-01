package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildInviteShare this$0;

    public WidgetGuildInviteShare$onViewBound$3(WidgetGuildInviteShare widgetGuildInviteShare) {
        this.this$0 = widgetGuildInviteShare;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteShare.access$getBottomSheetBehavior$p(this.this$0).setState(3);
    }
}
