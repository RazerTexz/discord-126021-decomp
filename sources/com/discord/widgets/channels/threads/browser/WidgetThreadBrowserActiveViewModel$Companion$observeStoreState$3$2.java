package com.discord.widgets.channels.threads.browser;

import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreThreadMessages$ThreadState;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function10;

/* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$3$2 extends o implements Function10<MeUser, Map<Long, ? extends User>, Map<Long, ? extends StoreThreadMessages$ThreadState>, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Map<Long, ? extends String>, Long, Map<Long, ? extends Integer>, Channel, Guild, WidgetThreadBrowserActiveViewModel$StoreState> {
    public final /* synthetic */ Map $activeJoinedThreads;
    public final /* synthetic */ Map $activeThreads;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$3$2(Map map, Map map2) {
        super(10);
        this.$activeJoinedThreads = map;
        this.$activeThreads = map2;
    }

    @Override // kotlin.jvm.functions.Function10
    public /* bridge */ /* synthetic */ WidgetThreadBrowserActiveViewModel$StoreState invoke(MeUser meUser, Map<Long, ? extends User> map, Map<Long, ? extends StoreThreadMessages$ThreadState> map2, Map<Long, ? extends GuildMember> map3, Map<Long, ? extends GuildRole> map4, Map<Long, ? extends String> map5, Long l, Map<Long, ? extends Integer> map6, Channel channel, Guild guild) {
        return invoke2(meUser, map, (Map<Long, StoreThreadMessages$ThreadState>) map2, (Map<Long, GuildMember>) map3, (Map<Long, GuildRole>) map4, (Map<Long, String>) map5, l, (Map<Long, Integer>) map6, channel, guild);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetThreadBrowserActiveViewModel$StoreState invoke2(MeUser meUser, Map<Long, ? extends User> map, Map<Long, StoreThreadMessages$ThreadState> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, Map<Long, String> map5, Long l, Map<Long, Integer> map6, Channel channel, Guild guild) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(map, "users");
        m.checkNotNullParameter(map2, "threadStates");
        m.checkNotNullParameter(map4, "guildRoles");
        m.checkNotNullParameter(map5, "channelNames");
        m.checkNotNullParameter(map6, "blockedUsers");
        Map map7 = this.$activeJoinedThreads;
        m.checkNotNullExpressionValue(map7, "activeJoinedThreads");
        Map map8 = this.$activeThreads;
        m.checkNotNullExpressionValue(map8, "activeThreads");
        m.checkNotNullExpressionValue(map3, "guildMembers");
        return new WidgetThreadBrowserActiveViewModel$StoreState(meUser, map7, map8, map2, map3, map, map4, map5, l, map6, channel, guild);
    }
}
