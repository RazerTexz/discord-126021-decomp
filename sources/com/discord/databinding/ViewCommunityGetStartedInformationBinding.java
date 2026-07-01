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

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2182b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final TextView d;

    public ViewCommunityGetStartedInformationBinding(@NonNull View view, @NonNull Guideline guideline, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView2) {
        this.a = view;
        this.f2182b = textView;
        this.c = imageView;
        this.d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
