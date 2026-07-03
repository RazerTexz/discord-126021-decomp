package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;

/* JADX INFO: loaded from: classes.dex */
public final class StickerPickerStickerItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15275a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final StickerView f15276b;

    public StickerPickerStickerItemBinding(@NonNull FrameLayout frameLayout, @NonNull StickerView stickerView) {
        this.f15275a = frameLayout;
        this.f15276b = stickerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15275a;
    }
}
