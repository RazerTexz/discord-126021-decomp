package com.discord.widgets.channels.memberlist;

import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelRecipientNick;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PrivateChannelMemberListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivateChannelMemberListItemGeneratorKt {
    private static final ChannelMembersListAdapter.Item.Header createGroupDmHeader(int i) {
        return new ChannelMembersListAdapter.Item.Header("%group_header_key", ChannelMembersListAdapter.Item.Header.Type.GROUP_DM, i);
    }

    private static final ChannelMembersListAdapter.Item.Member createMemberListItem(User user, Presence presence, boolean z2, String str, boolean z3) {
        return new ChannelMembersListAdapter.Item.Member(user.getId(), null, str != null ? str : user.getUsername(), user.getIsBot(), Integer.valueOf(user.getIsSystemUser() ? C5419R.string.system_dm_tag_system : C5419R.string.bot_tag_bot), UserUtils.INSTANCE.isVerifiedBot(user), presence, null, IconUtils.getForUser$default(user, false, null, 6, null), z2, null, z3, true, user.getFlags() | user.getPublicFlags());
    }

    public static final WidgetChannelMembersListViewModel.MemberList generateGroupDmMemberListItems(Channel channel, Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3, boolean z2) {
        Object next;
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(map, "users");
        C12238m.checkNotNullParameter(map2, "presences");
        C12238m.checkNotNullParameter(map3, "applicationStreams");
        final C7484xdf5d5077 c7484xdf5d5077 = C7484xdf5d5077.INSTANCE;
        Object obj = c7484xdf5d5077;
        if (c7484xdf5d5077 != null) {
            obj = new Comparator() { // from class: com.discord.widgets.channels.memberlist.PrivateChannelMemberListItemGeneratorKt$sam$java_util_Comparator$0
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(Object obj2, Object obj3) {
                    Object objInvoke = c7484xdf5d5077.invoke(obj2, obj3);
                    C12238m.checkNotNullExpressionValue(objInvoke, "invoke(...)");
                    return ((Number) objInvoke).intValue();
                }
            };
        }
        TreeMap treeMap = new TreeMap((Comparator) obj);
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
            C12238m.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(username, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = username.toLowerCase(locale);
            C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            sb.append(lowerCase);
            sb.append(UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
            String string = sb.toString();
            List<ChannelRecipientNick> listM7650q = channel.m7650q();
            String nick = null;
            if (listM7650q != null) {
                Iterator<T> it2 = listM7650q.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (!(((ChannelRecipientNick) next).m7664b() == user.getId()));
                ChannelRecipientNick channelRecipientNick = (ChannelRecipientNick) next;
                if (channelRecipientNick != null) {
                    nick = channelRecipientNick.getNick();
                }
            }
            if (channel.getOwnerId() == user.getId()) {
                z3 = true;
            }
            treeMap.put(string, createMemberListItem(user, (Presence) C1643a.m849f(user, map2), z3, nick, map3.containsKey(Long.valueOf(user.getId()))));
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size + 1);
        if (z2) {
            arrayList.add(0, new ChannelMembersListAdapter.Item.AddMember(String.valueOf(channel.getId()), ChannelUtils.m7692p(channel) ? C5419R.string.group_dm_add_friends : C5419R.string.create_group_dm));
        }
        arrayList.add(createGroupDmHeader(size));
        arrayList.addAll(treeMap.values());
        return new PrivateChannelMemberListItems(String.valueOf(channel.getId()), arrayList);
    }
}
