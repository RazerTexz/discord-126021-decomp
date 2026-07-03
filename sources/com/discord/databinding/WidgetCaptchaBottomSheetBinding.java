package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetCaptchaBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f15799a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15800b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f15801c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15802d;

    public WidgetCaptchaBottomSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f15799a = nestedScrollView;
        this.f15800b = textView;
        this.f15801c = materialButton;
        this.f15802d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15799a;
    }
}
