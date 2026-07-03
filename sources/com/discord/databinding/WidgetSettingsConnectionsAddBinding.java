package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsConnectionsAddBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f17930a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f17931b;

    public WidgetSettingsConnectionsAddBinding(@NonNull NestedScrollView nestedScrollView, @NonNull RecyclerView recyclerView) {
        this.f17930a = nestedScrollView;
        this.f17931b = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17930a;
    }
}
