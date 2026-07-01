package com.discord.utilities.view.extensions;

import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.m;

/* JADX INFO: compiled from: RecyclerViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RecyclerViewExtensionsKt {
    public static final void ignoreCurrentTouch(RecyclerView recyclerView) {
        m.checkNotNullParameter(recyclerView, "$this$ignoreCurrentTouch");
        recyclerView.suppressLayout(true);
        recyclerView.suppressLayout(false);
    }
}
