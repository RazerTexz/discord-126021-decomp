package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.SearchInputView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelSettingsAddMemberBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f15895a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f15896b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SearchInputView f15897c;

    public WidgetChannelSettingsAddMemberBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView, @NonNull SearchInputView searchInputView) {
        this.f15895a = coordinatorLayout;
        this.f15896b = recyclerView;
        this.f15897c = searchInputView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15895a;
    }
}
