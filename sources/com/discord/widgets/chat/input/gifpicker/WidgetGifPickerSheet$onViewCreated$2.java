package com.discord.widgets.chat.input.gifpicker;

import android.content.res.Resources;
import android.view.ViewGroup$LayoutParams;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGifPickerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifPickerSheet$onViewCreated$2 implements Runnable {
    public final /* synthetic */ WidgetGifPickerSheet this$0;

    public WidgetGifPickerSheet$onViewCreated$2(WidgetGifPickerSheet widgetGifPickerSheet) {
        this.this$0 = widgetGifPickerSheet;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup$LayoutParams layoutParams = WidgetGifPickerSheet.access$getContainer$p(this.this$0).getLayoutParams();
        if (layoutParams != null) {
            Resources resources = this.this$0.getResources();
            m.checkNotNullExpressionValue(resources, "resources");
            layoutParams.height = (int) (((double) resources.getDisplayMetrics().heightPixels) * 0.9d);
        }
    }
}
