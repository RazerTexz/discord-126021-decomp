package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$onViewBound$14 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelsList this$0;

    public WidgetChannelsList$onViewBound$14(WidgetChannelsList widgetChannelsList) {
        this.this$0 = widgetChannelsList;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelsList.access$ackPremiumGuildHint(this.this$0);
    }
}
