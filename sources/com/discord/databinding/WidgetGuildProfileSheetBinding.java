package com.discord.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildProfileSheetBinding implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f2431b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final ConstraintLayout d;

    @NonNull
    public final View e;

    @NonNull
    public final TextView f;

    @NonNull
    public final AppViewFlipper g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final SimpleDraweeView i;

    @NonNull
    public final CardView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final MaterialButton l;

    @NonNull
    public final LinearLayout m;

    @NonNull
    public final TextView n;

    @NonNull
    public final TextView o;

    @NonNull
    public final MaterialButton p;

    @NonNull
    public final LinearLayout q;

    @NonNull
    public final TextView r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2432s;

    @NonNull
    public final LinearLayout t;

    @NonNull
    public final ViewStub u;

    @NonNull
    public final ViewStub v;

    public WidgetGuildProfileSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull Barrier barrier, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialButton materialButton, @NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull View view, @NonNull TextView textView, @NonNull AppViewFlipper appViewFlipper, @NonNull ImageView imageView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull CardView cardView, @NonNull TextView textView2, @NonNull MaterialButton materialButton2, @NonNull LinearLayout linearLayout2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull MaterialButton materialButton3, @NonNull LinearLayout linearLayout3, @NonNull TextView textView5, @NonNull MaterialButton materialButton4, @NonNull LinearLayout linearLayout4, @NonNull ViewStub viewStub, @NonNull ViewStub viewStub2) {
        this.a = nestedScrollView;
        this.f2431b = simpleDraweeView;
        this.c = materialButton;
        this.d = constraintLayout;
        this.e = view;
        this.f = textView;
        this.g = appViewFlipper;
        this.h = imageView;
        this.i = simpleDraweeView2;
        this.j = cardView;
        this.k = textView2;
        this.l = materialButton2;
        this.m = linearLayout2;
        this.n = textView3;
        this.o = textView4;
        this.p = materialButton3;
        this.q = linearLayout3;
        this.r = textView5;
        this.f2432s = materialButton4;
        this.t = linearLayout4;
        this.u = viewStub;
        this.v = viewStub2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
