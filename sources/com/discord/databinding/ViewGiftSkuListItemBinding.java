package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGiftSkuListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f15440a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15441b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15442c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f15443d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15444e;

    public ViewGiftSkuListItemBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2) {
        this.f15440a = cardView;
        this.f15441b = imageView;
        this.f15442c = textView;
        this.f15443d = simpleDraweeView;
        this.f15444e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15440a;
    }
}
