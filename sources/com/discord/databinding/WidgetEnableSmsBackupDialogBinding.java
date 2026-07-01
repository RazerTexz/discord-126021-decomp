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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2381b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final LoadingButton d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextInputLayout f;

    public WidgetEnableSmsBackupDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull LoadingButton loadingButton, @NonNull TextView textView2, @NonNull TextInputLayout textInputLayout, @NonNull LinearLayout linearLayout2) {
        this.a = linearLayout;
        this.f2381b = textView;
        this.c = materialButton;
        this.d = loadingButton;
        this.e = textView2;
        this.f = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
