package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderBadgeBinding implements ViewBinding {

    @NonNull
    public final ImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2165b;

    public UserProfileHeaderBadgeBinding(@NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.a = imageView;
        this.f2165b = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
