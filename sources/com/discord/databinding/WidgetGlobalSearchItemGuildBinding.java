package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchItemGuildBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f16715a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f16716b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f16717c;

    public WidgetGlobalSearchItemGuildBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.f16715a = relativeLayout;
        this.f16716b = imageView;
        this.f16717c = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16715a;
    }
}
