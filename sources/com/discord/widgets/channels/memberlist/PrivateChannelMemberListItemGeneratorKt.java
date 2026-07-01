package com.discord.widgets.channels.memberlist;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelRecipientNick;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item$AddMember;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item$Header;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item$Header$Type;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$Item$Member;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/* JADX INFO: compiled from: PrivateChannelMemberListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivateChannelMemberListItemGeneratorKt {
    private static final ChannelMembersListAdapter$Item$Header createGroupDmHeader(int i) {
        return new ChannelMembersListAdapter$Item$Header("%group_header_key", ChannelMembersListAdapter$Item$Header$Type.GROUP_DM, i);
    }

    private static final ChannelMembersListAdapter$Item$Member createMemberListItem(User user, Presence presence, boolean z2, String str, boolean z3) {
        return new ChannelMembersListAdapter$Item$Member(user.getId(), null, str != null ? str : user.getUsername(), user.getIsBot(), Integer.valueOf(user.getIsSystemUser() ? 2131896165 : 2131887282), UserUtils.INSTANCE.isVerifiedBot(user), presence, null, IconUtils.getForUser$default(user, false, null, 6, null), z2, null, z3, true, user.getFlags() | user.getPublicFlags());
    }

    public static final WidgetChannelMembersListViewModel$MemberList generateGroupDmMemberListItems(Channel channel, Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3, boolean z2) {
        Object next;
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(map, "users");
        m.checkNotNullParameter(map2, "presences");
        m.checkNotNullParameter(map3, "applicationStreams");
        PrivateChannelMemberListItemGeneratorKt$generateGroupDmMemberListItems$memberItems$1 privateChannelMemberListItemGeneratorKt$generateGroupDmMemberListItems$memberItems$1 = PrivateChannelMemberListItemGeneratorKt$generateGroupDmMemberListItems$memberItems$1.INSTANCE;
        Object privateChannelMemberListItemGeneratorKt$sam$java_util_Comparator$0 = privateChannelMemberListItemGeneratorKt$generateGroupDmMemberListItems$memberItems$1;
        if (privateChannelMemberListItemGeneratorKt$generateGroupDmMemberListItems$memberItems$1 != null) {
            privateChannelMemberListItemGeneratorKt$sam$java_util_Comparator$0 = new PrivateChannelMemberListItemGeneratorKt$sam$java_util_Comparator$0(privateChannelMemberListItemGeneratorKt$generateGroupDmMemberListItems$memberItems$1);
        }
        TreeMap treeMap = new TreeMap((Comparator) privateChannelMemberListItemGeneratorKt$sam$java_util_Comparator$0);
        Iterator<T> it = map.values().iterator();
        while (true) {
            boolean z3 = false;
            if (!it.hasNext()) {
                break;
            }
            User user = (User) it.next();
            StringBuilder sb = new StringBuilder();
            String username = user.getUsername();
            Locale locale = Locale.ROOT;
            m.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(username, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = username.toLowerCase(locale);
            m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            sb.append(lowerCase);
            sb.append(UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
            String string = sb.toString();
            List<ChannelRecipientNick> listQ = channel.q();
            String nick = null;
            if (listQ != null) {
                Iterator<T> it2 = listQ.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (!(((ChannelRecipientNick) next).b() == user.getId()));
                ChannelRecipientNick channelRecipientNick = (ChannelRecipientNick) next;
                if (channelRecipientNick != null) {
                    nick = channelRecipientNick.getNick();
                }
            }
            if (channel.getOwnerId() == user.getId()) {
                z3 = true;
            }
            treeMap.put(string, createMemberListItem(user, (Presence) a.f(user, map2), z3, nick, map3.containsKey(Long.valueOf(user.getId()))));
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size + 1);
        if (z2) {
            arrayList.add(0, new ChannelMembersListAdapter$Item$AddMember(String.valueOf(channel.getId()), ChannelUtils.p(channel) ? 2131889802 : 2131888235));
        }
        arrayList.add(createGroupDmHeader(size));
        arrayList.addAll(treeMap.values());
        return new PrivateChannelMemberListItems(String.valueOf(channel.getId()), arrayList);
    }
}
