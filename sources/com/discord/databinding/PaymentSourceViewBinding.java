package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class PaymentSourceViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15207a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15208b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15209c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f15210d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15211e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15212f;

    public PaymentSourceViewBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull CardView cardView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f15207a = view;
        this.f15208b = imageView;
        this.f15209c = textView;
        this.f15210d = imageView2;
        this.f15211e = textView2;
        this.f15212f = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15207a;
    }
}
