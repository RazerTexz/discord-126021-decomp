package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderBadgeBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ImageView f15339a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15340b;

    public UserProfileHeaderBadgeBinding(@NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.f15339a = imageView;
        this.f15340b = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15339a;
    }
}
