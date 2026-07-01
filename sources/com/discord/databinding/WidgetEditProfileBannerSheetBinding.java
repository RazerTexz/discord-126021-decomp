package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetEditProfileBannerSheetBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f2369b;

    @NonNull
    public final MaterialTextView c;

    @NonNull
    public final ConstraintLayout d;

    @NonNull
    public final MaterialTextView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final MaterialTextView g;

    @NonNull
    public final MaterialButton h;

    public WidgetEditProfileBannerSheetBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull MaterialTextView materialTextView, @NonNull MaterialTextView materialTextView2, @NonNull ConstraintLayout constraintLayout, @NonNull MaterialTextView materialTextView3, @NonNull MaterialTextView materialTextView4, @NonNull ImageView imageView, @NonNull MaterialTextView materialTextView5, @NonNull MaterialButton materialButton) {
        this.a = linearLayout;
        this.f2369b = linearLayout2;
        this.c = materialTextView2;
        this.d = constraintLayout;
        this.e = materialTextView4;
        this.f = imageView;
        this.g = materialTextView5;
        this.h = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
