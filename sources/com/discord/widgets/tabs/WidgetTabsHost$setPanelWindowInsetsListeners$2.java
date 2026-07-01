package com.discord.widgets.tabs;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Builder;
import d0.z.d.m;
import java.util.Iterator;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: WidgetTabsHost.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTabsHost$setPanelWindowInsetsListeners$2 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ boolean $isCallStatusVisible;

    public WidgetTabsHost$setPanelWindowInsetsListeners$2(boolean z2) {
        this.$isCallStatusVisible = z2;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        Sequence<View> children;
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(windowInsetsCompat, "insets");
        if (this.$isCallStatusVisible) {
            view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
        } else {
            view.setPadding(view.getPaddingLeft(), windowInsetsCompat.getSystemWindowInsetTop(), view.getPaddingRight(), view.getPaddingBottom());
            windowInsetsCompat = new WindowInsetsCompat$Builder().setSystemWindowInsets(Insets.of(windowInsetsCompat.getSystemWindowInsetLeft(), 0, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom())).build();
            m.checkNotNullExpressionValue(windowInsetsCompat, "WindowInsetsCompat.Build…      )\n        ).build()");
        }
        if (!(view instanceof ViewGroup)) {
            view = null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup != null && (children = ViewGroupKt.getChildren(viewGroup)) != null) {
            Iterator<View> it = children.iterator();
            while (it.hasNext()) {
                ViewCompat.dispatchApplyWindowInsets(it.next(), windowInsetsCompat);
            }
        }
        return windowInsetsCompat;
    }
}
