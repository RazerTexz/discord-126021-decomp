package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSearchResultsBinding implements ViewBinding {

    @NonNull
    public final RecyclerView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f2523b;

    public WidgetSearchResultsBinding(@NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2) {
        this.a = recyclerView;
        this.f2523b = recyclerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
