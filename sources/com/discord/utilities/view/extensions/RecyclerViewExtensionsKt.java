package com.discord.utilities.view.extensions;

import androidx.recyclerview.widget.RecyclerView;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RecyclerViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RecyclerViewExtensionsKt {
    public static final void ignoreCurrentTouch(RecyclerView recyclerView) {
        C12238m.checkNotNullParameter(recyclerView, "$this$ignoreCurrentTouch");
        recyclerView.suppressLayout(true);
        recyclerView.suppressLayout(false);
    }
}
