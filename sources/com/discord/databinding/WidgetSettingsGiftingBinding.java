package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.premium.GiftSelectView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsGiftingBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final DimmerView f2620b;

    @NonNull
    public final GiftSelectView c;

    @NonNull
    public final GiftSelectView d;

    @NonNull
    public final GiftSelectView e;

    @NonNull
    public final GiftSelectView f;

    @NonNull
    public final LinkifiedTextView g;

    @NonNull
    public final LinkifiedTextView h;

    @NonNull
    public final AppViewFlipper i;

    @NonNull
    public final ProgressBar j;

    @NonNull
    public final TextInputLayout k;

    @NonNull
    public final TextView l;

    @NonNull
    public final RecyclerView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final MaterialButton o;

    @NonNull
    public final TextView p;

    @NonNull
    public final TextView q;

    @NonNull
    public final TextView r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final RecyclerView f2621s;

    public WidgetSettingsGiftingBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DimmerView dimmerView, @NonNull GiftSelectView giftSelectView, @NonNull GiftSelectView giftSelectView2, @NonNull GiftSelectView giftSelectView3, @NonNull GiftSelectView giftSelectView4, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LinkifiedTextView linkifiedTextView2, @NonNull AppViewFlipper appViewFlipper, @NonNull ProgressBar progressBar, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull MaterialButton materialButton, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull RecyclerView recyclerView2) {
        this.a = coordinatorLayout;
        this.f2620b = dimmerView;
        this.c = giftSelectView;
        this.d = giftSelectView2;
        this.e = giftSelectView3;
        this.f = giftSelectView4;
        this.g = linkifiedTextView;
        this.h = linkifiedTextView2;
        this.i = appViewFlipper;
        this.j = progressBar;
        this.k = textInputLayout;
        this.l = textView;
        this.m = recyclerView;
        this.n = textView2;
        this.o = materialButton;
        this.p = textView3;
        this.q = textView4;
        this.r = textView5;
        this.f2621s = recyclerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
