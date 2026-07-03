package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualFriendsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f18340a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f18341b;

    public WidgetUserMutualFriendsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView) {
        this.f18340a = coordinatorLayout;
        this.f18341b = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18340a;
    }
}
