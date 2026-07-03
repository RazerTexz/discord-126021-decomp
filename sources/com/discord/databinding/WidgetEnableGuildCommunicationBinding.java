package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetEnableGuildCommunicationBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16584a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f16585b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f16586c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16587d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16588e;

    public WidgetEnableGuildCommunicationBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f16584a = linearLayout;
        this.f16585b = materialButton;
        this.f16586c = materialButton2;
        this.f16587d = textView;
        this.f16588e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16584a;
    }
}
