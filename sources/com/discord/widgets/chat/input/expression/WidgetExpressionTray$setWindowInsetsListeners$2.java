package com.discord.widgets.chat.input.expression;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: compiled from: WidgetExpressionTray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetExpressionTray$setWindowInsetsListeners$2 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ WidgetExpressionTray this$0;

    public WidgetExpressionTray$setWindowInsetsListeners$2(WidgetExpressionTray widgetExpressionTray) {
        this.this$0 = widgetExpressionTray;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return ViewCompat.dispatchApplyWindowInsets(WidgetExpressionTray.access$getBinding$p(this.this$0).c, windowInsetsCompat);
    }
}
