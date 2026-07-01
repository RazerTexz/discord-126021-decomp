package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;

/* JADX INFO: compiled from: StickerAdapterViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerViewHolder$configureSticker$1 implements View$OnClickListener {
    public final /* synthetic */ MGRecyclerDataPayload $data;
    public final /* synthetic */ StickerViewHolder this$0;

    public StickerViewHolder$configureSticker$1(StickerViewHolder stickerViewHolder, MGRecyclerDataPayload mGRecyclerDataPayload) {
        this.this$0 = stickerViewHolder;
        this.$data = mGRecyclerDataPayload;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StickerViewHolder.access$getAdapter$p(this.this$0).getOnStickerItemSelected().invoke(this.$data);
        try {
            StickerViewHolder.access$getBinding$p(this.this$0).f2153b.performHapticFeedback(3);
        } catch (Throwable unused) {
        }
    }
}
