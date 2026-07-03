package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildSelectorItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17052a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final FrameLayout f17053b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f17054c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17055d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f17056e;

    public WidgetGuildSelectorItemBinding(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f17052a = linearLayout;
        this.f17053b = frameLayout;
        this.f17054c = simpleDraweeView;
        this.f17055d = textView;
        this.f17056e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17052a;
    }
}
