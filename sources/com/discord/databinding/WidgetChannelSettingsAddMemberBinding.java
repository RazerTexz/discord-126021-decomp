package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.SearchInputView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelSettingsAddMemberBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f2269b;

    @NonNull
    public final SearchInputView c;

    public WidgetChannelSettingsAddMemberBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView, @NonNull SearchInputView searchInputView) {
        this.a = coordinatorLayout;
        this.f2269b = recyclerView;
        this.c = searchInputView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
