package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemCallBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f16173a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f16174b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f16175c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16176d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16177e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final LinearLayout f16178f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16179g;

    public WidgetChatListAdapterItemCallBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull RecyclerView recyclerView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView3) {
        this.f16173a = cardView;
        this.f16174b = imageView;
        this.f16175c = recyclerView;
        this.f16176d = textView;
        this.f16177e = textView2;
        this.f16178f = linearLayout;
        this.f16179g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16173a;
    }
}
