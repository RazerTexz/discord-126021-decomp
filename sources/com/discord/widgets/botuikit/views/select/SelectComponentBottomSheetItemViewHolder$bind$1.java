package com.discord.widgets.botuikit.views.select;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: SelectComponentBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentBottomSheetItemViewHolder$bind$1 implements View$OnClickListener {
    public final /* synthetic */ SelectComponentBottomSheetItem $data;
    public final /* synthetic */ SelectComponentBottomSheetItemViewHolder this$0;

    public SelectComponentBottomSheetItemViewHolder$bind$1(SelectComponentBottomSheetItemViewHolder selectComponentBottomSheetItemViewHolder, SelectComponentBottomSheetItem selectComponentBottomSheetItem) {
        this.this$0 = selectComponentBottomSheetItemViewHolder;
        this.$data = selectComponentBottomSheetItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SelectComponentBottomSheetItemViewHolder.access$getOnItemSelected$p(this.this$0).invoke(this.$data.getSelectItem(), Boolean.valueOf(!this.$data.getSelected()));
    }
}
