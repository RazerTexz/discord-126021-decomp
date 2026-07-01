package com.discord.widgets.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMediaFavorites$Favorite;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;
import rx.functions.Func5;

/* JADX INFO: compiled from: EmojiSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiSheetViewModel$Companion$observeStoreState$1<T1, T2, T3, T4, T5, R> implements Func5<EmojiSheetViewModel$Companion$CustomEmojGuildInfo, MeUser, Map<Long, ? extends Guild>, Channel, Set<? extends StoreMediaFavorites$Favorite>, EmojiSheetViewModel$StoreState> {
    public final /* synthetic */ EmojiNode$EmojiIdAndType $emojiIdAndType;

    public EmojiSheetViewModel$Companion$observeStoreState$1(EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType) {
        this.$emojiIdAndType = emojiNode$EmojiIdAndType;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ EmojiSheetViewModel$StoreState call(EmojiSheetViewModel$Companion$CustomEmojGuildInfo emojiSheetViewModel$Companion$CustomEmojGuildInfo, MeUser meUser, Map<Long, ? extends Guild> map, Channel channel, Set<? extends StoreMediaFavorites$Favorite> set) {
        return call2(emojiSheetViewModel$Companion$CustomEmojGuildInfo, meUser, (Map<Long, Guild>) map, channel, set);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final EmojiSheetViewModel$StoreState call2(EmojiSheetViewModel$Companion$CustomEmojGuildInfo emojiSheetViewModel$Companion$CustomEmojGuildInfo, MeUser meUser, Map<Long, Guild> map, Channel channel, Set<? extends StoreMediaFavorites$Favorite> set) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(map, "guilds");
        m.checkNotNullParameter(set, "favorites");
        return new EmojiSheetViewModel$StoreState(emojiSheetViewModel$Companion$CustomEmojGuildInfo, this.$emojiIdAndType, UserUtils.INSTANCE.isPremium(meUser), map.keySet(), channel, set);
    }
}
