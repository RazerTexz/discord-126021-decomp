package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.textfield.TextInputEditText;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetEmojiPickerBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f2376b;

    @NonNull
    public final AppViewFlipper c;

    @NonNull
    public final AppBarLayout d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final ConstraintLayout g;

    @NonNull
    public final View h;

    @NonNull
    public final RecyclerView i;

    @NonNull
    public final CoordinatorLayout j;

    @NonNull
    public final ImageView k;

    @NonNull
    public final ImageView l;

    @NonNull
    public final TextInputEditText m;

    @NonNull
    public final Toolbar n;

    public WidgetEmojiPickerBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView, @NonNull AppViewFlipper appViewFlipper, @NonNull AppBarLayout appBarLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull Barrier barrier, @NonNull RecyclerView recyclerView2, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull ImageView imageView2, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView3, @NonNull TextInputEditText textInputEditText, @NonNull Toolbar toolbar) {
        this.a = coordinatorLayout;
        this.f2376b = recyclerView;
        this.c = appViewFlipper;
        this.d = appBarLayout;
        this.e = textView;
        this.f = imageView;
        this.g = constraintLayout;
        this.h = view;
        this.i = recyclerView2;
        this.j = coordinatorLayout2;
        this.k = imageView2;
        this.l = imageView3;
        this.m = textInputEditText;
        this.n = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
