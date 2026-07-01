package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.utilities.intent.IntentUtils;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesActions$onResume$3 implements View$OnClickListener {
    public final /* synthetic */ String $inviteUrl;
    public final /* synthetic */ WidgetServerSettingsInstantInvitesActions this$0;

    public WidgetServerSettingsInstantInvitesActions$onResume$3(WidgetServerSettingsInstantInvitesActions widgetServerSettingsInstantInvitesActions, String str) {
        this.this$0 = widgetServerSettingsInstantInvitesActions;
        this.$inviteUrl = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Context contextX = a.x(view, "it", "it.context");
        String str = this.$inviteUrl;
        IntentUtils.performChooserSendIntent(contextX, str, b.k(this.this$0, 2131895644, new Object[]{str}, null, 4));
        this.this$0.dismiss();
    }
}
