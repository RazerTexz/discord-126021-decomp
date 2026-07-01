package com.discord.widgets.user;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetKickUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetKickUser$onViewBoundOrOnResume$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetKickUser this$0;

    public WidgetKickUser$onViewBoundOrOnResume$3(WidgetKickUser widgetKickUser) {
        this.this$0 = widgetKickUser;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
