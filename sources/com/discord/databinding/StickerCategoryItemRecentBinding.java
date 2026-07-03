package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import p007b.p008a.p025i.C1009n;

/* JADX INFO: loaded from: classes.dex */
public final class StickerCategoryItemRecentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15265a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final C1009n f15266b;

    public StickerCategoryItemRecentBinding(@NonNull FrameLayout frameLayout, @NonNull C1009n c1009n) {
        this.f15265a = frameLayout;
        this.f15266b = c1009n;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15265a;
    }
}
