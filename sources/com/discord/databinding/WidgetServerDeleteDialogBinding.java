package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerDeleteDialogBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2536b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextInputLayout e;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final TextView g;

    public WidgetServerDeleteDialogBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f2536b = materialButton;
        this.c = materialButton2;
        this.d = textView;
        this.e = textInputLayout;
        this.f = linearLayout2;
        this.g = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
