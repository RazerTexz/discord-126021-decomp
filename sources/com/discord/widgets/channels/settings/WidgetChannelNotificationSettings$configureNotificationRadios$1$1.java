package com.discord.widgets.channels.settings;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings$configureNotificationRadios$1$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelNotificationSettings$Model $this_configureNotificationRadio;
    public final /* synthetic */ int $type;

    public WidgetChannelNotificationSettings$configureNotificationRadios$1$1(WidgetChannelNotificationSettings$Model widgetChannelNotificationSettings$Model, int i) {
        this.$this_configureNotificationRadio = widgetChannelNotificationSettings$Model;
        this.$type = i;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getUserGuildSettings().setChannelFrequency(a.x(view, "it", "it.context"), this.$this_configureNotificationRadio.getChannel(), this.$type);
    }
}
