package com.discord.widgets.channels.permissions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.t.o;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import rx.functions.Func4;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragmentViewModel$Companion$observeStoreState$1$1<T1, T2, T3, T4, R> implements Func4<Guild, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Map<Long, ? extends User>, WidgetChannelSettingsAddMemberFragmentViewModel$StoreState> {
    public final /* synthetic */ Channel $channel;

    public WidgetChannelSettingsAddMemberFragmentViewModel$Companion$observeStoreState$1$1(Channel channel) {
        this.$channel = channel;
    }

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetChannelSettingsAddMemberFragmentViewModel$StoreState call(Guild guild, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends User> map3) {
        return call2(guild, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, map3);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelSettingsAddMemberFragmentViewModel$StoreState call2(Guild guild, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, ? extends User> map3) {
        Map mapEmptyMap;
        Channel channel = this.$channel;
        m.checkNotNullExpressionValue(channel, "channel");
        List<PermissionOverwrite> listV = this.$channel.v();
        if (listV != null) {
            mapEmptyMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(listV, 10)), 16));
            for (Object obj : listV) {
                mapEmptyMap.put(Long.valueOf(((PermissionOverwrite) obj).e()), obj);
            }
        } else {
            mapEmptyMap = h0.emptyMap();
        }
        m.checkNotNullExpressionValue(map, "roles");
        m.checkNotNullExpressionValue(map2, "members");
        m.checkNotNullExpressionValue(map3, "users");
        return new WidgetChannelSettingsAddMemberFragmentViewModel$StoreState(guild, channel, mapEmptyMap, map, map2, map3);
    }
}
