package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.chat.input.emoji.GuildIcon;
import p007b.p008a.p025i.C1009n;

/* JADX INFO: loaded from: classes.dex */
public final class StickerCategoryItemGuildBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15259a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final C1009n f15260b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final GuildIcon f15261c;

    public StickerCategoryItemGuildBinding(@NonNull FrameLayout frameLayout, @NonNull C1009n c1009n, @NonNull GuildIcon guildIcon) {
        this.f15259a = frameLayout;
        this.f15260b = c1009n;
        this.f15261c = guildIcon;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15259a;
    }
}
