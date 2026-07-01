package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.sticker.Sticker;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStickerGreetCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStickerGreetCompact$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ int $channelType;
    public final /* synthetic */ Sticker $sticker;
    public final /* synthetic */ WidgetChatListAdapterItemStickerGreetCompact this$0;

    public WidgetChatListAdapterItemStickerGreetCompact$onConfigure$1(WidgetChatListAdapterItemStickerGreetCompact widgetChatListAdapterItemStickerGreetCompact, long j, int i, Sticker sticker) {
        this.this$0 = widgetChatListAdapterItemStickerGreetCompact;
        this.$channelId = j;
        this.$channelType = i;
        this.$sticker = sticker;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemStickerGreetCompact.access$getAdapter$p(this.this$0).getEventHandler().onSendGreetMessageClicked(this.$channelId, this.$channelType, this.$sticker);
    }
}
