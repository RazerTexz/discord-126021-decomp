package com.discord.widgets.stickers;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetStickerPackDetailsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerPackDetailsDialog$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetStickerPackDetailsDialog this$0;

    public WidgetStickerPackDetailsDialog$onViewBound$1(WidgetStickerPackDetailsDialog widgetStickerPackDetailsDialog) {
        this.this$0 = widgetStickerPackDetailsDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
