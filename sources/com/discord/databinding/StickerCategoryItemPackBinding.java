package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import b.a.i.ExpressionPickerCategorySelectionOverlineViewBinding;
import com.discord.views.sticker.StickerView;

/* JADX INFO: loaded from: classes.dex */
public final class StickerCategoryItemPackBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ExpressionPickerCategorySelectionOverlineViewBinding f2149b;

    @NonNull
    public final StickerView c;

    public StickerCategoryItemPackBinding(@NonNull FrameLayout frameLayout, @NonNull ExpressionPickerCategorySelectionOverlineViewBinding expressionPickerCategorySelectionOverlineViewBinding, @NonNull StickerView stickerView) {
        this.a = frameLayout;
        this.f2149b = expressionPickerCategorySelectionOverlineViewBinding;
        this.c = stickerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
