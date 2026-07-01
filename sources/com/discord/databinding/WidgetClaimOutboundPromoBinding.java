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

    @NonNull
    public final LinearLayoutCompat a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2350b;

    @NonNull
    public final TextView c;

    @NonNull
    public final LinearLayout d;

    @NonNull
    public final MaterialButton e;

    @NonNull
    public final MaterialButton f;

    @NonNull
    public final AppViewFlipper g;

    @NonNull
    public final MaterialButton h;

    @NonNull
    public final MaterialButton i;

    public WidgetClaimOutboundPromoBinding(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull LinearLayoutCompat linearLayoutCompat2, @NonNull MaterialButton materialButton2, @NonNull AppViewFlipper appViewFlipper, @NonNull FrameLayout frameLayout, @NonNull MaterialButton materialButton3, @NonNull MaterialButton materialButton4, @NonNull LinearLayoutCompat linearLayoutCompat3) {
        this.a = linearLayoutCompat;
        this.f2350b = textView;
        this.c = textView2;
        this.d = linearLayout;
        this.e = materialButton;
        this.f = materialButton2;
        this.g = appViewFlipper;
        this.h = materialButton3;
        this.i = materialButton4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
