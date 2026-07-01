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

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2658b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextInputEditText f;

    @NonNull
    public final TextInputLayout g;

    public WidgetStageStartEventBottomSheetBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextInputEditText textInputEditText, @NonNull TextView textView4, @NonNull TextInputLayout textInputLayout) {
        this.a = coordinatorLayout;
        this.f2658b = textView;
        this.c = materialButton;
        this.d = textView2;
        this.e = textView3;
        this.f = textInputEditText;
        this.g = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
