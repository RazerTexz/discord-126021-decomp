package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStageStartEventBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f18173a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f18174b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f18175c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f18176d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f18177e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextInputEditText f18178f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextInputLayout f18179g;

    public WidgetStageStartEventBottomSheetBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextInputEditText textInputEditText, @NonNull TextView textView4, @NonNull TextInputLayout textInputLayout) {
        this.f18173a = coordinatorLayout;
        this.f18174b = textView;
        this.f18175c = materialButton;
        this.f18176d = textView2;
        this.f18177e = textView3;
        this.f18178f = textInputEditText;
        this.f18179g = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18173a;
    }
}
