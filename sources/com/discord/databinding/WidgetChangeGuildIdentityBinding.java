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

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final DimmerView f2252b;

    @NonNull
    public final ShinyButton c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final RelativeLayout e;

    @NonNull
    public final FloatingActionButton f;

    @NonNull
    public final TextInputLayout g;

    @NonNull
    public final LinearLayout h;

    public WidgetChangeGuildIdentityBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull CardView cardView, @NonNull DimmerView dimmerView, @NonNull ShinyButton shinyButton, @NonNull SimpleDraweeView simpleDraweeView, @NonNull CardView cardView2, @NonNull RelativeLayout relativeLayout, @NonNull CardView cardView3, @NonNull FloatingActionButton floatingActionButton, @NonNull TextInputLayout textInputLayout, @NonNull LinearLayout linearLayout) {
        this.a = coordinatorLayout;
        this.f2252b = dimmerView;
        this.c = shinyButton;
        this.d = simpleDraweeView;
        this.e = relativeLayout;
        this.f = floatingActionButton;
        this.g = textInputLayout;
        this.h = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
