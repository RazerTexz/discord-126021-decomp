package com.discord.widgets.botuikit.views.select;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentBottomSheet$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ SelectComponentBottomSheet this$0;

    public SelectComponentBottomSheet$configureUI$1(SelectComponentBottomSheet selectComponentBottomSheet) {
        this.this$0 = selectComponentBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SelectComponentBottomSheet.access$getViewModel$p(this.this$0).onClickSelect();
    }
}
