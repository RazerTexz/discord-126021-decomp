package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.chat.input.emoji.GuildIcon;
import p007b.p008a.p025i.C1009n;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiCategoryItemGuildBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15050a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final GuildIcon f15051b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final C1009n f15052c;

    public EmojiCategoryItemGuildBinding(@NonNull FrameLayout frameLayout, @NonNull GuildIcon guildIcon, @NonNull C1009n c1009n) {
        this.f15050a = frameLayout;
        this.f15051b = guildIcon;
        this.f15052c = c1009n;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15050a;
    }
}
