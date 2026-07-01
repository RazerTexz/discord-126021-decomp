package com.discord.utilities.view.extensions;

import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.view.extensions.RecyclerViewExtensionsKt, reason: use source file name */
/* JADX INFO: compiled from: RecyclerViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RecyclerViewExtensions {
    public static final void ignoreCurrentTouch(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "$this$ignoreCurrentTouch");
        recyclerView.suppressLayout(true);
        recyclerView.suppressLayout(false);
    }
}
