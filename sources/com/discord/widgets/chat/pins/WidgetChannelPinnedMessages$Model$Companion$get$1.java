package com.discord.widgets.chat.pins;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.message.Message;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.utilities.embed.InviteEmbedModel$Companion;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata$Companion;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelPinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPinnedMessages$Model$Companion$get$1<T, R> implements b<List<? extends Message>, Observable<? extends WidgetChannelPinnedMessages$Model>> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Context $context;

    public WidgetChannelPinnedMessages$Model$Companion$get$1(Channel channel, Context context) {
        this.$channel = channel;
        this.$context = context;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelPinnedMessages$Model> call(List<? extends Message> list) {
        return call2((List<Message>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelPinnedMessages$Model> call2(List<Message> list) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<Long> observableObserveMeId = storeStream$Companion.getUsers().observeMeId();
        WidgetChatListModelMessages$MessagesWithMetadata$Companion widgetChatListModelMessages$MessagesWithMetadata$Companion = WidgetChatListModelMessages$MessagesWithMetadata.Companion;
        m.checkNotNullExpressionValue(list, "pinnedMessages");
        return ObservableCombineLatestOverloadsKt.combineLatest(observableObserveMeId, widgetChatListModelMessages$MessagesWithMetadata$Companion.get(list), storeStream$Companion.getGuilds().observeRoles(this.$channel.getGuildId()), storeStream$Companion.getGuilds().observeComputed(this.$channel.getGuildId()), storeStream$Companion.getChannels().observeNames(), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(storeStream$Companion.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(storeStream$Companion.getUserSettings(), false, 1, null), storeStream$Companion.getGuilds().observeGuild(this.$channel.getGuildId()), InviteEmbedModel$Companion.observe$default(InviteEmbedModel.Companion, null, null, null, null, 15, null), GuildRoleSubscriptionsFeatureFlag.Companion.getINSTANCE().observeCanGuildSeePurchaseFeedbackLoopSystemMessages(Long.valueOf(this.$channel.getGuildId())), new WidgetChannelPinnedMessages$Model$Companion$get$1$1(this, list));
    }
}
