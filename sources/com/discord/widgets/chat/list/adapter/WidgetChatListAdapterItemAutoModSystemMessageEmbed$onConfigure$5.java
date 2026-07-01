package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.chat.list.entries.AutoModSystemMessageEmbedEntry;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$5 implements View$OnClickListener {
    public final /* synthetic */ AutoModSystemMessageEmbedEntry $messageEntry;
    public final /* synthetic */ WidgetChatListAdapterItemAutoModSystemMessageEmbed this$0;

    public WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$5(WidgetChatListAdapterItemAutoModSystemMessageEmbed widgetChatListAdapterItemAutoModSystemMessageEmbed, AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry) {
        this.this$0 = widgetChatListAdapterItemAutoModSystemMessageEmbed;
        this.$messageEntry = autoModSystemMessageEmbedEntry;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(this.this$0).getEventHandler().onReportIssueWithAutoMod(WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(this.this$0).getContext(), this.$messageEntry.getMessage());
    }
}
