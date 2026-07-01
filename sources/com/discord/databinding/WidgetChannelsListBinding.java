package com.discord.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.rounded.RoundedCoordinatorLayout;
import com.discord.views.CustomAppBarLayout;
import com.discord.widgets.friends.EmptyFriendsStateView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelsListBinding implements ViewBinding {

    @NonNull
    public final RoundedCoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CustomAppBarLayout f2282b;

    @NonNull
    public final RecyclerView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final FrameLayout e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final ConstraintLayout h;

    @NonNull
    public final MaterialButton i;

    @NonNull
    public final Toolbar j;

    @NonNull
    public final TextView k;

    @NonNull
    public final AppCompatImageView l;

    @NonNull
    public final ViewStub m;

    @NonNull
    public final CollapsingToolbarLayout n;

    @NonNull
    public final RoundedCoordinatorLayout o;

    @NonNull
    public final EmptyFriendsStateView p;

    public WidgetChannelsListBinding(@NonNull RoundedCoordinatorLayout roundedCoordinatorLayout, @NonNull CustomAppBarLayout customAppBarLayout, @NonNull RecyclerView recyclerView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull Toolbar toolbar, @NonNull TextView textView5, @NonNull AppCompatImageView appCompatImageView, @NonNull View view, @NonNull View view2, @NonNull ViewStub viewStub, @NonNull Toolbar toolbar2, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull RoundedCoordinatorLayout roundedCoordinatorLayout2, @NonNull EmptyFriendsStateView emptyFriendsStateView) {
        this.a = roundedCoordinatorLayout;
        this.f2282b = customAppBarLayout;
        this.c = recyclerView;
        this.d = simpleDraweeView;
        this.e = frameLayout;
        this.f = textView;
        this.g = textView2;
        this.h = constraintLayout;
        this.i = materialButton;
        this.j = toolbar;
        this.k = textView5;
        this.l = appCompatImageView;
        this.m = viewStub;
        this.n = collapsingToolbarLayout;
        this.o = roundedCoordinatorLayout2;
        this.p = emptyFriendsStateView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
