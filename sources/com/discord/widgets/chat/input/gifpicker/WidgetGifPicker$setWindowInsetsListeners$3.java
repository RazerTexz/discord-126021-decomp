package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: compiled from: WidgetGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifPicker$setWindowInsetsListeners$3 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ WidgetGifPicker this$0;

    public WidgetGifPicker$setWindowInsetsListeners$3(WidgetGifPicker widgetGifPicker) {
        this.this$0 = widgetGifPicker;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        ViewCompat.dispatchApplyWindowInsets(WidgetGifPicker.access$getBinding$p(this.this$0).f2401b, windowInsetsCompat);
        ViewCompat.dispatchApplyWindowInsets(WidgetGifPicker.access$getBinding$p(this.this$0).d, windowInsetsCompat);
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
