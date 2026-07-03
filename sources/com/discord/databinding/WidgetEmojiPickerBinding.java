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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f16551a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f16552b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final AppViewFlipper f16553c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final AppBarLayout f16554d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16555e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ImageView f16556f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final ConstraintLayout f16557g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final View f16558h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final RecyclerView f16559i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final CoordinatorLayout f16560j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final ImageView f16561k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final ImageView f16562l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final TextInputEditText f16563m;

    /* JADX INFO: renamed from: n */
    @NonNull
    public final Toolbar f16564n;

    public WidgetEmojiPickerBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView, @NonNull AppViewFlipper appViewFlipper, @NonNull AppBarLayout appBarLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull Barrier barrier, @NonNull RecyclerView recyclerView2, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull ImageView imageView2, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView3, @NonNull TextInputEditText textInputEditText, @NonNull Toolbar toolbar) {
        this.f16551a = coordinatorLayout;
        this.f16552b = recyclerView;
        this.f16553c = appViewFlipper;
        this.f16554d = appBarLayout;
        this.f16555e = textView;
        this.f16556f = imageView;
        this.f16557g = constraintLayout;
        this.f16558h = view;
        this.f16559i = recyclerView2;
        this.f16560j = coordinatorLayout2;
        this.f16561k = imageView2;
        this.f16562l = imageView3;
        this.f16563m = textInputEditText;
        this.f16564n = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16551a;
    }
}
