package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class StageRaisedHandsItemUserBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15251a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15252b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f15253c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15254d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeView f15255e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15256f;

    public StageRaisedHandsItemUserBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2) {
        this.f15251a = constraintLayout;
        this.f15252b = imageView;
        this.f15253c = imageView2;
        this.f15254d = textView;
        this.f15255e = simpleDraweeView;
        this.f15256f = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15251a;
    }
}
