package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import p007b.p008a.p025i.C1009n;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiCategoryItemStandardBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15053a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15054b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final C1009n f15055c;

    public EmojiCategoryItemStandardBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull C1009n c1009n) {
        this.f15053a = frameLayout;
        this.f15054b = imageView;
        this.f15055c = c1009n;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15053a;
    }
}
