package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import b.a.i.ExpressionPickerCategorySelectionOverlineViewBinding;
import com.discord.widgets.chat.input.emoji.GuildIcon;

/* JADX INFO: loaded from: classes.dex */
public final class StickerCategoryItemGuildBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ExpressionPickerCategorySelectionOverlineViewBinding f2148b;

    @NonNull
    public final GuildIcon c;

    public StickerCategoryItemGuildBinding(@NonNull FrameLayout frameLayout, @NonNull ExpressionPickerCategorySelectionOverlineViewBinding expressionPickerCategorySelectionOverlineViewBinding, @NonNull GuildIcon guildIcon) {
        this.a = frameLayout;
        this.f2148b = expressionPickerCategorySelectionOverlineViewBinding;
        this.c = guildIcon;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
