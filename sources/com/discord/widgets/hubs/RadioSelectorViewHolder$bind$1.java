package com.discord.widgets.hubs;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RadioSelectorViewHolder$bind$1 implements View$OnClickListener {
    public final /* synthetic */ RadioSelectorItem $data;
    public final /* synthetic */ RadioSelectorViewHolder this$0;

    public RadioSelectorViewHolder$bind$1(RadioSelectorViewHolder radioSelectorViewHolder, RadioSelectorItem radioSelectorItem) {
        this.this$0 = radioSelectorViewHolder;
        this.$data = radioSelectorItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.getOnSelected().invoke(Integer.valueOf(this.$data.getId()));
    }
}
