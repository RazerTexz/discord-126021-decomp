package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareCompact$onViewBound$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildInviteShareCompact this$0;

    public WidgetGuildInviteShareCompact$onViewBound$4(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
        this.this$0 = widgetGuildInviteShareCompact;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(this.this$0).setState(3);
    }
}
