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
public final class WidgetDisableDeleteAccountDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16467a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16468b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f16469c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextInputLayout f16470d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LoadingButton f16471e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f16472f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextInputLayout f16473g;

    public WidgetDisableDeleteAccountDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull TextInputLayout textInputLayout, @NonNull LoadingButton loadingButton, @NonNull TextView textView2, @NonNull TextInputLayout textInputLayout2, @NonNull LinearLayout linearLayout2) {
        this.f16467a = linearLayout;
        this.f16468b = textView;
        this.f16469c = materialButton;
        this.f16470d = textInputLayout;
        this.f16471e = loadingButton;
        this.f16472f = textView2;
        this.f16473g = textInputLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16467a;
    }
}
