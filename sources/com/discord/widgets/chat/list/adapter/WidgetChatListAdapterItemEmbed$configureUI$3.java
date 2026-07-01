package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.list.entries.EmbedEntry;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ EmbedEntry $data;
    public final /* synthetic */ WidgetChatListAdapterItemEmbed$Model $model;
    public final /* synthetic */ WidgetChatListAdapterItemEmbed this$0;

    public WidgetChatListAdapterItemEmbed$configureUI$3(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, WidgetChatListAdapterItemEmbed$Model widgetChatListAdapterItemEmbed$Model, EmbedEntry embedEntry) {
        this.this$0 = widgetChatListAdapterItemEmbed;
        this.$model = widgetChatListAdapterItemEmbed$Model;
        this.$data = embedEntry;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (WidgetChatListAdapterItemEmbed.access$getAdapter$p(this.this$0).getData().getIsSpoilerClickAllowed()) {
            StoreStream.Companion.getMessageState().revealSpoilerEmbed(this.$model.getEmbedEntry().getMessage().getId(), this.$data.getEmbedIndex());
        } else {
            WidgetChatListAdapterItemEmbed.access$getAdapter$p(this.this$0).getEventHandler().onMessageClicked(this.$model.getEmbedEntry().getMessage(), this.$data.isThreadStarterMessage());
        }
    }
}
