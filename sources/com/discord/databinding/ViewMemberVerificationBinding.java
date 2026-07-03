package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class ViewMemberVerificationBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15507a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15508b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f15509c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f15510d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15511e;

    public ViewMemberVerificationBinding(@NonNull View view, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.f15507a = view;
        this.f15508b = textView;
        this.f15509c = materialButton;
        this.f15510d = imageView;
        this.f15511e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15507a;
    }
}
