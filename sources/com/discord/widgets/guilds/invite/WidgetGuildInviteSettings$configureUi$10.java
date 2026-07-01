package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteSettings$configureUi$10 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildInviteSettings this$0;

    public WidgetGuildInviteSettings$configureUi$10(WidgetGuildInviteSettings widgetGuildInviteSettings) {
        this.this$0 = widgetGuildInviteSettings;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteSettings.access$getViewModel$p(this.this$0).saveInviteSettings();
    }
}
