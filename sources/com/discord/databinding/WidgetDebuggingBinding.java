package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetDebuggingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f16449a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f16450b;

    public WidgetDebuggingBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView) {
        this.f16449a = coordinatorLayout;
        this.f16450b = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16449a;
    }
}
