package com.discord.widgets.chat.input.sticker;

import android.content.res.Resources;
import android.view.ViewGroup$LayoutParams;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetStickerPickerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPickerSheet$onViewCreated$2 implements Runnable {
    public final /* synthetic */ WidgetStickerPickerSheet this$0;

    public WidgetStickerPickerSheet$onViewCreated$2(WidgetStickerPickerSheet widgetStickerPickerSheet) {
        this.this$0 = widgetStickerPickerSheet;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup$LayoutParams layoutParams = WidgetStickerPickerSheet.access$getContainer$p(this.this$0).getLayoutParams();
        if (layoutParams != null) {
            Resources resources = this.this$0.getResources();
            m.checkNotNullExpressionValue(resources, "resources");
            layoutParams.height = (int) (((double) resources.getDisplayMetrics().heightPixels) * 0.9d);
        }
    }
}
