package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelPinnedMessagesBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f15887a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f15888b;

    public WidgetChannelPinnedMessagesBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView) {
        this.f15887a = coordinatorLayout;
        this.f15888b = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15887a;
    }
}
