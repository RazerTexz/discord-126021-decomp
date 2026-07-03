package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;

/* JADX INFO: loaded from: classes.dex */
public final class StickerAutocompleteItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15257a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final StickerView f15258b;

    public StickerAutocompleteItemBinding(@NonNull FrameLayout frameLayout, @NonNull StickerView stickerView) {
        this.f15257a = frameLayout;
        this.f15258b = stickerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15257a;
    }
}
