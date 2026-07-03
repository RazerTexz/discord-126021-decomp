package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetAuthMfaBackupCodesBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15688a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f15689b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputLayout f15690c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f15691d;

    public WidgetAuthMfaBackupCodesBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull TextInputLayout textInputLayout, @NonNull MaterialButton materialButton2) {
        this.f15688a = linearLayout;
        this.f15689b = materialButton;
        this.f15690c = textInputLayout;
        this.f15691d = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15688a;
    }
}
