package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.channels.settings.WidgetThreadSettings;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStart.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStart$configureThread$3 implements View$OnClickListener {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ WidgetChatListAdapterItemStart this$0;

    public WidgetChatListAdapterItemStart$configureThread$3(WidgetChatListAdapterItemStart widgetChatListAdapterItemStart, long j) {
        this.this$0 = widgetChatListAdapterItemStart;
        this.$channelId = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetThreadSettings.Companion.launch(this.$channelId, WidgetChatListAdapterItemStart.access$getAdapter$p(this.this$0).getContext());
    }
}
