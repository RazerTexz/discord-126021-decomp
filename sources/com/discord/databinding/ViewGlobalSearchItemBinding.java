package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGlobalSearchItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15445a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15446b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15447c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f15448d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15449e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15450f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final ImageView f15451g;

    public ViewGlobalSearchItemBinding(@NonNull View view, @NonNull Guideline guideline, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull ImageView imageView) {
        this.f15445a = view;
        this.f15446b = textView;
        this.f15447c = textView2;
        this.f15448d = simpleDraweeView;
        this.f15449e = textView3;
        this.f15450f = textView4;
        this.f15451g = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15445a;
    }
}
