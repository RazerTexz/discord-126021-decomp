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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2366b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final TextInputLayout d;

    @NonNull
    public final LoadingButton e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextInputLayout g;

    public WidgetDisableDeleteAccountDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull TextInputLayout textInputLayout, @NonNull LoadingButton loadingButton, @NonNull TextView textView2, @NonNull TextInputLayout textInputLayout2, @NonNull LinearLayout linearLayout2) {
        this.a = linearLayout;
        this.f2366b = textView;
        this.c = materialButton;
        this.d = textInputLayout;
        this.e = loadingButton;
        this.f = textView2;
        this.g = textInputLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
