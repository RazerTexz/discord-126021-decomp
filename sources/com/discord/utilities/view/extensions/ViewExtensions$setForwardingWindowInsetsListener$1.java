package com.discord.utilities.view.extensions;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import d0.z.d.m;
import java.util.Iterator;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewExtensions$setForwardingWindowInsetsListener$1 implements OnApplyWindowInsetsListener {
    public static final ViewExtensions$setForwardingWindowInsetsListener$1 INSTANCE = new ViewExtensions$setForwardingWindowInsetsListener$1();

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        m.checkNotNullParameter(view, "v");
        m.checkNotNullParameter(windowInsetsCompat, "insets");
        if (view instanceof ViewGroup) {
            Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
            while (it.hasNext()) {
                ViewCompat.dispatchApplyWindowInsets(it.next(), windowInsetsCompat);
            }
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
