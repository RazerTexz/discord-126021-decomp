package com.discord.widgets.stickers;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.Guild;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$4<T, R> implements b<Guild, com.discord.models.guild.Guild> {
    public static final GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$4 INSTANCE = new GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$4();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ com.discord.models.guild.Guild call(Guild guild) {
        return call2(guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final com.discord.models.guild.Guild call2(Guild guild) {
        m.checkNotNullExpressionValue(guild, "it");
        return new com.discord.models.guild.Guild(guild);
    }
}
