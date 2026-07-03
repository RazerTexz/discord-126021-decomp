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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17479a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f17480b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f17481c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17482d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextInputLayout f17483e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final LinearLayout f17484f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f17485g;

    public WidgetServerDeleteDialogBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2) {
        this.f17479a = linearLayout;
        this.f17480b = materialButton;
        this.f17481c = materialButton2;
        this.f17482d = textView;
        this.f17483e = textInputLayout;
        this.f17484f = linearLayout2;
        this.f17485g = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17479a;
    }
}
