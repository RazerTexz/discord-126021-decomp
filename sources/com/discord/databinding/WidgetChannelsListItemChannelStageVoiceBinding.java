package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelsListItemChannelStageVoiceBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f16024a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f16025b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f16026c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16027d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16028e;

    public WidgetChannelsListItemChannelStageVoiceBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f16024a = relativeLayout;
        this.f16025b = imageView;
        this.f16026c = imageView2;
        this.f16027d = textView;
        this.f16028e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16024a;
    }
}
