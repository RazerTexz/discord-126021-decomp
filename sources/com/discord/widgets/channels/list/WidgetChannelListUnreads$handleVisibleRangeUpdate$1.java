package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChannelListUnreads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListUnreads$handleVisibleRangeUpdate$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelListUnreads$Model$Indicator $indicator;
    public final /* synthetic */ boolean $indicatorUpwards;
    public final /* synthetic */ WidgetChannelListUnreads this$0;

    public WidgetChannelListUnreads$handleVisibleRangeUpdate$1(WidgetChannelListUnreads widgetChannelListUnreads, WidgetChannelListUnreads$Model$Indicator widgetChannelListUnreads$Model$Indicator, boolean z2) {
        this.this$0 = widgetChannelListUnreads;
        this.$indicator = widgetChannelListUnreads$Model$Indicator;
        this.$indicatorUpwards = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelListUnreads.access$handleClick(this.this$0, this.$indicator, this.$indicatorUpwards);
    }
}
