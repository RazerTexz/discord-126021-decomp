package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualGuildsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f18342a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f18343b;

    public WidgetUserMutualGuildsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView) {
        this.f18342a = coordinatorLayout;
        this.f18343b = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18342a;
    }
}
