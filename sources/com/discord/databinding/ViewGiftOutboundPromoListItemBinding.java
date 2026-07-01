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

    @NonNull
    public final MaterialCardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2187b;

    @NonNull
    public final TextView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public ViewGiftOutboundPromoListItemBinding(@NonNull MaterialCardView materialCardView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = materialCardView;
        this.f2187b = materialButton;
        this.c = textView;
        this.d = simpleDraweeView;
        this.e = textView2;
        this.f = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
