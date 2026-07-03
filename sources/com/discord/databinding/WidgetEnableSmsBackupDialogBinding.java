package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetEnableSmsBackupDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16592a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16593b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f16594c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LoadingButton f16595d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16596e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextInputLayout f16597f;

    public WidgetEnableSmsBackupDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull LoadingButton loadingButton, @NonNull TextView textView2, @NonNull TextInputLayout textInputLayout, @NonNull LinearLayout linearLayout2) {
        this.f16592a = linearLayout;
        this.f16593b = textView;
        this.f16594c = materialButton;
        this.f16595d = loadingButton;
        this.f16596e = textView2;
        this.f16597f = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16592a;
    }
}
