package com.discord.utilities.view.extensions;

import android.widget.ScrollView;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ScrollViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ScrollViewExtensionsKt {
    public static final void flashScrollBars(ScrollView scrollView) {
        C12238m.checkNotNullParameter(scrollView, "$this$flashScrollBars");
        scrollView.scrollBy(0, 1);
        scrollView.scrollBy(0, -1);
    }
}
