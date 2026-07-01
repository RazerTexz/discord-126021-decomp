package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class AnchoredVoiceControlsViewBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2088b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final MaterialButton e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final ImageView g;

    public AnchoredVoiceControlsViewBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull MaterialButton materialButton, @NonNull ImageView imageView4, @NonNull ImageView imageView5) {
        this.a = linearLayout;
        this.f2088b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = materialButton;
        this.f = imageView4;
        this.g = imageView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
