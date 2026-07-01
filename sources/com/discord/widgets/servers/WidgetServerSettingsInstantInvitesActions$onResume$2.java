package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.m;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesActions$onResume$2 implements View$OnClickListener {
    public final /* synthetic */ String $inviteUrl;
    public final /* synthetic */ WidgetServerSettingsInstantInvitesActions this$0;

    public WidgetServerSettingsInstantInvitesActions$onResume$2(WidgetServerSettingsInstantInvitesActions widgetServerSettingsInstantInvitesActions, String str) {
        this.this$0 = widgetServerSettingsInstantInvitesActions;
        this.$inviteUrl = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        m.c(a.x(view, "it", "it.context"), this.$inviteUrl, 0, 4);
        this.this$0.dismiss();
    }
}
