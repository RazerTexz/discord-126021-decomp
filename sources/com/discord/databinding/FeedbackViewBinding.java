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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageButton f2106b;

    @NonNull
    public final TextView c;

    @NonNull
    public final CardView d;

    @NonNull
    public final RecyclerView e;

    @NonNull
    public final ImageButton f;

    @NonNull
    public final ConstraintLayout g;

    @NonNull
    public final TextView h;

    @NonNull
    public final ImageView i;

    public FeedbackViewBinding(@NonNull LinearLayout linearLayout, @NonNull ImageButton imageButton, @NonNull TextView textView, @NonNull CardView cardView, @NonNull RecyclerView recyclerView, @NonNull ImageButton imageButton2, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.a = linearLayout;
        this.f2106b = imageButton;
        this.c = textView;
        this.d = cardView;
        this.e = recyclerView;
        this.f = imageButton2;
        this.g = constraintLayout;
        this.h = textView2;
        this.i = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
