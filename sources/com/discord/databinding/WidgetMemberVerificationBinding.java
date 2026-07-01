package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CustomAppBarLayout;
import com.discord.views.LoadingButton;
import com.discord.views.MemberVerificationAvatarView;
import com.discord.widgets.servers.member_verification.MemberVerificationView;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetMemberVerificationBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final DimmerView f2488b;

    @NonNull
    public final MemberVerificationView c;

    @NonNull
    public final MemberVerificationAvatarView d;

    @NonNull
    public final LoadingButton e;

    @NonNull
    public final RecyclerView f;

    @NonNull
    public final NestedScrollView g;

    public WidgetMemberVerificationBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CustomAppBarLayout customAppBarLayout, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull DimmerView dimmerView, @NonNull MemberVerificationView memberVerificationView, @NonNull MemberVerificationAvatarView memberVerificationAvatarView, @NonNull LoadingButton loadingButton, @NonNull RecyclerView recyclerView, @NonNull NestedScrollView nestedScrollView) {
        this.a = coordinatorLayout;
        this.f2488b = dimmerView;
        this.c = memberVerificationView;
        this.d = memberVerificationAvatarView;
        this.e = loadingButton;
        this.f = recyclerView;
        this.g = nestedScrollView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
