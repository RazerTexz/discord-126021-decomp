package com.discord.widgets.stickers;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$2<T, R> implements b<Guild, GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo> {
    public static final GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$2 INSTANCE = new GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo call(Guild guild) {
        return call2(guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo call2(Guild guild) {
        m.checkNotNullExpressionValue(guild, "responseGuild");
        return new GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known(guild, true, true, Integer.valueOf(guild.getApproximatePresenceCount()));
    }
}
