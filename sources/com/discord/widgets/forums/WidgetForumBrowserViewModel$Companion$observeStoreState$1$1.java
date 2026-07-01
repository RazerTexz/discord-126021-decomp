package com.discord.widgets.forums;

import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState;
import com.discord.stores.StoreThreadMessages$ThreadState;
import com.discord.utilities.permissions.PermissionUtils;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.jvm.functions.Function17;

/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel$Companion$observeStoreState$1$1 extends o implements Function17<MeUser, Map<Long, ? extends User>, ArchivedThreadsStore$ThreadListingState, Map<Long, ? extends String>, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Map<Long, ? extends Message>, Map<Long, ? extends StoreThreadMessages$ThreadState>, Map<Long, ? extends Integer>, Long, Map<Long, ? extends Long>, EmojiSet, Map<Long, ? extends ForumPostReadState>, Map<Long, ? extends Integer>, Set<? extends Long>, Boolean, Map<Long, ? extends Set<? extends Long>>, WidgetForumBrowserViewModel$StoreState$Loaded> {
    public final /* synthetic */ Map $activeThreads;
    public final /* synthetic */ Channel $parentChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserViewModel$Companion$observeStoreState$1$1(Map map, Channel channel) {
        super(17);
        this.$activeThreads = map;
        this.$parentChannel = channel;
    }

    @Override // kotlin.jvm.functions.Function17
    public /* bridge */ /* synthetic */ WidgetForumBrowserViewModel$StoreState$Loaded invoke(MeUser meUser, Map<Long, ? extends User> map, ArchivedThreadsStore$ThreadListingState archivedThreadsStore$ThreadListingState, Map<Long, ? extends String> map2, Map<Long, ? extends GuildMember> map3, Map<Long, ? extends GuildRole> map4, Map<Long, ? extends Message> map5, Map<Long, ? extends StoreThreadMessages$ThreadState> map6, Map<Long, ? extends Integer> map7, Long l, Map<Long, ? extends Long> map8, EmojiSet emojiSet, Map<Long, ? extends ForumPostReadState> map9, Map<Long, ? extends Integer> map10, Set<? extends Long> set, Boolean bool, Map<Long, ? extends Set<? extends Long>> map11) {
        return invoke(meUser, map, archivedThreadsStore$ThreadListingState, (Map<Long, String>) map2, (Map<Long, GuildMember>) map3, (Map<Long, GuildRole>) map4, (Map<Long, Message>) map5, (Map<Long, StoreThreadMessages$ThreadState>) map6, (Map<Long, Integer>) map7, l, (Map<Long, Long>) map8, emojiSet, (Map<Long, ForumPostReadState>) map9, (Map<Long, Integer>) map10, (Set<Long>) set, bool.booleanValue(), (Map<Long, ? extends Set<Long>>) map11);
    }

    public final WidgetForumBrowserViewModel$StoreState$Loaded invoke(MeUser meUser, Map<Long, ? extends User> map, ArchivedThreadsStore$ThreadListingState archivedThreadsStore$ThreadListingState, Map<Long, String> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, Map<Long, Message> map5, Map<Long, StoreThreadMessages$ThreadState> map6, Map<Long, Integer> map7, Long l, Map<Long, Long> map8, EmojiSet emojiSet, Map<Long, ForumPostReadState> map9, Map<Long, Integer> map10, Set<Long> set, boolean z2, Map<Long, ? extends Set<Long>> map11) {
        WidgetForumBrowserViewModel$Companion$observeStoreState$1$1 widgetForumBrowserViewModel$Companion$observeStoreState$1$1 = this;
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(map, "users");
        m.checkNotNullParameter(archivedThreadsStore$ThreadListingState, "archivedThreadsState");
        m.checkNotNullParameter(map2, "channelNames");
        m.checkNotNullParameter(map4, "guildRoles");
        m.checkNotNullParameter(map5, "forumPostFirstMessages");
        m.checkNotNullParameter(map6, "forumPostMessageCounts");
        m.checkNotNullParameter(map7, "myBlockedUsers");
        m.checkNotNullParameter(map8, "mostRecentMessageIds");
        m.checkNotNullParameter(emojiSet, "emojis");
        m.checkNotNullParameter(map9, "forumPostReadStates");
        m.checkNotNullParameter(map10, "forumPostUnreadCounts");
        m.checkNotNullParameter(set, "forumPostWithPersistedReadStates");
        m.checkNotNullParameter(map11, "typingUsers");
        Map map12 = widgetForumBrowserViewModel$Companion$observeStoreState$1$1.$activeThreads;
        m.checkNotNullExpressionValue(map3, "guildMembers");
        Channel channel = widgetForumBrowserViewModel$Companion$observeStoreState$1$1.$parentChannel;
        Set<Long> setKeySet = map7.keySet();
        boolean zCan = PermissionUtils.can(Permission.SEND_MESSAGES, l);
        Map<String, Emoji> map13 = emojiSet.emojiIndex;
        m.checkNotNullExpressionValue(map13, "emojis.emojiIndex");
        Map map14 = h0.toMap(map13);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Integer> map$Entry : map10.entrySet()) {
            if (set.contains(Long.valueOf(map$Entry.getKey().longValue()))) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map$Entry<Long, ? extends Set<Long>> map$Entry2 : map11.entrySet()) {
            if (widgetForumBrowserViewModel$Companion$observeStoreState$1$1.$activeThreads.containsKey(Long.valueOf(map$Entry2.getKey().longValue()))) {
                linkedHashMap2.put(map$Entry2.getKey(), map$Entry2.getValue());
            }
            widgetForumBrowserViewModel$Companion$observeStoreState$1$1 = this;
        }
        return new WidgetForumBrowserViewModel$StoreState$Loaded(meUser, map, archivedThreadsStore$ThreadListingState, map12, map3, map4, map2, channel, map5, map6, setKeySet, zCan, map8, map14, map9, linkedHashMap, z2, linkedHashMap2);
    }
}
