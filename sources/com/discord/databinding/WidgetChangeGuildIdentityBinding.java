package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.premium.ShinyButton;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChangeGuildIdentityBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f15803a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final DimmerView f15804b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ShinyButton f15805c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f15806d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final RelativeLayout f15807e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final FloatingActionButton f15808f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextInputLayout f15809g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final LinearLayout f15810h;

    public WidgetChangeGuildIdentityBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull CardView cardView, @NonNull DimmerView dimmerView, @NonNull ShinyButton shinyButton, @NonNull SimpleDraweeView simpleDraweeView, @NonNull CardView cardView2, @NonNull RelativeLayout relativeLayout, @NonNull CardView cardView3, @NonNull FloatingActionButton floatingActionButton, @NonNull TextInputLayout textInputLayout, @NonNull LinearLayout linearLayout) {
        this.f15803a = coordinatorLayout;
        this.f15804b = dimmerView;
        this.f15805c = shinyButton;
        this.f15806d = simpleDraweeView;
        this.f15807e = relativeLayout;
        this.f15808f = floatingActionButton;
        this.f15809g = textInputLayout;
        this.f15810h = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15803a;
    }
}
