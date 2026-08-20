package com.discord.widgets.channels.memberlist;

import com.discord.C5419R;
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
import com.discord.stores.StoreStream;
import com.discord.utilities.collections.SparseMutableList;
import com.discord.utilities.lazy.memberlist.MemberList;
import com.discord.utilities.lazy.memberlist.MemberListRow;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import com.discord.widgets.forums.ForumUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import p507d0.p579g0.C12102s;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildMemberListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildMemberListItemGeneratorKt {
    private static final List<ChannelMembersListAdapter.Item.PlaceholderMember> PLACEHOLDER_INSTANCES = C12147n.listOf((Object[]) new ChannelMembersListAdapter.Item.PlaceholderMember[]{new ChannelMembersListAdapter.Item.PlaceholderMember(0.7f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.3f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.6f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.4f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.6f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.8f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.3f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.5f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.7f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.4f)});

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            MemberListRow.StatusHeader.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[MemberListRow.StatusHeader.Type.ONLINE.ordinal()] = 1;
            iArr[MemberListRow.StatusHeader.Type.OFFLINE.ordinal()] = 2;
        }
    }

    private static final boolean calculateCanDisplayStatusEmoji(StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, long j, Guild guild, Channel channel, Presence presence, Map<Long, GuildRole> map) {
        Activity customStatusActivity;
        ActivityEmoji emoji;
        String id2;
        Long longOrNull;
        long guildId = channel.getGuildId();
        if (PermissionUtils.can(Permission.USE_EXTERNAL_EMOJIS, Long.valueOf(PermissionUtils.computeNonThreadPermissions(j, channel.getGuildId(), guild != null ? guild.getOwnerId() : 0L, storeGuilds.getMember(guildId, j), map, channel.m7655v()))) || presence == null || (customStatusActivity = PresenceUtils.INSTANCE.getCustomStatusActivity(presence)) == null || (emoji = customStatusActivity.getEmoji()) == null || (id2 = emoji.getId()) == null || (longOrNull = C12102s.toLongOrNull(id2)) == null) {
            return true;
        }
        return storeEmojiCustom.getEmojiForGuild(guildId).get(Long.valueOf(longOrNull.longValue())) != null;
    }

    public static final WidgetChannelMembersListViewModel.MemberList generateGuildMemberListItems(MemberList memberList, Guild guild, Channel channel, Map<Long, GuildRole> map, boolean z2, boolean z3, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom) {
        C12238m.checkNotNullParameter(memberList, "channelMemberList");
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(map, "guildRoles");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(storeEmojiCustom, "storeCustomEmojis");
        SparseMutableList<R> sparseMutableListDeepCopy = memberList.getRows().deepCopy(new C7483xc234da7b(storeGuilds, storeEmojiCustom, guild, channel, map));
        if ((!sparseMutableListDeepCopy.isEmpty()) && C12163u.first((List) sparseMutableListDeepCopy) == null) {
            sparseMutableListDeepCopy.set(0, new ChannelMembersListAdapter.Item.PlaceholderHeader(memberList.getListId()));
        }
        SortedMap<Integer, String> groupIndices = memberList.getGroupIndices();
        int size = memberList.getSize();
        if (!z2) {
            if (ChannelUtils.m7673H(channel) && (!ChannelUtils.m7694r(channel, (1 & 1) != 0 ? StoreStream.INSTANCE.getChannels().getChannel(channel.getParentId()) : null) || !ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, 2, null))) {
                sparseMutableListDeepCopy.add(0, new ChannelMembersListAdapter.Item.JoinLeaveThread(memberList.getListId(), z3));
                LinkedHashMap linkedHashMap = new LinkedHashMap(C12134g0.mapCapacity(groupIndices.size()));
                Iterator<T> it = groupIndices.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(Integer.valueOf(((Number) entry.getKey()).intValue() + 1), entry.getValue());
                }
                groupIndices = C12134g0.toSortedMap(linkedHashMap);
            }
            return new GuildMemberListItems(memberList.getListId(), size, sparseMutableListDeepCopy, groupIndices);
        }
        sparseMutableListDeepCopy.add(0, new ChannelMembersListAdapter.Item.AddMember(memberList.getListId(), C5419R.string.invite_members));
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(C12134g0.mapCapacity(groupIndices.size()));
        Iterator<T> it2 = groupIndices.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            linkedHashMap2.put(Integer.valueOf(((Number) entry2.getKey()).intValue() + 1), entry2.getValue());
        }
        groupIndices = C12134g0.toSortedMap(linkedHashMap2);
        size++;
        return new GuildMemberListItems(memberList.getListId(), size, sparseMutableListDeepCopy, groupIndices);
    }
}
