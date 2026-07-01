package com.discord.widgets.chat.input.emoji;

import com.discord.models.domain.emoji.EmojiCategory;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EmojiCategoryItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiCategoryItem$Companion {
    private EmojiCategoryItem$Companion() {
    }

    public final long mapEmojiCategoryToItemId(EmojiCategory emojiCategory) {
        m.checkNotNullParameter(emojiCategory, "emojiCategory");
        return emojiCategory.name().hashCode();
    }

    public final long mapGuildToItemId(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        return guild.getId();
    }

    public /* synthetic */ EmojiCategoryItem$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
