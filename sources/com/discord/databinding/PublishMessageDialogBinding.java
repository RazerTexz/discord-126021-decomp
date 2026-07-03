package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class PublishMessageDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15219a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15220b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f15221c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15222d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LinearLayout f15223e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialButton f15224f;

    public PublishMessageDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull TextView textView2, @NonNull LinearLayout linearLayout3, @NonNull MaterialButton materialButton2) {
        this.f15219a = linearLayout;
        this.f15220b = textView;
        this.f15221c = materialButton;
        this.f15222d = textView2;
        this.f15223e = linearLayout3;
        this.f15224f = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15219a;
    }
}
