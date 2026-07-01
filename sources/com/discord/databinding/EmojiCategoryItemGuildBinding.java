package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import b.a.i.ExpressionPickerCategorySelectionOverlineViewBinding;
import com.discord.widgets.chat.input.emoji.GuildIcon;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiCategoryItemGuildBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildIcon f2099b;

    @NonNull
    public final ExpressionPickerCategorySelectionOverlineViewBinding c;

    public EmojiCategoryItemGuildBinding(@NonNull FrameLayout frameLayout, @NonNull GuildIcon guildIcon, @NonNull ExpressionPickerCategorySelectionOverlineViewBinding expressionPickerCategorySelectionOverlineViewBinding) {
        this.a = frameLayout;
        this.f2099b = guildIcon;
        this.c = expressionPickerCategorySelectionOverlineViewBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
