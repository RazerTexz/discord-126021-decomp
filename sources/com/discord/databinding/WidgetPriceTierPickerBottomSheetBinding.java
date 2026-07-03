package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetPriceTierPickerBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17384a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final AppViewFlipper f17385b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f17386c;

    public WidgetPriceTierPickerBottomSheetBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull AppViewFlipper appViewFlipper, @NonNull RecyclerView recyclerView, @NonNull Toolbar toolbar) {
        this.f17384a = coordinatorLayout;
        this.f17385b = appViewFlipper;
        this.f17386c = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17384a;
    }
}
