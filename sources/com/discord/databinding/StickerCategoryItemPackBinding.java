package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;
import p007b.p008a.p025i.C1009n;

/* JADX INFO: loaded from: classes.dex */
public final class StickerCategoryItemPackBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15262a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final C1009n f15263b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final StickerView f15264c;

    public StickerCategoryItemPackBinding(@NonNull FrameLayout frameLayout, @NonNull C1009n c1009n, @NonNull StickerView stickerView) {
        this.f15262a = frameLayout;
        this.f15263b = c1009n;
        this.f15264c = stickerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15262a;
    }
}
