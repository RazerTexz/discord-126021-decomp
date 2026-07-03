package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f15891a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f15892b;

    public WidgetChannelSelectorBinding(@NonNull NestedScrollView nestedScrollView, @NonNull RecyclerView recyclerView, @NonNull TextView textView) {
        this.f15891a = nestedScrollView;
        this.f15892b = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15891a;
    }
}
