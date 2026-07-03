package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGiftOutboundPromoListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final MaterialCardView f15434a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f15435b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15436c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f15437d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15438e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15439f;

    public ViewGiftOutboundPromoListItemBinding(@NonNull MaterialCardView materialCardView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f15434a = materialCardView;
        this.f15435b = materialButton;
        this.f15436c = textView;
        this.f15437d = simpleDraweeView;
        this.f15438e = textView2;
        this.f15439f = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15434a;
    }
}
