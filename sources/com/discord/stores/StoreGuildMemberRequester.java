package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.guildmember.GuildMembersChunk;
import com.discord.api.user.User;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.utilities.lazy.requester.GuildMemberRequestManager;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.TreeMap;

/* JADX INFO: compiled from: StoreGuildMemberRequester.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildMemberRequester extends Store {
    private final TreeMap<Long, Map<Long, Message>> channelPendingMessages;
    private final StoreStream collector;
    private final Dispatcher dispatcher;
    private boolean isConnected;
    private final GuildMemberRequestManager requestManager;

    public StoreGuildMemberRequester(StoreStream storeStream, Dispatcher dispatcher) {
        m.checkNotNullParameter(storeStream, "collector");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.collector = storeStream;
        this.dispatcher = dispatcher;
        this.requestManager = new GuildMemberRequestManager(new StoreGuildMemberRequester$requestManager$1(this), new StoreGuildMemberRequester$requestManager$2(this));
        this.channelPendingMessages = new TreeMap<>();
    }

    public static final /* synthetic */ GuildMemberRequestManager access$getRequestManager$p(StoreGuildMemberRequester storeGuildMemberRequester) {
        return storeGuildMemberRequester.requestManager;
    }

    public static final /* synthetic */ boolean access$guildMemberExists(StoreGuildMemberRequester storeGuildMemberRequester, long j, long j2) {
        return storeGuildMemberRequester.guildMemberExists(j, j2);
    }

    public static final /* synthetic */ void access$sendRequests(StoreGuildMemberRequester storeGuildMemberRequester, long j, List list) {
        storeGuildMemberRequester.sendRequests(j, list);
    }

    @StoreThread
    private final boolean guildMemberExists(long guildId, long userId) {
        Map<Long, GuildMember> map = this.collector.getGuilds().getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        return (map != null ? map.get(Long.valueOf(userId)) : null) != null;
    }

    @StoreThread
    private final void requestForMessages(long guildId, Iterable<Message> messages) {
        for (Message message : messages) {
            User author = message.getAuthor();
            if (author != null) {
                this.requestManager.queueRequest(guildId, author.getId());
            }
            List<User> mentions = message.getMentions();
            if (mentions != null) {
                Iterator<T> it = mentions.iterator();
                while (it.hasNext()) {
                    this.requestManager.queueRequest(guildId, ((User) it.next()).getId());
                }
            }
        }
    }

    @StoreThread
    private final void sendRequests(long guildId, List<Long> userIds) {
        StoreGatewayConnection.requestGuildMembers$default(this.collector.getGatewaySocket(), guildId, null, userIds, null, 2, null);
    }

    @StoreThread
    public final void handleConnectionOpen() {
        this.isConnected = true;
        this.requestManager.reset();
        for (Map$Entry<Long, Map<Long, Message>> map$Entry : this.channelPendingMessages.entrySet()) {
            handleLoadMessages(map$Entry.getKey().longValue(), map$Entry.getValue().values());
        }
        this.channelPendingMessages.clear();
    }

    @StoreThread
    public final void handleConnectionReady(boolean isConnected) {
        this.isConnected = isConnected;
        if (isConnected) {
            this.requestManager.requestUnacknowledged();
        }
    }

    @StoreThread
    public final void handleGuildMembersChunk(GuildMembersChunk chunk) {
        m.checkNotNullParameter(chunk, "chunk");
        long guildId = chunk.getGuildId();
        List<com.discord.api.guildmember.GuildMember> listB = chunk.b();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listB, 10));
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.discord.api.guildmember.GuildMember) it.next()).getUser());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.requestManager.acknowledge(guildId, ((User) it2.next()).getId());
        }
        List<Long> listC = chunk.c();
        if (listC != null) {
            Iterator<T> it3 = listC.iterator();
            while (it3.hasNext()) {
                this.requestManager.acknowledge(guildId, ((Number) it3.next()).longValue());
            }
        }
    }

    @StoreThread
    public final void handleLoadMessages(long channelId, Collection<Message> messages) {
        m.checkNotNullParameter(messages, "messages");
        if (!this.isConnected) {
            Map map = this.channelPendingMessages.get(Long.valueOf(channelId));
            if (map == null) {
                map = new HashMap(messages.size());
            }
            for (Object obj : messages) {
                map.put(Long.valueOf(((Message) obj).getId()), obj);
            }
            this.channelPendingMessages.put(Long.valueOf(channelId), (Map<Long, Message>) map);
            return;
        }
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.collector.getChannels().findChannelByIdInternal$app_productionGoogleRelease(channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            Long lValueOf = Long.valueOf(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId());
            if (!(lValueOf.longValue() > 0)) {
                lValueOf = null;
            }
            if (lValueOf != null) {
                requestForMessages(lValueOf.longValue(), messages);
                this.requestManager.flush();
            }
        }
    }

    public final void performQueuedRequests() {
        this.dispatcher.schedule(new StoreGuildMemberRequester$performQueuedRequests$1(this));
    }

    public final void queueRequest(long guildId, long userId) {
        this.dispatcher.schedule(new StoreGuildMemberRequester$queueRequest$1(this, guildId, userId));
    }
}
