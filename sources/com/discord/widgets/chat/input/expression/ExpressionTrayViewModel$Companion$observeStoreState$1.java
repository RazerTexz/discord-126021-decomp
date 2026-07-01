package com.discord.widgets.chat.input.expression;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft;
import d0.t.u;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func5;

/* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExpressionTrayViewModel$Companion$observeStoreState$1<T1, T2, T3, T4, T5, R> implements Func5<ExpressionTrayTab, StoreChannelsSelected$ResolvedSelectedChannel, MeUser, Map<Long, ? extends Map<Long, ? extends Sticker>>, Map<Long, ? extends Guild>, ExpressionTrayViewModel$StoreState> {
    public static final ExpressionTrayViewModel$Companion$observeStoreState$1 INSTANCE = new ExpressionTrayViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ ExpressionTrayViewModel$StoreState call(ExpressionTrayTab expressionTrayTab, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel, MeUser meUser, Map<Long, ? extends Map<Long, ? extends Sticker>> map, Map<Long, ? extends Guild> map2) {
        return call2(expressionTrayTab, storeChannelsSelected$ResolvedSelectedChannel, meUser, (Map<Long, ? extends Map<Long, Sticker>>) map, (Map<Long, Guild>) map2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ExpressionTrayViewModel$StoreState call2(ExpressionTrayTab expressionTrayTab, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel, MeUser meUser, Map<Long, ? extends Map<Long, Sticker>> map, Map<Long, Guild> map2) {
        m.checkNotNullExpressionValue(expressionTrayTab, "lastSelectedTab");
        Channel channelOrParent = storeChannelsSelected$ResolvedSelectedChannel.getChannelOrParent();
        Long lValueOf = channelOrParent != null ? Long.valueOf(channelOrParent.getGuildId()) : null;
        m.checkNotNullExpressionValue(map, "guildStickers");
        return new ExpressionTrayViewModel$StoreState(expressionTrayTab, lValueOf, meUser, map, u.toSet(map2.keySet()), storeChannelsSelected$ResolvedSelectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft);
    }
}
