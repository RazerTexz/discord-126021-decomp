package com.discord.widgets.stickers;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import j0.k.b;
import retrofit2.HttpException;

/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$3<T, R> implements b<Throwable, GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo> {
    public final /* synthetic */ Guild $localGuild;

    public GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2$3(Guild guild) {
        this.$localGuild = guild;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo call(Throwable th) {
        return call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo call2(Throwable th) {
        return ((th instanceof HttpException) && ((HttpException) th).a() == 404) ? new GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known(this.$localGuild, false, true, null) : GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Unknown.INSTANCE;
    }
}
