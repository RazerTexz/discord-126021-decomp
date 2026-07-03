package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildWelcomeChannelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f17079a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CardView f17080b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f17081c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f17082d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f17083e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f17084f;

    public WidgetGuildWelcomeChannelBinding(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout3, @NonNull TextView textView3) {
        this.f17079a = cardView;
        this.f17080b = cardView2;
        this.f17081c = textView;
        this.f17082d = simpleDraweeView;
        this.f17083e = textView2;
        this.f17084f = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17079a;
    }
}
