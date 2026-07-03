package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class PremiumStickerUpsellDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f15213a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15214b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f15215c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15216d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15217e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialButton f15218f;

    public PremiumStickerUpsellDialogBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull MaterialButton materialButton) {
        this.f15213a = relativeLayout;
        this.f15214b = textView;
        this.f15215c = imageView;
        this.f15216d = textView2;
        this.f15217e = textView3;
        this.f15218f = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15213a;
    }
}
