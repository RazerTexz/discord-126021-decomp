package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.views.SearchInputView;
import com.discord.widgets.chat.input.gifpicker.GifLoadingView;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGifPickerSearchBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f16702a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f16703b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final GifLoadingView f16704c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final AppViewFlipper f16705d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SearchInputView f16706e;

    public WidgetGifPickerSearchBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull RecyclerView recyclerView, @NonNull GifLoadingView gifLoadingView, @NonNull Toolbar toolbar, @NonNull AppViewFlipper appViewFlipper, @NonNull SearchInputView searchInputView) {
        this.f16702a = coordinatorLayout;
        this.f16703b = recyclerView;
        this.f16704c = gifLoadingView;
        this.f16705d = appViewFlipper;
        this.f16706e = searchInputView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16702a;
    }
}
