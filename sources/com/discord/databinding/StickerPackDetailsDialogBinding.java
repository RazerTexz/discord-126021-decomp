package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class StickerPackDetailsDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15269a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15270b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15271c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15272d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15273e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15274f;

    public StickerPackDetailsDialogBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.f15269a = frameLayout;
        this.f15270b = textView;
        this.f15271c = textView2;
        this.f15272d = textView3;
        this.f15273e = textView4;
        this.f15274f = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15269a;
    }
}
