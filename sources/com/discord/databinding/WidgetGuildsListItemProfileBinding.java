package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildsListItemProfileBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17120a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f17121b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FrameLayout f17122c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f17123d;

    public WidgetGuildsListItemProfileBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView2) {
        this.f17120a = relativeLayout;
        this.f17121b = imageView;
        this.f17122c = frameLayout;
        this.f17123d = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17120a;
    }
}
