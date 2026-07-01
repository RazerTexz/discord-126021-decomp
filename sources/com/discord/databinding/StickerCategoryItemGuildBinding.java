package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import b.a.i.n;
import com.discord.widgets.chat.input.emoji.GuildIcon;

/* JADX INFO: loaded from: classes.dex */
public final class StickerCategoryItemGuildBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final n f2148b;

    @NonNull
    public final GuildIcon c;

    public StickerCategoryItemGuildBinding(@NonNull FrameLayout frameLayout, @NonNull n nVar, @NonNull GuildIcon guildIcon) {
        this.a = frameLayout;
        this.f2148b = nVar;
        this.c = guildIcon;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
