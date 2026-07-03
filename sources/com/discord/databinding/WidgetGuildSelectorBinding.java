package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f17050a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f17051b;

    public WidgetGuildSelectorBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull RecyclerView recyclerView) {
        this.f17050a = nestedScrollView;
        this.f17051b = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17050a;
    }
}
