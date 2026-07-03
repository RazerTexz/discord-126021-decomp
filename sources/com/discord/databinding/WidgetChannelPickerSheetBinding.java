package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.views.SearchInputView;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelPickerSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f15883a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final AppViewFlipper f15884b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f15885c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SearchInputView f15886d;

    public WidgetChannelPickerSheetBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull AppViewFlipper appViewFlipper, @NonNull RecyclerView recyclerView, @NonNull SearchInputView searchInputView, @NonNull Toolbar toolbar) {
        this.f15883a = coordinatorLayout;
        this.f15884b = appViewFlipper;
        this.f15885c = recyclerView;
        this.f15886d = searchInputView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15883a;
    }
}
