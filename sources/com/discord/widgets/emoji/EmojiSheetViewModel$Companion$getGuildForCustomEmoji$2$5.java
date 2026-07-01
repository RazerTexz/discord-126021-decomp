package com.discord.widgets.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: EmojiSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$5<T, R> implements b<Guild, EmojiSheetViewModel$Companion$CustomEmojGuildInfo> {
    public static final EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$5 INSTANCE = new EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$5();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ EmojiSheetViewModel$Companion$CustomEmojGuildInfo call(Guild guild) {
        return call2(guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final EmojiSheetViewModel$Companion$CustomEmojGuildInfo call2(Guild guild) {
        m.checkNotNullExpressionValue(guild, "responseGuild");
        return new EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known(guild, true, false, Integer.valueOf(guild.getApproximatePresenceCount()));
    }
}
