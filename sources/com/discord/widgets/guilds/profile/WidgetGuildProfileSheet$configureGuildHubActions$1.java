package com.discord.widgets.guilds.profile;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$configureGuildHubActions$1 implements View$OnClickListener {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    public WidgetGuildProfileSheet$configureGuildHubActions$1(WidgetGuildProfileSheet widgetGuildProfileSheet, long j) {
        this.this$0 = widgetGuildProfileSheet;
        this.$guildId = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildProfileSheet.access$launchInvite(this.this$0, this.$guildId);
    }
}
