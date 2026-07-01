package com.discord.widgets.stickers;

import androidx.core.app.NotificationCompat;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuilds;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$1<V> implements Callable<Guild> {
    public final /* synthetic */ Sticker $sticker;
    public final /* synthetic */ StoreGuilds $storeGuilds;

    public GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$1(StoreGuilds storeGuilds, Sticker sticker) {
        this.$storeGuilds = storeGuilds;
        this.$sticker = sticker;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Guild call() {
        return call();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public final Guild call() {
        return this.$storeGuilds.getGuilds().get(this.$sticker.getGuildId());
    }
}
