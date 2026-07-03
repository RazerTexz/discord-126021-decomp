package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class ViewUserStatusPresenceCustomBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15587a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final AppCompatImageView f15588b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f15589c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15590d;

    public ViewUserStatusPresenceCustomBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.f15587a = linearLayout;
        this.f15588b = appCompatImageView;
        this.f15589c = simpleDraweeView;
        this.f15590d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15587a;
    }
}
