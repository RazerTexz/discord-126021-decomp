package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class ViewConnectionGuildIntegrationBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f15408a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15409b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f15410c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15411d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15412e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialButton f15413f;

    public ViewConnectionGuildIntegrationBinding(@NonNull CardView cardView, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull MaterialButton materialButton) {
        this.f15408a = cardView;
        this.f15409b = textView;
        this.f15410c = simpleDraweeView;
        this.f15411d = textView2;
        this.f15412e = textView3;
        this.f15413f = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15408a;
    }
}
