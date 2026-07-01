package com.discord.widgets.chat.input;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChatInputAutocompleteStickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ AutocompleteStickerItem $data;
    public final /* synthetic */ StickerViewHolder this$0;

    public StickerViewHolder$onConfigure$1(StickerViewHolder stickerViewHolder, AutocompleteStickerItem autocompleteStickerItem) {
        this.this$0 = stickerViewHolder;
        this.$data = autocompleteStickerItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StickerViewHolder.access$getAdapter$p(this.this$0).getOnClickSticker().invoke(this.$data.getSticker());
    }
}
