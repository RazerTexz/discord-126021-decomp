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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16490a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinearLayout f16491b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialTextView f16492c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ConstraintLayout f16493d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialTextView f16494e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ImageView f16495f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final MaterialTextView f16496g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final MaterialButton f16497h;

    public WidgetEditProfileBannerSheetBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull MaterialTextView materialTextView, @NonNull MaterialTextView materialTextView2, @NonNull ConstraintLayout constraintLayout, @NonNull MaterialTextView materialTextView3, @NonNull MaterialTextView materialTextView4, @NonNull ImageView imageView, @NonNull MaterialTextView materialTextView5, @NonNull MaterialButton materialButton) {
        this.f16490a = linearLayout;
        this.f16491b = linearLayout2;
        this.f16492c = materialTextView2;
        this.f16493d = constraintLayout;
        this.f16494e = materialTextView4;
        this.f16495f = imageView;
        this.f16496g = materialTextView5;
        this.f16497h = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16490a;
    }
}
