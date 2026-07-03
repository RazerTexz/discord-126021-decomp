package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class ViewSettingsBoostedBoostListitemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f15568a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15569b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f15570c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15571d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15572e;

    public ViewSettingsBoostedBoostListitemBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f15568a = relativeLayout;
        this.f15569b = textView;
        this.f15570c = imageView;
        this.f15571d = textView2;
        this.f15572e = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15568a;
    }
}
