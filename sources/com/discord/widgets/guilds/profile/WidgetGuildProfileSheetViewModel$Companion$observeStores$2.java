package com.discord.widgets.guilds.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheetViewModel$Companion$observeStores$2<T, R> implements b<EmojiSet, List<Emoji>> {
    public final /* synthetic */ long $guildId;

    public WidgetGuildProfileSheetViewModel$Companion$observeStores$2(long j) {
        this.$guildId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<Emoji> call(EmojiSet emojiSet) {
        return call2(emojiSet);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Emoji> call2(EmojiSet emojiSet) {
        return emojiSet.customEmojis.get(Long.valueOf(this.$guildId));
    }
}
