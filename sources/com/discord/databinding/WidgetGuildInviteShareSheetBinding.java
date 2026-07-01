package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.views.SearchInputView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildInviteShareSheetBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f2422b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final ImageButton e;

    @NonNull
    public final NestedScrollView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final MaterialButton h;

    @NonNull
    public final FrameLayout i;

    @NonNull
    public final FrameLayout j;

    @NonNull
    public final SearchInputView k;

    @NonNull
    public final CardView l;

    @NonNull
    public final RecyclerView m;

    @NonNull
    public final AppViewFlipper n;

    public WidgetGuildInviteShareSheetBinding(@NonNull FrameLayout frameLayout, @NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout2, @NonNull Barrier barrier, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView, @NonNull TextView textView4, @NonNull ImageButton imageButton, @NonNull NestedScrollView nestedScrollView, @NonNull TextView textView5, @NonNull MaterialButton materialButton, @NonNull TextView textView6, @NonNull FrameLayout frameLayout3, @NonNull TextView textView7, @NonNull Barrier barrier2, @NonNull FrameLayout frameLayout4, @NonNull Barrier barrier3, @NonNull SearchInputView searchInputView, @NonNull CardView cardView, @NonNull RecyclerView recyclerView, @NonNull AppViewFlipper appViewFlipper) {
        this.a = frameLayout;
        this.f2422b = constraintLayout;
        this.c = textView;
        this.d = textView4;
        this.e = imageButton;
        this.f = nestedScrollView;
        this.g = textView5;
        this.h = materialButton;
        this.i = frameLayout3;
        this.j = frameLayout4;
        this.k = searchInputView;
        this.l = cardView;
        this.m = recyclerView;
        this.n = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
