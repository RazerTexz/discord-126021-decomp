package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class ViewChannelOverrideItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15382a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15383b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15384c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15385d;

    public ViewChannelOverrideItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull Guideline guideline, @NonNull ImageView imageView) {
        this.f15382a = constraintLayout;
        this.f15383b = textView;
        this.f15384c = textView2;
        this.f15385d = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15382a;
    }
}
