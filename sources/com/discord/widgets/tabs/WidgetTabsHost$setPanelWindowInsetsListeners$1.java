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
public final class WidgetTabsHost$setPanelWindowInsetsListeners$1 implements OnApplyWindowInsetsListener {
    public static final WidgetTabsHost$setPanelWindowInsetsListeners$1 INSTANCE = new WidgetTabsHost$setPanelWindowInsetsListeners$1();

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        Sequence<View> children;
        m.checkNotNullParameter(view, "v");
        m.checkNotNullParameter(windowInsetsCompat, "insets");
        view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), view.getPaddingTop(), windowInsetsCompat.getSystemWindowInsetRight(), view.getPaddingBottom());
        WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat$Builder().setSystemWindowInsets(Insets.of(0, windowInsetsCompat.getSystemWindowInsetTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom())).build();
        m.checkNotNullExpressionValue(windowInsetsCompatBuild, "WindowInsetsCompat.Build…        )\n      ).build()");
        if (!(view instanceof ViewGroup)) {
            view = null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup != null && (children = ViewGroupKt.getChildren(viewGroup)) != null) {
            Iterator<View> it = children.iterator();
            while (it.hasNext()) {
                ViewCompat.dispatchApplyWindowInsets(it.next(), windowInsetsCompatBuild);
            }
        }
        return windowInsetsCompatBuild;
    }
}
