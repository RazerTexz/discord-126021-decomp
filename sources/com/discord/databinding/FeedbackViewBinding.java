package com.discord.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class FeedbackViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15067a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageButton f15068b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15069c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final CardView f15070d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final RecyclerView f15071e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ImageButton f15072f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final ConstraintLayout f15073g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f15074h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final ImageView f15075i;

    public FeedbackViewBinding(@NonNull LinearLayout linearLayout, @NonNull ImageButton imageButton, @NonNull TextView textView, @NonNull CardView cardView, @NonNull RecyclerView recyclerView, @NonNull ImageButton imageButton2, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f15067a = linearLayout;
        this.f15068b = imageButton;
        this.f15069c = textView;
        this.f15070d = cardView;
        this.f15071e = recyclerView;
        this.f15072f = imageButton2;
        this.f15073g = constraintLayout;
        this.f15074h = textView2;
        this.f15075i = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15067a;
    }
}
