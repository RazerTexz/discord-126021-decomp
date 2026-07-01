package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;

/* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadArchiveActions$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetThreadArchiveActions this$0;

    public WidgetThreadArchiveActions$configureUI$3(WidgetThreadArchiveActions widgetThreadArchiveActions, Channel channel) {
        this.this$0 = widgetThreadArchiveActions;
        this.$channel = channel;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetThreadArchiveActions.access$setAutoArchiveDuration(this.this$0, this.$channel, 1440);
    }
}
