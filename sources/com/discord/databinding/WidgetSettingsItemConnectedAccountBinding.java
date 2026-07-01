package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsItemConnectedAccountBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2626b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final SwitchMaterial e;

    @NonNull
    public final SwitchMaterial f;

    @NonNull
    public final TextView g;

    @NonNull
    public final LinearLayout h;

    @NonNull
    public final SwitchMaterial i;

    public WidgetSettingsItemConnectedAccountBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull View view, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull SwitchMaterial switchMaterial, @NonNull SwitchMaterial switchMaterial2, @NonNull View view2, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView3, @NonNull SwitchMaterial switchMaterial3) {
        this.a = cardView;
        this.f2626b = imageView;
        this.c = imageView2;
        this.d = textView;
        this.e = switchMaterial;
        this.f = switchMaterial2;
        this.g = textView2;
        this.h = linearLayout;
        this.i = switchMaterial3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
