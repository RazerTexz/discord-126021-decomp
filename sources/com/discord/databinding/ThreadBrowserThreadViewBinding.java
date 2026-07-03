package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class ThreadBrowserThreadViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15314a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f15315b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f15316c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeSpanTextView f15317d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15318e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15319f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f15320g;

    public ThreadBrowserThreadViewBinding(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f15314a = view;
        this.f15315b = simpleDraweeView;
        this.f15316c = imageView;
        this.f15317d = simpleDraweeSpanTextView;
        this.f15318e = textView;
        this.f15319f = textView2;
        this.f15320g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15314a;
    }
}
