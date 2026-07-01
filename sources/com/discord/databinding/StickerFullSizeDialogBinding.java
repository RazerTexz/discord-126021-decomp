package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;

/* JADX INFO: loaded from: classes.dex */
public final class StickerFullSizeDialogBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final StickerView f2151b;

    public StickerFullSizeDialogBinding(@NonNull FrameLayout frameLayout, @NonNull StickerView stickerView) {
        this.a = frameLayout;
        this.f2151b = stickerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
