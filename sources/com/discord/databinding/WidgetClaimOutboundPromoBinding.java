package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetClaimOutboundPromoBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayoutCompat f16388a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16389b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16390c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LinearLayout f16391d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialButton f16392e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialButton f16393f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final AppViewFlipper f16394g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final MaterialButton f16395h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final MaterialButton f16396i;

    public WidgetClaimOutboundPromoBinding(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull LinearLayoutCompat linearLayoutCompat2, @NonNull MaterialButton materialButton2, @NonNull AppViewFlipper appViewFlipper, @NonNull FrameLayout frameLayout, @NonNull MaterialButton materialButton3, @NonNull MaterialButton materialButton4, @NonNull LinearLayoutCompat linearLayoutCompat3) {
        this.f16388a = linearLayoutCompat;
        this.f16389b = textView;
        this.f16390c = textView2;
        this.f16391d = linearLayout;
        this.f16392e = materialButton;
        this.f16393f = materialButton2;
        this.f16394g = appViewFlipper;
        this.f16395h = materialButton3;
        this.f16396i = materialButton4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16388a;
    }
}
