package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import b.a.i.ExpressionPickerCategorySelectionOverlineViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiCategoryItemStandardBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2100b;

    @NonNull
    public final ExpressionPickerCategorySelectionOverlineViewBinding c;

    public EmojiCategoryItemStandardBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull ExpressionPickerCategorySelectionOverlineViewBinding expressionPickerCategorySelectionOverlineViewBinding) {
        this.a = frameLayout;
        this.f2100b = imageView;
        this.c = expressionPickerCategorySelectionOverlineViewBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
