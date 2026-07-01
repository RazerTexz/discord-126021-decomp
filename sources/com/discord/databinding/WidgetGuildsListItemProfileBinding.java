package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildsListItemProfileBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2464b;

    @NonNull
    public final FrameLayout c;

    @NonNull
    public final ImageView d;

    public WidgetGuildsListItemProfileBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView2) {
        this.a = relativeLayout;
        this.f2464b = imageView;
        this.c = frameLayout;
        this.d = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
