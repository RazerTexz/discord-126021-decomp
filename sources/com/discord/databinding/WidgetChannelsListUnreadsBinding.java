package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelsListUnreadsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f16081a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16082b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RelativeLayout f16083c;

    public WidgetChannelsListUnreadsBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout) {
        this.f16081a = frameLayout;
        this.f16082b = textView;
        this.f16083c = relativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16081a;
    }
}
