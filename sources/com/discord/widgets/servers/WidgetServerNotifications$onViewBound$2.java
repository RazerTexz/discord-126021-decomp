package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ long $guildId;

    public WidgetServerNotifications$onViewBound$2(long j) {
        this.$guildId = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerNotificationsOverrideSelector.Companion.launch(a.x(view, "it", "it.context"), this.$guildId);
    }
}
