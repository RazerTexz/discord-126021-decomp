package com.discord.widgets.stickers;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.utilities.rest.RestAPI;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2<T, R> implements b<Guild, Observable<? extends GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo>> {
    public final /* synthetic */ RestAPI $restAPI;
    public final /* synthetic */ Sticker $sticker;

    public GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2(RestAPI restAPI, Sticker sticker) {
        this.$restAPI = restAPI;
        this.$sticker = sticker;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo> call(Guild guild) {
        return call2(guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo> call2(Guild guild) {
        if (guild != null) {
            return guild.getFeatures().contains(GuildFeature.DISCOVERABLE) ? this.$restAPI.getStickerGuild(this.$sticker.getId()).G(GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$1.INSTANCE).G(GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$2.INSTANCE).M(new GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$3(guild)) : new k(new GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known(guild, false, true, null));
        }
        return this.$restAPI.getStickerGuild(this.$sticker.getId()).G(GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$4.INSTANCE).G(GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$5.INSTANCE).M(GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$6.INSTANCE);
    }
}
