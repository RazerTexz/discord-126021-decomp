package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetKickUserBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17209a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17210b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f17211c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f17212d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextInputLayout f17213e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f17214f;

    public WidgetKickUserBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView2) {
        this.f17209a = linearLayout;
        this.f17210b = textView;
        this.f17211c = materialButton;
        this.f17212d = materialButton2;
        this.f17213e = textInputLayout;
        this.f17214f = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17209a;
    }
}
