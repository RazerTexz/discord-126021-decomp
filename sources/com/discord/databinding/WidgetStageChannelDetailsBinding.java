package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStageChannelDetailsBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2651b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final ImageView k;

    @NonNull
    public final TextView l;

    public WidgetStageChannelDetailsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull TextView textView3, @NonNull ImageView imageView5, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull ImageView imageView6, @NonNull TextView textView6) {
        this.a = constraintLayout;
        this.f2651b = imageView;
        this.c = imageView2;
        this.d = textView;
        this.e = textView2;
        this.f = imageView3;
        this.g = textView3;
        this.h = imageView5;
        this.i = textView4;
        this.j = textView5;
        this.k = imageView6;
        this.l = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
