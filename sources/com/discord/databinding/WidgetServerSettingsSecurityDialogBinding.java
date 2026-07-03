package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsSecurityDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17755a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f17756b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f17757c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextInputLayout f17758d;

    public WidgetServerSettingsSecurityDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextInputLayout textInputLayout) {
        this.f17755a = linearLayout;
        this.f17756b = materialButton;
        this.f17757c = materialButton2;
        this.f17758d = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17755a;
    }
}
