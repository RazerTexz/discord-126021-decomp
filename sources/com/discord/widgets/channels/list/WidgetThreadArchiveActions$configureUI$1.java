package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;

/* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadArchiveActions$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetThreadArchiveActions$Model $model;
    public final /* synthetic */ WidgetThreadArchiveActions this$0;

    public WidgetThreadArchiveActions$configureUI$1(WidgetThreadArchiveActions widgetThreadArchiveActions, Channel channel, WidgetThreadArchiveActions$Model widgetThreadArchiveActions$Model) {
        this.this$0 = widgetThreadArchiveActions;
        this.$channel = channel;
        this.$model = widgetThreadArchiveActions$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetThreadArchiveActions.access$archiveThread(this.this$0, this.$channel, this.$model.isModerator());
    }
}
