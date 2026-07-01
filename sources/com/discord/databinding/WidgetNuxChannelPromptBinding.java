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

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LoadingButton f2504b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextInputLayout g;

    public WidgetNuxChannelPromptBinding(@NonNull RelativeLayout relativeLayout, @NonNull LoadingButton loadingButton, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextInputLayout textInputLayout, @NonNull Toolbar toolbar) {
        this.a = relativeLayout;
        this.f2504b = loadingButton;
        this.c = simpleDraweeView;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
