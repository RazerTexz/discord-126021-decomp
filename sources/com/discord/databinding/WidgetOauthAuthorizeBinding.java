package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetOauthAuthorizeBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2506b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final MaterialButton f;

    @NonNull
    public final MaterialButton g;

    @NonNull
    public final LinearLayout h;

    @NonNull
    public final MaterialButton i;

    @NonNull
    public final LinearLayout j;

    @NonNull
    public final TextView k;

    @NonNull
    public final RecyclerView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final MaterialButton n;

    @NonNull
    public final MaterialButton o;

    @NonNull
    public final SimpleDraweeView p;

    public WidgetOauthAuthorizeBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2, @NonNull MaterialCardView materialCardView, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull LinearLayout linearLayout2, @NonNull MaterialButton materialButton3, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout3, @NonNull TextView textView4, @NonNull RecyclerView recyclerView, @NonNull TextView textView5, @NonNull ImageView imageView3, @NonNull MaterialButton materialButton4, @NonNull MaterialButton materialButton5, @NonNull SimpleDraweeView simpleDraweeView2) {
        this.a = coordinatorLayout;
        this.f2506b = textView;
        this.c = simpleDraweeView;
        this.d = textView2;
        this.e = linearLayout;
        this.f = materialButton;
        this.g = materialButton2;
        this.h = linearLayout2;
        this.i = materialButton3;
        this.j = linearLayout3;
        this.k = textView4;
        this.l = recyclerView;
        this.m = textView5;
        this.n = materialButton4;
        this.o = materialButton5;
        this.p = simpleDraweeView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
