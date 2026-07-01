package com.discord.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import b.a.i.a3;
import b.a.i.a6;
import b.a.i.b3;
import b.a.i.f0;
import b.a.i.s0;
import b.a.i.z2;
import com.discord.app.AppViewFlipper;
import com.discord.views.ActiveSubscriptionView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsPremiumBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final f0 f2633b;

    @NonNull
    public final s0 c;

    @NonNull
    public final z2 d;

    @NonNull
    public final ActiveSubscriptionView e;

    @NonNull
    public final ActiveSubscriptionView f;

    @NonNull
    public final LinearLayout g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final a6 k;

    @NonNull
    public final MaterialButton l;

    @NonNull
    public final ScrollView m;

    @NonNull
    public final Button n;

    @NonNull
    public final CardView o;

    @NonNull
    public final TextView p;

    @NonNull
    public final LinearLayout q;

    @NonNull
    public final TextView r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final AppViewFlipper f2634s;

    @NonNull
    public final a3 t;

    @NonNull
    public final b3 u;

    public WidgetSettingsPremiumBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull f0 f0Var, @NonNull s0 s0Var, @NonNull z2 z2Var, @NonNull ActiveSubscriptionView activeSubscriptionView, @NonNull ActiveSubscriptionView activeSubscriptionView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull a6 a6Var, @NonNull MaterialButton materialButton, @NonNull ScrollView scrollView, @NonNull Button button, @NonNull CardView cardView, @NonNull TextView textView4, @NonNull LinearLayout linearLayout2, @NonNull TextView textView5, @NonNull AppViewFlipper appViewFlipper, @NonNull a3 a3Var, @NonNull b3 b3Var) {
        this.a = coordinatorLayout;
        this.f2633b = f0Var;
        this.c = s0Var;
        this.d = z2Var;
        this.e = activeSubscriptionView;
        this.f = activeSubscriptionView2;
        this.g = linearLayout;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = a6Var;
        this.l = materialButton;
        this.m = scrollView;
        this.n = button;
        this.o = cardView;
        this.p = textView4;
        this.q = linearLayout2;
        this.r = textView5;
        this.f2634s = appViewFlipper;
        this.t = a3Var;
        this.u = b3Var;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
