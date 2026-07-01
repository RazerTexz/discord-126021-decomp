package com.discord.widgets.channels.memberlist;

import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityEmoji;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.utilities.collections.SparseMutableList;
import com.discord.utilities.lazy.memberlist.MemberList;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item$AddMember;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item$JoinLeaveThread;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item$PlaceholderHeader;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item$PlaceholderMember;
import com.discord.widgets.forums.ForumUtils;
import d0.g0.s;
import d0.t.g0;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.SortedMap;

/* JADX INFO: compiled from: GuildMemberListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildMemberListItemGeneratorKt {
    private static final List<ChannelMembersListAdapter$Item$PlaceholderMember> PLACEHOLDER_INSTANCES = n.listOf((Object[]) new ChannelMembersListAdapter$Item$PlaceholderMember[]{new ChannelMembersListAdapter$Item$PlaceholderMember(0.7f), new ChannelMembersListAdapter$Item$PlaceholderMember(0.3f), new ChannelMembersListAdapter$Item$PlaceholderMember(0.6f), new ChannelMembersListAdapter$Item$PlaceholderMember(0.4f), new ChannelMembersListAdapter$Item$PlaceholderMember(0.6f), new ChannelMembersListAdapter$Item$PlaceholderMember(0.8f), new ChannelMembersListAdapter$Item$PlaceholderMember(0.3f), new ChannelMembersListAdapter$Item$PlaceholderMember(0.5f), new ChannelMembersListAdapter$Item$PlaceholderMember(0.7f), new ChannelMembersListAdapter$Item$PlaceholderMember(0.4f)});

    public static final /* synthetic */ boolean access$calculateCanDisplayStatusEmoji(StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, long j, Guild guild, Channel channel, Presence presence, Map map) {
        return calculateCanDisplayStatusEmoji(storeGuilds, storeEmojiCustom, j, guild, channel, presence, map);
    }

    public static final /* synthetic */ List access$getPLACEHOLDER_INSTANCES$p() {
        return PLACEHOLDER_INSTANCES;
    }

    private static final boolean calculateCanDisplayStatusEmoji(StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, long j, Guild guild, Channel channel, Presence presence, Map<Long, GuildRole> map) {
        Activity customStatusActivity;
        ActivityEmoji emoji;
        String id2;
        Long longOrNull;
        long guildId = channel.getGuildId();
        if (PermissionUtils.can(Permission.USE_EXTERNAL_EMOJIS, Long.valueOf(PermissionUtils.computeNonThreadPermissions(j, channel.getGuildId(), guild != null ? guild.getOwnerId() : 0L, storeGuilds.getMember(guildId, j), map, channel.v()))) || presence == null || (customStatusActivity = PresenceUtils.INSTANCE.getCustomStatusActivity(presence)) == null || (emoji = customStatusActivity.getEmoji()) == null || (id2 = emoji.getId()) == null || (longOrNull = s.toLongOrNull(id2)) == null) {
            return true;
        }
        return storeEmojiCustom.getEmojiForGuild(guildId).get(Long.valueOf(longOrNull.longValue())) != null;
    }

    public static final WidgetChannelMembersListViewModel$MemberList generateGuildMemberListItems(MemberList memberList, Guild guild, Channel channel, Map<Long, GuildRole> map, boolean z2, boolean z3, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom) {
        m.checkNotNullParameter(memberList, "channelMemberList");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(map, "guildRoles");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeEmojiCustom, "storeCustomEmojis");
        SparseMutableList<R> sparseMutableListDeepCopy = memberList.getRows().deepCopy(new GuildMemberListItemGeneratorKt$generateGuildMemberListItems$listItems$1(storeGuilds, storeEmojiCustom, guild, channel, map));
        if ((!sparseMutableListDeepCopy.isEmpty()) && u.first((List) sparseMutableListDeepCopy) == null) {
            sparseMutableListDeepCopy.set(0, new ChannelMembersListAdapter$Item$PlaceholderHeader(memberList.getListId()));
        }
        SortedMap<Integer, String> groupIndices = memberList.getGroupIndices();
        int size = memberList.getSize();
        if (!z2) {
            if (ChannelUtils.H(channel) && (!ChannelUtils.s(channel, null, 1) || !ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, 2, null))) {
                sparseMutableListDeepCopy.add(0, new ChannelMembersListAdapter$Item$JoinLeaveThread(memberList.getListId(), z3));
                LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(groupIndices.size()));
                Iterator<T> it = groupIndices.entrySet().iterator();
                while (it.hasNext()) {
                    Map$Entry map$Entry = (Map$Entry) it.next();
                    linkedHashMap.put(Integer.valueOf(((Number) map$Entry.getKey()).intValue() + 1), map$Entry.getValue());
                }
                groupIndices = g0.toSortedMap(linkedHashMap);
            }
            return new GuildMemberListItems(memberList.getListId(), size, sparseMutableListDeepCopy, groupIndices);
        }
        sparseMutableListDeepCopy.add(0, new ChannelMembersListAdapter$Item$AddMember(memberList.getListId(), 2131892303));
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(groupIndices.size()));
        Iterator<T> it2 = groupIndices.entrySet().iterator();
        while (it2.hasNext()) {
            Map$Entry map$Entry2 = (Map$Entry) it2.next();
            linkedHashMap2.put(Integer.valueOf(((Number) map$Entry2.getKey()).intValue() + 1), map$Entry2.getValue());
        }
        groupIndices = g0.toSortedMap(linkedHashMap2);
        size++;
        return new GuildMemberListItems(memberList.getListId(), size, sparseMutableListDeepCopy, groupIndices);
    }
}
