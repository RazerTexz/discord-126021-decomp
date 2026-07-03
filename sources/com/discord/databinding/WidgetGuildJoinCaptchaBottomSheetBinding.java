package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildJoinCaptchaBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f16854a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16855b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f16856c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16857d;

    public WidgetGuildJoinCaptchaBottomSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.f16854a = nestedScrollView;
        this.f16855b = textView;
        this.f16856c = materialButton;
        this.f16857d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16854a;
    }
}
