package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutUnhandledUriBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15174a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15175b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f15176c;

    public LayoutUnhandledUriBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton) {
        this.f15174a = linearLayout;
        this.f15175b = textView;
        this.f15176c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15174a;
    }
}
