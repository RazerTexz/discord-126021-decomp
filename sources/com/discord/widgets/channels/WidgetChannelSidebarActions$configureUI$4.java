package com.discord.widgets.channels;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.search.WidgetSearch;

/* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActions$configureUI$4 implements View$OnClickListener {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Context $context;

    public WidgetChannelSidebarActions$configureUI$4(long j, Context context) {
        this.$channelId = j;
        this.$context = context;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSearch.Companion.launchForChannel(this.$channelId, this.$context);
    }
}
