package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.views.SearchInputView;
import com.discord.views.sticker.StickerView;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerPickerBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2661b;

    @NonNull
    public final LinkifiedTextView c;

    @NonNull
    public final StickerView d;

    @NonNull
    public final StickerView e;

    @NonNull
    public final StickerView f;

    @NonNull
    public final StickerView g;

    @NonNull
    public final LoadingButton h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final RecyclerView k;

    @NonNull
    public final AppViewFlipper l;

    @NonNull
    public final AppBarLayout m;

    @NonNull
    public final ConstraintLayout n;

    @NonNull
    public final View o;

    @NonNull
    public final RecyclerView p;

    @NonNull
    public final CoordinatorLayout q;

    @NonNull
    public final SearchInputView r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final Toolbar f2662s;

    public WidgetStickerPickerBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull StickerView stickerView, @NonNull StickerView stickerView2, @NonNull StickerView stickerView3, @NonNull StickerView stickerView4, @NonNull LoadingButton loadingButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull RecyclerView recyclerView, @NonNull AppViewFlipper appViewFlipper, @NonNull AppBarLayout appBarLayout, @NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull RecyclerView recyclerView2, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull SearchInputView searchInputView, @NonNull Toolbar toolbar) {
        this.a = coordinatorLayout;
        this.f2661b = imageView;
        this.c = linkifiedTextView;
        this.d = stickerView;
        this.e = stickerView2;
        this.f = stickerView3;
        this.g = stickerView4;
        this.h = loadingButton;
        this.i = textView;
        this.j = textView3;
        this.k = recyclerView;
        this.l = appViewFlipper;
        this.m = appBarLayout;
        this.n = constraintLayout;
        this.o = view;
        this.p = recyclerView2;
        this.q = coordinatorLayout2;
        this.r = searchInputView;
        this.f2662s = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
