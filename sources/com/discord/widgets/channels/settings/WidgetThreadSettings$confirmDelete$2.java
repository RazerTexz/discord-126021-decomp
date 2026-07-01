package com.discord.widgets.channels.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettings$confirmDelete$2 implements View$OnClickListener {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetThreadSettings this$0;

    public WidgetThreadSettings$confirmDelete$2(WidgetThreadSettings widgetThreadSettings, Channel channel) {
        this.this$0 = widgetThreadSettings;
        this.$channel = channel;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetThreadSettings.access$getViewModel$p(this.this$0).onThreadDeleted(this.$channel.getId());
    }
}
