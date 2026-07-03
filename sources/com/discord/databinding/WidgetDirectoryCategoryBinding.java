package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetDirectoryCategoryBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RecyclerView f16459a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f16460b;

    public WidgetDirectoryCategoryBinding(@NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2) {
        this.f16459a = recyclerView;
        this.f16460b = recyclerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16459a;
    }
}
