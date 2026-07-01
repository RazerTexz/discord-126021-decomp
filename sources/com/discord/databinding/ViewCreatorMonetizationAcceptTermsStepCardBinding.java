package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class ViewCreatorMonetizationAcceptTermsStepCardBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2184b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final Space d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public ViewCreatorMonetizationAcceptTermsStepCardBinding(@NonNull View view, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull Space space, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = view;
        this.f2184b = textView;
        this.c = imageView;
        this.d = space;
        this.e = textView2;
        this.f = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
