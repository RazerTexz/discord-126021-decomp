package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class ViewServerSettingsCommunitySettingSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15553a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15554b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f15555c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15556d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15557e;

    public ViewServerSettingsCommunitySettingSelectorBinding(@NonNull View view, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f15553a = view;
        this.f15554b = textView;
        this.f15555c = imageView;
        this.f15556d = textView2;
        this.f15557e = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15553a;
    }
}
