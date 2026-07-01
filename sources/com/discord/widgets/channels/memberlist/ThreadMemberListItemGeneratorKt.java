package com.discord.widgets.channels.memberlist;

import com.discord.api.channel.Channel;
import com.discord.api.presence.ClientStatus;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreChannelMembers;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreThreadsJoined$JoinedThread;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.lazy.memberlist.MemberListRow$Member;
import com.discord.utilities.lazy.memberlist.MemberListRow$RoleHeader;
import com.discord.utilities.lazy.memberlist.MemberListRow$StatusHeader;
import com.discord.utilities.lazy.memberlist.MemberListRow$StatusHeader$Type;
import com.discord.utilities.lazy.memberlist.ThreadMemberList;
import d0.t.m0;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: ThreadMemberListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ThreadMemberListItemGeneratorKt {
    private static final Comparator<MemberListRow$Member> ALPHABETICAL_COMPARATOR = ThreadMemberListItemGeneratorKt$ALPHABETICAL_COMPARATOR$1.INSTANCE;

    public static final ThreadMemberList createThreadMemberList(String str, Map<Long, GuildRole> map, LinkedHashMap<Long, SortedSet<MemberListRow$Member>> linkedHashMap) {
        String name;
        m.checkNotNullParameter(str, "listId");
        m.checkNotNullParameter(map, "roles");
        m.checkNotNullParameter(linkedHashMap, "threadMemberMap");
        int i = 0;
        ThreadMemberList threadMemberList = new ThreadMemberList(str, 0, 2, null);
        for (Map$Entry<Long, SortedSet<MemberListRow$Member>> map$Entry : linkedHashMap.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            SortedSet<MemberListRow$Member> value = map$Entry.getValue();
            if (!value.isEmpty()) {
                MemberListRow$StatusHeader$Type memberListRow$StatusHeader$Type = MemberListRow$StatusHeader$Type.ONLINE;
                if (jLongValue == memberListRow$StatusHeader$Type.getId()) {
                    threadMemberList.add(new MemberListRow$StatusHeader(memberListRow$StatusHeader$Type.name(), memberListRow$StatusHeader$Type, value.size()));
                } else {
                    MemberListRow$StatusHeader$Type memberListRow$StatusHeader$Type2 = MemberListRow$StatusHeader$Type.OFFLINE;
                    if (jLongValue == memberListRow$StatusHeader$Type2.getId()) {
                        threadMemberList.add(new MemberListRow$StatusHeader(memberListRow$StatusHeader$Type2.name(), memberListRow$StatusHeader$Type2, value.size()));
                    } else {
                        GuildRole guildRole = map.get(Long.valueOf(jLongValue));
                        if (guildRole == null || (name = guildRole.getName()) == null) {
                            name = "";
                        }
                        threadMemberList.add(new MemberListRow$RoleHeader(jLongValue, name, value.size()));
                    }
                }
                threadMemberList.getGroupIndices().put(Integer.valueOf(i), String.valueOf(jLongValue));
                int size = value.size() + 1 + i;
                Iterator<T> it = value.iterator();
                while (it.hasNext()) {
                    threadMemberList.add((MemberListRow$Member) it.next());
                }
                i = size;
            }
        }
        return threadMemberList;
    }

    public static final WidgetChannelMembersListViewModel$MemberList generateThreadMemberListItems(Channel channel, Map<Long, GuildRole> map, Guild guild, Map<Long, GuildMember> map2, Map<Long, ? extends User> map3, Map<Long, Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, Set<Long> set, StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom) {
        Map<Long, Presence> map6 = map4;
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(map, "roles");
        m.checkNotNullParameter(map2, "guildMembers");
        m.checkNotNullParameter(map3, "users");
        m.checkNotNullParameter(map6, "presences");
        m.checkNotNullParameter(map5, "streams");
        m.checkNotNullParameter(set, "threadMembers");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeEmojiCustom, "storeEmojiCustom");
        boolean z2 = storeThreadsJoined$JoinedThread != null;
        if (set.isEmpty()) {
            return GuildMemberListItemGeneratorKt.generateGuildMemberListItems(new ThreadMemberList(String.valueOf(channel.getId()), map2.size()), guild, channel, map, false, z2, storeGuilds, storeEmojiCustom);
        }
        LinkedHashMap<Long, SortedSet<MemberListRow$Member>> linkedHashMapInitializeOrderedMap = initializeOrderedMap(map);
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            LinkedHashMap<Long, SortedSet<MemberListRow$Member>> linkedHashMap = linkedHashMapInitializeOrderedMap;
            MemberListRow$Member memberListRow$MemberMakeRowMember = StoreChannelMembers.Companion.makeRowMember(jLongValue, map2, map3, map6.get(Long.valueOf(jLongValue)), map5.containsKey(Long.valueOf(jLongValue)), false);
            if (memberListRow$MemberMakeRowMember != null) {
                insertMemberIntoMap(memberListRow$MemberMakeRowMember, map2, map, linkedHashMap);
            }
            linkedHashMapInitializeOrderedMap = linkedHashMap;
            map6 = map4;
        }
        return GuildMemberListItemGeneratorKt.generateGuildMemberListItems(createThreadMemberList(String.valueOf(channel.getId()), map, linkedHashMapInitializeOrderedMap), guild, channel, map, false, z2, storeGuilds, storeEmojiCustom);
    }

    public static final Comparator<MemberListRow$Member> getALPHABETICAL_COMPARATOR() {
        return ALPHABETICAL_COMPARATOR;
    }

    private static final LinkedHashMap<Long, SortedSet<MemberListRow$Member>> initializeOrderedMap(Map<Long, GuildRole> map) {
        LinkedHashMap<Long, SortedSet<MemberListRow$Member>> linkedHashMap = new LinkedHashMap<>();
        Collection<GuildRole> collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((GuildRole) obj).getHoist()) {
                arrayList.add(obj);
            }
        }
        Iterator it = u.sortedWith(arrayList, RoleUtils.getROLE_COMPARATOR()).iterator();
        while (it.hasNext()) {
            linkedHashMap.put(Long.valueOf(((GuildRole) it.next()).getId()), m0.sortedSetOf(ALPHABETICAL_COMPARATOR, new MemberListRow$Member[0]));
        }
        Long lValueOf = Long.valueOf(MemberListRow$StatusHeader$Type.ONLINE.getId());
        Comparator<MemberListRow$Member> comparator = ALPHABETICAL_COMPARATOR;
        linkedHashMap.put(lValueOf, m0.sortedSetOf(comparator, new MemberListRow$Member[0]));
        linkedHashMap.put(Long.valueOf(MemberListRow$StatusHeader$Type.OFFLINE.getId()), m0.sortedSetOf(comparator, new MemberListRow$Member[0]));
        return linkedHashMap;
    }

    private static final void insertMemberIntoMap(MemberListRow$Member memberListRow$Member, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, LinkedHashMap<Long, SortedSet<MemberListRow$Member>> linkedHashMap) {
        SortedSet<MemberListRow$Member> sortedSet;
        GuildMember guildMember = map.get(Long.valueOf(memberListRow$Member.getUserId()));
        Presence presence = memberListRow$Member.getPresence();
        boolean z2 = false;
        boolean z3 = (presence != null ? presence.getStatus() : null) == null || memberListRow$Member.getPresence().getStatus() == ClientStatus.INVISIBLE || memberListRow$Member.getPresence().getStatus() == ClientStatus.OFFLINE;
        if ((guildMember != null ? Long.valueOf(guildMember.getHoistRoleId()) : null) != null && guildMember.getHoistRoleId() != 0) {
            z2 = true;
        }
        if (z3) {
            MemberListRow$StatusHeader$Type memberListRow$StatusHeader$Type = MemberListRow$StatusHeader$Type.OFFLINE;
            SortedSet<MemberListRow$Member> sortedSet2 = linkedHashMap.get(Long.valueOf(memberListRow$StatusHeader$Type.getId()));
            if (sortedSet2 != null) {
                sortedSet2.add(memberListRow$Member);
                linkedHashMap.put(Long.valueOf(memberListRow$StatusHeader$Type.getId()), sortedSet2);
                return;
            }
        } else if (z2) {
            GuildRole guildRole = map2.get(guildMember != null ? Long.valueOf(guildMember.getHoistRoleId()) : null);
            if (guildRole != null && (sortedSet = linkedHashMap.get(Long.valueOf(guildRole.getId()))) != null) {
                sortedSet.add(memberListRow$Member);
                linkedHashMap.put(Long.valueOf(guildRole.getId()), sortedSet);
                return;
            }
        }
        MemberListRow$StatusHeader$Type memberListRow$StatusHeader$Type2 = MemberListRow$StatusHeader$Type.ONLINE;
        SortedSet<MemberListRow$Member> sortedSet3 = linkedHashMap.get(Long.valueOf(memberListRow$StatusHeader$Type2.getId()));
        if (sortedSet3 != null) {
            sortedSet3.add(memberListRow$Member);
            linkedHashMap.put(Long.valueOf(memberListRow$StatusHeader$Type2.getId()), sortedSet3);
        }
    }
}
