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

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f2402b;

    @NonNull
    public final GifLoadingView c;

    @NonNull
    public final AppViewFlipper d;

    @NonNull
    public final SearchInputView e;

    public WidgetGifPickerSearchBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull RecyclerView recyclerView, @NonNull GifLoadingView gifLoadingView, @NonNull Toolbar toolbar, @NonNull AppViewFlipper appViewFlipper, @NonNull SearchInputView searchInputView) {
        this.a = coordinatorLayout;
        this.f2402b = recyclerView;
        this.c = gifLoadingView;
        this.d = appViewFlipper;
        this.e = searchInputView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
