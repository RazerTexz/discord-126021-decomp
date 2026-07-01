package com.discord.widgets.stickers;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func4;

/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildStickerSheetViewModel$Companion$observeStoreState$1<T1, T2, T3, T4, R> implements Func4<GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo, MeUser, Channel, Map<Long, ? extends Guild>, GuildStickerSheetViewModel$StoreState> {
    public static final GuildStickerSheetViewModel$Companion$observeStoreState$1 INSTANCE = new GuildStickerSheetViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ GuildStickerSheetViewModel$StoreState call(GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo guildStickerSheetViewModel$Companion$GuildStickerGuildInfo, MeUser meUser, Channel channel, Map<Long, ? extends Guild> map) {
        return call2(guildStickerSheetViewModel$Companion$GuildStickerGuildInfo, meUser, channel, (Map<Long, Guild>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildStickerSheetViewModel$StoreState call2(GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo guildStickerSheetViewModel$Companion$GuildStickerGuildInfo, MeUser meUser, Channel channel, Map<Long, Guild> map) {
        m.checkNotNullExpressionValue(meUser, "meUser");
        Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
        m.checkNotNullExpressionValue(map, "userGuilds");
        m.checkNotNullExpressionValue(guildStickerSheetViewModel$Companion$GuildStickerGuildInfo, "guildStickerGuildInfo");
        return new GuildStickerSheetViewModel$StoreState(meUser, lValueOf, map, guildStickerSheetViewModel$Companion$GuildStickerGuildInfo);
    }
}
