package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelsListItemHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f16049a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16050b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f16051c;

    public WidgetChannelsListItemHeaderBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ImageView imageView) {
        this.f16049a = relativeLayout;
        this.f16050b = textView;
        this.f16051c = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16049a;
    }
}
