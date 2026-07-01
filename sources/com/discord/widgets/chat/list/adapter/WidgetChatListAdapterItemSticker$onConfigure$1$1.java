package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.sticker.BaseSticker;
import com.discord.widgets.chat.list.entries.StickerEntry;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSticker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSticker$onConfigure$1$1 implements View$OnClickListener {
    public final /* synthetic */ BaseSticker $sticker;
    public final /* synthetic */ WidgetChatListAdapterItemSticker$onConfigure$1 this$0;

    public WidgetChatListAdapterItemSticker$onConfigure$1$1(WidgetChatListAdapterItemSticker$onConfigure$1 widgetChatListAdapterItemSticker$onConfigure$1, BaseSticker baseSticker) {
        this.this$0 = widgetChatListAdapterItemSticker$onConfigure$1;
        this.$sticker = baseSticker;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemSticker.access$getAdapter$p(this.this$0.this$0).onStickerClicked(((StickerEntry) this.this$0.$data).getMessage(), this.$sticker);
    }
}
