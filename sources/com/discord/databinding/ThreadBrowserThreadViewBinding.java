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

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f2161b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final SimpleDraweeSpanTextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public ThreadBrowserThreadViewBinding(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = view;
        this.f2161b = simpleDraweeView;
        this.c = imageView;
        this.d = simpleDraweeSpanTextView;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
