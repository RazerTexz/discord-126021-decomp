package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.Channel$Companion;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.channel.ChannelUtils$getSortByMostRecent$1;
import com.discord.models.user.User;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.functions.Func3;

/* JADX INFO: compiled from: InviteSuggestionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteSuggestionsManager$observeInviteSuggestions$2<T1, T2, T3, R> implements Func3<Map<Long, ? extends Channel>, Map<Long, ? extends Long>, InviteSuggestionsManager$UserAffinityData, List<? extends InviteSuggestion>> {
    public static final InviteSuggestionsManager$observeInviteSuggestions$2 INSTANCE = new InviteSuggestionsManager$observeInviteSuggestions$2();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ List<? extends InviteSuggestion> call(Map<Long, ? extends Channel> map, Map<Long, ? extends Long> map2, InviteSuggestionsManager$UserAffinityData inviteSuggestionsManager$UserAffinityData) {
        return call2((Map<Long, Channel>) map, (Map<Long, Long>) map2, inviteSuggestionsManager$UserAffinityData);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<InviteSuggestion> call2(Map<Long, Channel> map, Map<Long, Long> map2, InviteSuggestionsManager$UserAffinityData inviteSuggestionsManager$UserAffinityData) {
        User userA;
        ArrayList arrayList = new ArrayList();
        Collection<Channel> collectionValues = map.values();
        Channel$Companion channel$Companion = Channel.Companion;
        m.checkNotNullExpressionValue(map2, "mostRecentMessages");
        m.checkNotNullParameter(channel$Companion, "$this$getSortByMostRecent");
        m.checkNotNullParameter(map2, "mostRecentMessageIds");
        List listSortedWith = u.sortedWith(collectionValues, new ChannelUtils$getSortByMostRecent$1(map2));
        Channel channel = listSortedWith.isEmpty() ^ true ? (Channel) listSortedWith.get(0) : null;
        if (channel != null) {
            arrayList.add(new InviteSuggestion$ChannelItem(channel));
        }
        List<Long> userIds = inviteSuggestionsManager$UserAffinityData.getUserIds();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = userIds.iterator();
        while (it.hasNext()) {
            User user = inviteSuggestionsManager$UserAffinityData.getUsers().get(Long.valueOf(((Number) it.next()).longValue()));
            if (user != null) {
                arrayList2.add(user);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            User user2 = (User) obj;
            Integer num = (Integer) a.f(user2, inviteSuggestionsManager$UserAffinityData.getRelationships());
            if (!(!(channel == null || (userA = ChannelUtils.a(channel)) == null || userA.getId() != user2.getId()) || (num != null && num.intValue() == 2))) {
                arrayList3.add(obj);
            }
        }
        List listDistinct = u.distinct(arrayList3);
        Iterator it2 = listDistinct.iterator();
        while (it2.hasNext()) {
            arrayList.add(new InviteSuggestion$UserSuggestion((User) it2.next()));
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : listSortedWith) {
            Channel channel2 = (Channel) obj2;
            if ((m.areEqual(channel, channel2) ^ true) && (ChannelUtils.a(channel2) == null || !u.contains(listDistinct, ChannelUtils.a(channel2)))) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList(o.collectionSizeOrDefault(arrayList4, 10));
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            arrayList5.add(Boolean.valueOf(arrayList.add(new InviteSuggestion$ChannelItem((Channel) it3.next()))));
        }
        return arrayList;
    }
}
