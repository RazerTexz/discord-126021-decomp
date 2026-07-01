package com.discord.widgets.chat.input.sticker;

import androidx.recyclerview.widget.RecyclerView$RecyclerListener;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker$setUpStickerRecycler$3 implements RecyclerView$RecyclerListener {
    public static final WidgetStickerPicker$setUpStickerRecycler$3 INSTANCE = new WidgetStickerPicker$setUpStickerRecycler$3();

    @Override // androidx.recyclerview.widget.RecyclerView$RecyclerListener
    public final void onViewRecycled(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        m.checkNotNullParameter(recyclerView$ViewHolder, "viewHolder");
        if (recyclerView$ViewHolder instanceof StickerViewHolder) {
            ((StickerViewHolder) recyclerView$ViewHolder).cancelLoading();
        }
    }
}
