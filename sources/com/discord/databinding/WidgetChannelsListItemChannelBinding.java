package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelsListItemChannelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f16011a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f16012b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f16013c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16014d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16015e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ImageView f16016f;

    public WidgetChannelsListItemChannelBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView3) {
        this.f16011a = relativeLayout;
        this.f16012b = imageView;
        this.f16013c = imageView2;
        this.f16014d = textView;
        this.f16015e = textView2;
        this.f16016f = imageView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16011a;
    }
}
