package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class SuggestedFriendViewBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f2156b;

    @NonNull
    public final AppCompatImageView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final AppCompatImageView e;

    @NonNull
    public final TextView f;

    public SuggestedFriendViewBinding(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView, @NonNull AppCompatImageView appCompatImageView2, @NonNull TextView textView2) {
        this.a = view;
        this.f2156b = simpleDraweeView;
        this.c = appCompatImageView;
        this.d = textView;
        this.e = appCompatImageView2;
        this.f = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
