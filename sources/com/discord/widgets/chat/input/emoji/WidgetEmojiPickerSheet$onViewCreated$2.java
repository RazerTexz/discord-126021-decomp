package com.discord.widgets.chat.input.emoji;

import android.content.res.Resources;
import android.view.ViewGroup$LayoutParams;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetEmojiPickerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPickerSheet$onViewCreated$2 implements Runnable {
    public final /* synthetic */ WidgetEmojiPickerSheet this$0;

    public WidgetEmojiPickerSheet$onViewCreated$2(WidgetEmojiPickerSheet widgetEmojiPickerSheet) {
        this.this$0 = widgetEmojiPickerSheet;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup$LayoutParams layoutParams = WidgetEmojiPickerSheet.access$getContainer$p(this.this$0).getLayoutParams();
        if (layoutParams != null) {
            Resources resources = this.this$0.getResources();
            m.checkNotNullExpressionValue(resources, "resources");
            layoutParams.height = (int) (((double) resources.getDisplayMetrics().heightPixels) * 0.9d);
        }
    }
}
