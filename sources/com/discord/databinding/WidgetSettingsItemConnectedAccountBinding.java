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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f17983a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f17984b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f17985c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17986d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SwitchMaterial f17987e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final SwitchMaterial f17988f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f17989g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final LinearLayout f17990h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final SwitchMaterial f17991i;

    public WidgetSettingsItemConnectedAccountBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull View view, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull SwitchMaterial switchMaterial, @NonNull SwitchMaterial switchMaterial2, @NonNull View view2, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView3, @NonNull SwitchMaterial switchMaterial3) {
        this.f17983a = cardView;
        this.f17984b = imageView;
        this.f17985c = imageView2;
        this.f17986d = textView;
        this.f17987e = switchMaterial;
        this.f17988f = switchMaterial2;
        this.f17989g = textView2;
        this.f17990h = linearLayout;
        this.f17991i = switchMaterial3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17983a;
    }
}
