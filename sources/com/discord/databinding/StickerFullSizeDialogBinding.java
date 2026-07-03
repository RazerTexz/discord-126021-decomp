package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;

/* JADX INFO: loaded from: classes.dex */
public final class StickerFullSizeDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15267a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final StickerView f15268b;

    public StickerFullSizeDialogBinding(@NonNull FrameLayout frameLayout, @NonNull StickerView stickerView) {
        this.f15267a = frameLayout;
        this.f15268b = stickerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15267a;
    }
}
