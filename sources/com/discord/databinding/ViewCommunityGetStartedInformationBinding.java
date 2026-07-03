package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class ViewCommunityGetStartedInformationBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15404a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15405b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f15406c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15407d;

    public ViewCommunityGetStartedInformationBinding(@NonNull View view, @NonNull Guideline guideline, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView2) {
        this.f15404a = view;
        this.f15405b = textView;
        this.f15406c = imageView;
        this.f15407d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15404a;
    }
}
