package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.views.ContentResizingCoordinatorLayout;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetExpressionTrayBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f2383b;

    @NonNull
    public final FrameLayout c;

    @NonNull
    public final FragmentContainerView d;

    @NonNull
    public final FragmentContainerView e;

    @NonNull
    public final CardSegment f;

    @NonNull
    public final FragmentContainerView g;

    @NonNull
    public final ContentResizingCoordinatorLayout h;

    @NonNull
    public final RoundedRelativeLayout i;

    @NonNull
    public final TextView j;

    @NonNull
    public final SegmentedControlContainer k;

    @NonNull
    public final CardSegment l;

    @NonNull
    public final FragmentContainerView m;

    @NonNull
    public final AppBarLayout n;

    public WidgetExpressionTrayBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull FragmentContainerView fragmentContainerView, @NonNull CardSegment cardSegment, @NonNull FragmentContainerView fragmentContainerView2, @NonNull CardSegment cardSegment2, @NonNull FragmentContainerView fragmentContainerView3, @NonNull ContentResizingCoordinatorLayout contentResizingCoordinatorLayout, @NonNull RoundedRelativeLayout roundedRelativeLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull SegmentedControlContainer segmentedControlContainer, @NonNull CardSegment cardSegment3, @NonNull FragmentContainerView fragmentContainerView4, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull AppBarLayout appBarLayout) {
        this.a = frameLayout;
        this.f2383b = frameLayout2;
        this.c = frameLayout3;
        this.d = fragmentContainerView;
        this.e = fragmentContainerView2;
        this.f = cardSegment2;
        this.g = fragmentContainerView3;
        this.h = contentResizingCoordinatorLayout;
        this.i = roundedRelativeLayout;
        this.j = textView;
        this.k = segmentedControlContainer;
        this.l = cardSegment3;
        this.m = fragmentContainerView4;
        this.n = appBarLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
