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
import com.discord.stores.StoreThreadsJoined;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.lazy.memberlist.MemberListRow;
import com.discord.utilities.lazy.memberlist.ThreadMemberList;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.ThreadMemberListItemGeneratorKt, reason: use source file name */
/* JADX INFO: compiled from: ThreadMemberListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ThreadMemberListItemGenerator {
    private static final Comparator<MemberListRow.Member> ALPHABETICAL_COMPARATOR = new Comparator<MemberListRow.Member>() { // from class: com.discord.widgets.channels.memberlist.ThreadMemberListItemGeneratorKt$ALPHABETICAL_COMPARATOR$1
        @Override // java.util.Comparator
        public final int compare(MemberListRow.Member member, MemberListRow.Member member2) {
            return member.getName().compareTo(member2.getName());
        }
    };

    public static final ThreadMemberList createThreadMemberList(String str, Map<Long, GuildRole> map, LinkedHashMap<Long, SortedSet<MemberListRow.Member>> linkedHashMap) {
        String name;
        Intrinsics3.checkNotNullParameter(str, "listId");
        Intrinsics3.checkNotNullParameter(map, "roles");
        Intrinsics3.checkNotNullParameter(linkedHashMap, "threadMemberMap");
        int i = 0;
        ThreadMemberList threadMemberList = new ThreadMemberList(str, 0, 2, null);
        for (Map.Entry<Long, SortedSet<MemberListRow.Member>> entry : linkedHashMap.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            SortedSet<MemberListRow.Member> value = entry.getValue();
            if (!value.isEmpty()) {
                MemberListRow.StatusHeader.Type type = MemberListRow.StatusHeader.Type.ONLINE;
                if (jLongValue == type.getId()) {
                    threadMemberList.add(new MemberListRow.StatusHeader(type.name(), type, value.size()));
                } else {
                    MemberListRow.StatusHeader.Type type2 = MemberListRow.StatusHeader.Type.OFFLINE;
                    if (jLongValue == type2.getId()) {
                        threadMemberList.add(new MemberListRow.StatusHeader(type2.name(), type2, value.size()));
                    } else {
                        GuildRole guildRole = map.get(Long.valueOf(jLongValue));
                        if (guildRole == null || (name = guildRole.getName()) == null) {
                            name = "";
                        }
                        threadMemberList.add(new MemberListRow.RoleHeader(jLongValue, name, value.size()));
                    }
                }
                threadMemberList.getGroupIndices().put(Integer.valueOf(i), String.valueOf(jLongValue));
                int size = value.size() + 1 + i;
                Iterator<T> it = value.iterator();
                while (it.hasNext()) {
                    threadMemberList.add((MemberListRow.Member) it.next());
                }
                i = size;
            }
        }
        return threadMemberList;
    }

    public static final WidgetChannelMembersListViewModel.MemberList generateThreadMemberListItems(Channel channel, Map<Long, GuildRole> map, Guild guild, Map<Long, GuildMember> map2, Map<Long, ? extends User> map3, Map<Long, Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, Set<Long> set, StoreThreadsJoined.JoinedThread joinedThread, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom) {
        Map<Long, Presence> map6 = map4;
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(map, "roles");
        Intrinsics3.checkNotNullParameter(map2, "guildMembers");
        Intrinsics3.checkNotNullParameter(map3, "users");
        Intrinsics3.checkNotNullParameter(map6, "presences");
        Intrinsics3.checkNotNullParameter(map5, "streams");
        Intrinsics3.checkNotNullParameter(set, "threadMembers");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeEmojiCustom, "storeEmojiCustom");
        boolean z2 = joinedThread != null;
        if (set.isEmpty()) {
            return GuildMemberListItemGenerator.generateGuildMemberListItems(new ThreadMemberList(String.valueOf(channel.getId()), map2.size()), guild, channel, map, false, z2, storeGuilds, storeEmojiCustom);
        }
        LinkedHashMap<Long, SortedSet<MemberListRow.Member>> linkedHashMapInitializeOrderedMap = initializeOrderedMap(map);
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            LinkedHashMap<Long, SortedSet<MemberListRow.Member>> linkedHashMap = linkedHashMapInitializeOrderedMap;
            MemberListRow.Member memberMakeRowMember = StoreChannelMembers.INSTANCE.makeRowMember(jLongValue, map2, map3, map6.get(Long.valueOf(jLongValue)), map5.containsKey(Long.valueOf(jLongValue)), false);
            if (memberMakeRowMember != null) {
                insertMemberIntoMap(memberMakeRowMember, map2, map, linkedHashMap);
            }
            linkedHashMapInitializeOrderedMap = linkedHashMap;
            map6 = map4;
        }
        return GuildMemberListItemGenerator.generateGuildMemberListItems(createThreadMemberList(String.valueOf(channel.getId()), map, linkedHashMapInitializeOrderedMap), guild, channel, map, false, z2, storeGuilds, storeEmojiCustom);
    }

    public static final Comparator<MemberListRow.Member> getALPHABETICAL_COMPARATOR() {
        return ALPHABETICAL_COMPARATOR;
    }

    private static final LinkedHashMap<Long, SortedSet<MemberListRow.Member>> initializeOrderedMap(Map<Long, GuildRole> map) {
        LinkedHashMap<Long, SortedSet<MemberListRow.Member>> linkedHashMap = new LinkedHashMap<>();
        Collection<GuildRole> collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((GuildRole) obj).getHoist()) {
                arrayList.add(obj);
            }
        }
        Iterator it = _Collections.sortedWith(arrayList, RoleUtils.getROLE_COMPARATOR()).iterator();
        while (it.hasNext()) {
            linkedHashMap.put(Long.valueOf(((GuildRole) it.next()).getId()), SetsJVM.sortedSetOf(ALPHABETICAL_COMPARATOR, new MemberListRow.Member[0]));
        }
        Long lValueOf = Long.valueOf(MemberListRow.StatusHeader.Type.ONLINE.getId());
        Comparator<MemberListRow.Member> comparator = ALPHABETICAL_COMPARATOR;
        linkedHashMap.put(lValueOf, SetsJVM.sortedSetOf(comparator, new MemberListRow.Member[0]));
        linkedHashMap.put(Long.valueOf(MemberListRow.StatusHeader.Type.OFFLINE.getId()), SetsJVM.sortedSetOf(comparator, new MemberListRow.Member[0]));
        return linkedHashMap;
    }

    private static final void insertMemberIntoMap(MemberListRow.Member member, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, LinkedHashMap<Long, SortedSet<MemberListRow.Member>> linkedHashMap) {
        SortedSet<MemberListRow.Member> sortedSet;
        GuildMember guildMember = map.get(Long.valueOf(member.getUserId()));
        Presence presence = member.getPresence();
        boolean z2 = false;
        boolean z3 = (presence != null ? presence.getStatus() : null) == null || member.getPresence().getStatus() == ClientStatus.INVISIBLE || member.getPresence().getStatus() == ClientStatus.OFFLINE;
        if ((guildMember != null ? Long.valueOf(guildMember.getHoistRoleId()) : null) != null && guildMember.getHoistRoleId() != 0) {
            z2 = true;
        }
        if (z3) {
            MemberListRow.StatusHeader.Type type = MemberListRow.StatusHeader.Type.OFFLINE;
            SortedSet<MemberListRow.Member> sortedSet2 = linkedHashMap.get(Long.valueOf(type.getId()));
            if (sortedSet2 != null) {
                sortedSet2.add(member);
                linkedHashMap.put(Long.valueOf(type.getId()), sortedSet2);
                return;
            }
        } else if (z2) {
            GuildRole guildRole = map2.get(guildMember != null ? Long.valueOf(guildMember.getHoistRoleId()) : null);
            if (guildRole != null && (sortedSet = linkedHashMap.get(Long.valueOf(guildRole.getId()))) != null) {
                sortedSet.add(member);
                linkedHashMap.put(Long.valueOf(guildRole.getId()), sortedSet);
                return;
            }
        }
        MemberListRow.StatusHeader.Type type2 = MemberListRow.StatusHeader.Type.ONLINE;
        SortedSet<MemberListRow.Member> sortedSet3 = linkedHashMap.get(Long.valueOf(type2.getId()));
        if (sortedSet3 != null) {
            sortedSet3.add(member);
            linkedHashMap.put(Long.valueOf(type2.getId()), sortedSet3);
        }
    }
}
