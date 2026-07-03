package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.guildmember.GuildMembersChunk;
import com.discord.api.user.User;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.utilities.lazy.requester.GuildMemberRequestManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreGuildMemberRequester.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildMemberRequester extends Store {
    private final TreeMap<Long, Map<Long, Message>> channelPendingMessages;
    private final StoreStream collector;
    private final Dispatcher dispatcher;
    private boolean isConnected;
    private final GuildMemberRequestManager requestManager;

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildMemberRequester$performQueuedRequests$1 */
    /* JADX INFO: compiled from: StoreGuildMemberRequester.kt */
    public static final class C60331 extends AbstractC12240o implements Function0<Unit> {
        public C60331() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildMemberRequester.this.requestManager.flush();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildMemberRequester$queueRequest$1 */
    /* JADX INFO: compiled from: StoreGuildMemberRequester.kt */
    public static final class C60341 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60341(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildMemberRequester.this.requestManager.queueRequest(this.$guildId, this.$userId);
        }
    }

    public StoreGuildMemberRequester(StoreStream storeStream, Dispatcher dispatcher) {
        C12238m.checkNotNullParameter(storeStream, "collector");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        this.collector = storeStream;
        this.dispatcher = dispatcher;
        this.requestManager = new GuildMemberRequestManager(new StoreGuildMemberRequester$requestManager$1(this), new StoreGuildMemberRequester$requestManager$2(this));
        this.channelPendingMessages = new TreeMap<>();
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
        for (Map.Entry<Long, Map<Long, Message>> entry : this.channelPendingMessages.entrySet()) {
            handleLoadMessages(entry.getKey().longValue(), entry.getValue().values());
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
        C12238m.checkNotNullParameter(chunk, "chunk");
        long guildId = chunk.getGuildId();
        List<com.discord.api.guildmember.GuildMember> listM7932b = chunk.m7932b();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listM7932b, 10));
        Iterator<T> it = listM7932b.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.discord.api.guildmember.GuildMember) it.next()).getUser());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.requestManager.acknowledge(guildId, ((User) it2.next()).getId());
        }
        List<Long> listM7933c = chunk.m7933c();
        if (listM7933c != null) {
            Iterator<T> it3 = listM7933c.iterator();
            while (it3.hasNext()) {
                this.requestManager.acknowledge(guildId, ((Number) it3.next()).longValue());
            }
        }
    }

    @StoreThread
    public final void handleLoadMessages(long channelId, Collection<Message> messages) {
        C12238m.checkNotNullParameter(messages, "messages");
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
        this.dispatcher.schedule(new C60331());
    }

    public final void queueRequest(long guildId, long userId) {
        this.dispatcher.schedule(new C60341(guildId, userId));
    }
}
