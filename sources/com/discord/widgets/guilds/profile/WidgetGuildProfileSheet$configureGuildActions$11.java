package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$configureGuildActions$11 implements View$OnClickListener {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    public WidgetGuildProfileSheet$configureGuildActions$11(WidgetGuildProfileSheet widgetGuildProfileSheet, long j) {
        this.this$0 = widgetGuildProfileSheet;
        this.$guildId = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        b.a.d.m.c(contextRequireContext, String.valueOf(this.$guildId), 0, 4);
    }
}
