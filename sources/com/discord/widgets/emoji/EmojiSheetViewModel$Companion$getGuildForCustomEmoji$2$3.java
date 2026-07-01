package com.discord.widgets.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import j0.k.b;
import retrofit2.HttpException;

/* JADX INFO: compiled from: EmojiSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$3<T, R> implements b<Throwable, EmojiSheetViewModel$Companion$CustomEmojGuildInfo> {
    public final /* synthetic */ Guild $localGuild;

    public EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$3(Guild guild) {
        this.$localGuild = guild;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ EmojiSheetViewModel$Companion$CustomEmojGuildInfo call(Throwable th) {
        return call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final EmojiSheetViewModel$Companion$CustomEmojGuildInfo call2(Throwable th) {
        return ((th instanceof HttpException) && ((HttpException) th).a() == 404) ? new EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known(this.$localGuild, false, true, null) : EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Unknown.INSTANCE;
    }
}
