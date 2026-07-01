package com.discord.widgets.nux;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt$onViewBound$4 implements View$OnClickListener {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ WidgetNuxChannelPrompt this$0;

    public WidgetNuxChannelPrompt$onViewBound$4(WidgetNuxChannelPrompt widgetNuxChannelPrompt, long j) {
        this.this$0 = widgetNuxChannelPrompt;
        this.$guildId = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetNuxChannelPrompt.access$handleSubmit(this.this$0, this.$guildId);
    }
}
