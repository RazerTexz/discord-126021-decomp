package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class ViewAuthInviteInfoBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f15374a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f15375b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15376c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15377d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f15378e;

    public ViewAuthInviteInfoBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f15374a = relativeLayout;
        this.f15375b = simpleDraweeView;
        this.f15376c = textView;
        this.f15377d = textView2;
        this.f15378e = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15374a;
    }
}
