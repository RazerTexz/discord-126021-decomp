package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class StickerPremiumUpsellDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f15277a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15278b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15279c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f15280d;

    public StickerPremiumUpsellDialogBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull MaterialButton materialButton) {
        this.f15277a = relativeLayout;
        this.f15278b = textView;
        this.f15279c = textView2;
        this.f15280d = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15277a;
    }
}
