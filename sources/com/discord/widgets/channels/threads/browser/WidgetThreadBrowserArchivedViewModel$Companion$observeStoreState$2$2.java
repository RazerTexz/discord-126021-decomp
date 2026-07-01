package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState;
import com.discord.utilities.threads.ThreadUtils;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func4;

/* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2$2<T1, T2, T3, T4, R> implements Func4<Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends User>, Long, WidgetThreadBrowserArchivedViewModel$StoreState> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ ArchivedThreadsStore$ThreadListingState $listingState;
    public final /* synthetic */ WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2 this$0;

    public WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2$2(WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2 widgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2, ArchivedThreadsStore$ThreadListingState archivedThreadsStore$ThreadListingState, Channel channel) {
        this.this$0 = widgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2;
        this.$listingState = archivedThreadsStore$ThreadListingState;
        this.$channel = channel;
    }

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetThreadBrowserArchivedViewModel$StoreState call(Map<Long, ? extends GuildMember> map, Guild guild, Map<Long, ? extends User> map2, Long l) {
        return call2((Map<Long, GuildMember>) map, guild, map2, l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetThreadBrowserArchivedViewModel$StoreState call2(Map<Long, GuildMember> map, Guild guild, Map<Long, ? extends User> map2, Long l) {
        boolean zCanViewAllPrivateThreads = ThreadUtils.INSTANCE.canViewAllPrivateThreads(l);
        WidgetThreadBrowserArchivedViewModel$ViewMode widgetThreadBrowserArchivedViewModel$ViewMode = this.this$0.$viewMode;
        m.checkNotNullExpressionValue(map, "guildMembers");
        m.checkNotNullExpressionValue(map2, "users");
        ArchivedThreadsStore$ThreadListingState archivedThreadsStore$ThreadListingState = this.$listingState;
        m.checkNotNullExpressionValue(archivedThreadsStore$ThreadListingState, "listingState");
        return new WidgetThreadBrowserArchivedViewModel$StoreState(widgetThreadBrowserArchivedViewModel$ViewMode, map, map2, archivedThreadsStore$ThreadListingState, zCanViewAllPrivateThreads, this.$channel, guild, l);
    }
}
