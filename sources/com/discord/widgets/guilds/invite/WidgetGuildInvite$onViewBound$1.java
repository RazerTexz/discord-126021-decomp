package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.app.AppActivity;

/* JADX INFO: compiled from: WidgetGuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInvite$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildInvite this$0;

    public WidgetGuildInvite$onViewBound$1(WidgetGuildInvite widgetGuildInvite) {
        this.this$0 = widgetGuildInvite;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) throws Exception {
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.onBackPressed();
        }
    }
}
