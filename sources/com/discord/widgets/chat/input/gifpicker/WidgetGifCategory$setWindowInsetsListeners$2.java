package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: compiled from: WidgetGifCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifCategory$setWindowInsetsListeners$2 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ WidgetGifCategory this$0;

    public WidgetGifCategory$setWindowInsetsListeners$2(WidgetGifCategory widgetGifCategory) {
        this.this$0 = widgetGifCategory;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        ViewCompat.dispatchApplyWindowInsets(WidgetGifCategory.access$getBinding$p(this.this$0).c, windowInsetsCompat);
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
