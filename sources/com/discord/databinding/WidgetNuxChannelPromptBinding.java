package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetNuxChannelPromptBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17316a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LoadingButton f17317b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f17318c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17319d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f17320e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f17321f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextInputLayout f17322g;

    public WidgetNuxChannelPromptBinding(@NonNull RelativeLayout relativeLayout, @NonNull LoadingButton loadingButton, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextInputLayout textInputLayout, @NonNull Toolbar toolbar) {
        this.f17316a = relativeLayout;
        this.f17317b = loadingButton;
        this.f17318c = simpleDraweeView;
        this.f17319d = textView;
        this.f17320e = textView2;
        this.f17321f = textView3;
        this.f17322g = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17316a;
    }
}
