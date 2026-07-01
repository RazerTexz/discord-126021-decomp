package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import b.a.i.n;
import com.discord.widgets.chat.input.emoji.GuildIcon;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiCategoryItemGuildBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildIcon f2099b;

    @NonNull
    public final n c;

    public EmojiCategoryItemGuildBinding(@NonNull FrameLayout frameLayout, @NonNull GuildIcon guildIcon, @NonNull n nVar) {
        this.a = frameLayout;
        this.f2099b = guildIcon;
        this.c = nVar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
