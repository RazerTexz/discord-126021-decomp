package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.view.View$OnLayoutChangeListener;
import d0.z.d.m;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker$scrollToTop$$inlined$doOnLayout$1 implements View$OnLayoutChangeListener {
    public final /* synthetic */ WidgetStickerPicker this$0;

    public WidgetStickerPicker$scrollToTop$$inlined$doOnLayout$1(WidgetStickerPicker widgetStickerPicker) {
        this.this$0 = widgetStickerPicker;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        m.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        WidgetStickerPicker.access$getBinding$p(this.this$0).k.scrollToPosition(0);
    }
}
