package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StickerAdapterViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreHeaderViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ MGRecyclerDataPayload $data;
    public final /* synthetic */ StoreHeaderViewHolder this$0;

    public StoreHeaderViewHolder$onConfigure$1(StoreHeaderViewHolder storeHeaderViewHolder, MGRecyclerDataPayload mGRecyclerDataPayload) {
        this.this$0 = storeHeaderViewHolder;
        this.$data = mGRecyclerDataPayload;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function1<StoreHeaderItem, Unit> onStickerHeaderItemsClicked = StoreHeaderViewHolder.access$getAdapter$p(this.this$0).getOnStickerHeaderItemsClicked();
        if (onStickerHeaderItemsClicked != 0) {
        }
    }
}
