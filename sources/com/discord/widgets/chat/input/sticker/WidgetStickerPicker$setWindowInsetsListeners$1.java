package com.discord.widgets.chat.input.sticker;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker$setWindowInsetsListeners$1 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ WidgetStickerPicker this$0;

    public WidgetStickerPicker$setWindowInsetsListeners$1(WidgetStickerPicker widgetStickerPicker) {
        this.this$0 = widgetStickerPicker;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        m.checkNotNullExpressionValue(view, "view");
        m.checkNotNullExpressionValue(windowInsetsCompat, "insets");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), WidgetStickerPicker.access$getAdditionalBottomPaddingPx(this.this$0) + windowInsetsCompat.getSystemWindowInsetBottom());
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
