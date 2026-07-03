package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class AnchoredVoiceControlsViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15007a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15008b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f15009c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f15010d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialButton f15011e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ImageView f15012f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final ImageView f15013g;

    public AnchoredVoiceControlsViewBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull MaterialButton materialButton, @NonNull ImageView imageView4, @NonNull ImageView imageView5) {
        this.f15007a = linearLayout;
        this.f15008b = imageView;
        this.f15009c = imageView2;
        this.f15010d = imageView3;
        this.f15011e = materialButton;
        this.f15012f = imageView4;
        this.f15013g = imageView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15007a;
    }
}
