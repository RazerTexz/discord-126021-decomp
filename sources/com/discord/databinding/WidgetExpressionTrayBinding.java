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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f16602a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final FrameLayout f16603b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FrameLayout f16604c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final FragmentContainerView f16605d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final FragmentContainerView f16606e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final CardSegment f16607f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final FragmentContainerView f16608g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final ContentResizingCoordinatorLayout f16609h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final RoundedRelativeLayout f16610i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final TextView f16611j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final SegmentedControlContainer f16612k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final CardSegment f16613l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final FragmentContainerView f16614m;

    /* JADX INFO: renamed from: n */
    @NonNull
    public final AppBarLayout f16615n;

    public WidgetExpressionTrayBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull FragmentContainerView fragmentContainerView, @NonNull CardSegment cardSegment, @NonNull FragmentContainerView fragmentContainerView2, @NonNull CardSegment cardSegment2, @NonNull FragmentContainerView fragmentContainerView3, @NonNull ContentResizingCoordinatorLayout contentResizingCoordinatorLayout, @NonNull RoundedRelativeLayout roundedRelativeLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull SegmentedControlContainer segmentedControlContainer, @NonNull CardSegment cardSegment3, @NonNull FragmentContainerView fragmentContainerView4, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull AppBarLayout appBarLayout) {
        this.f16602a = frameLayout;
        this.f16603b = frameLayout2;
        this.f16604c = frameLayout3;
        this.f16605d = fragmentContainerView;
        this.f16606e = fragmentContainerView2;
        this.f16607f = cardSegment2;
        this.f16608g = fragmentContainerView3;
        this.f16609h = contentResizingCoordinatorLayout;
        this.f16610i = roundedRelativeLayout;
        this.f16611j = textView;
        this.f16612k = segmentedControlContainer;
        this.f16613l = cardSegment3;
        this.f16614m = fragmentContainerView4;
        this.f16615n = appBarLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16602a;
    }
}
