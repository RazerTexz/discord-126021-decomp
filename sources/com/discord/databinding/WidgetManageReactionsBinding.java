package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetManageReactionsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17215a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f17216b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f17217c;

    public WidgetManageReactionsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2) {
        this.f17215a = coordinatorLayout;
        this.f17216b = recyclerView;
        this.f17217c = recyclerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17215a;
    }
}
