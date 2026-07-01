package com.discord.widgets.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.models.guild.Guild;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType$Custom;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: EmojiSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2<T, R> implements b<Guild, Observable<? extends EmojiSheetViewModel$Companion$CustomEmojGuildInfo>> {
    public final /* synthetic */ EmojiNode$EmojiIdAndType$Custom $emoji;
    public final /* synthetic */ RestAPI $restAPI;

    public EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2(RestAPI restAPI, EmojiNode$EmojiIdAndType$Custom emojiNode$EmojiIdAndType$Custom) {
        this.$restAPI = restAPI;
        this.$emoji = emojiNode$EmojiIdAndType$Custom;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends EmojiSheetViewModel$Companion$CustomEmojGuildInfo> call(Guild guild) {
        return call2(guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends EmojiSheetViewModel$Companion$CustomEmojGuildInfo> call2(Guild guild) {
        if (guild != null) {
            return guild.getFeatures().contains(GuildFeature.DISCOVERABLE) ? this.$restAPI.getEmojiGuild(this.$emoji.getId()).G(EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$1.INSTANCE).G(EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$2.INSTANCE).M(new EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$3(guild)) : new k(new EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known(guild, false, true, null));
        }
        return this.$restAPI.getEmojiGuild(this.$emoji.getId()).G(EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$4.INSTANCE).G(EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$5.INSTANCE).M(EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2$6.INSTANCE);
    }
}
