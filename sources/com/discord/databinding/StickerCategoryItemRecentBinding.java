package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import b.a.i.n;

/* JADX INFO: loaded from: classes.dex */
public final class StickerCategoryItemRecentBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final n f2150b;

    public StickerCategoryItemRecentBinding(@NonNull FrameLayout frameLayout, @NonNull n nVar) {
        this.a = frameLayout;
        this.f2150b = nVar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
