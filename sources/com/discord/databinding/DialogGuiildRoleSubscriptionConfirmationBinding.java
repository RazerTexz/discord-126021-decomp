package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class DialogGuiildRoleSubscriptionConfirmationBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15034a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f15035b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f15036c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15037d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15038e;

    public DialogGuiildRoleSubscriptionConfirmationBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f15034a = linearLayout;
        this.f15035b = materialButton;
        this.f15036c = materialButton2;
        this.f15037d = textView;
        this.f15038e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15034a;
    }
}
