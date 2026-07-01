package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.permission.Permission;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelNotificationSettings$ChannelOverride;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelPayload$VersionedReadStates;
import com.discord.models.domain.ModelReadState;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.message.Message;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import d0.t.h0;
import d0.t.o;
import d0.t.r;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreMentions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMentions extends StoreV2 {
    private final HashMap<Long, Long> channelGuildIds;
    private final Persister<Map<Long, Integer>> countsCache;
    private final Map<Long, Integer> countsEmpty;
    private Map<Long, Integer> countsSnapshot;
    private final HashMap<Long, Message> mentionedMessages;
    private long myId;
    private final HashMap<Long, List<Long>> myRoleIds;
    private final ObservationDeck observationDeck;
    private final HashSet<Long> privateChannels;
    private long selectedChannelId;
    private final ArrayList<ModelReadState> serverInitReadStates;
    private final StoreChannels storeChannels;
    private final StoreMessageAck storeMessageAck;
    private final StorePermissions storePermissions;
    private final StoreThreadsJoined storeThreadsJoined;
    private final StoreUserGuildSettings storeUserGuildSettings;
    private final StoreUserRelationships storeUserRelationships;

    public /* synthetic */ StoreMentions(StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreMessageAck storeMessageAck, StoreUserGuildSettings storeUserGuildSettings, StoreChannels storeChannels, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeUserRelationships, storePermissions, storeMessageAck, storeUserGuildSettings, storeChannels, storeThreadsJoined, (i & 64) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(StoreMentions storeMentions) {
        return storeMentions.storeChannels;
    }

    @StoreThread
    private final Map<Long, Integer> computeMentionCounts() {
        StoreMessageAck$Ack storeMessageAck$Ack;
        if (this.serverInitReadStates.isEmpty() && this.mentionedMessages.isEmpty()) {
            return this.countsEmpty;
        }
        HashMap map = new HashMap();
        Map<Long, StoreMessageAck$Ack> allInternal = this.storeMessageAck.getAllInternal();
        for (ModelReadState modelReadState : this.serverInitReadStates) {
            long channelId = modelReadState.getChannelId();
            long lastMessageId = modelReadState.getLastMessageId();
            int mentionCount = modelReadState.getMentionCount();
            if (mentionCount >= 1 && isMentionableChannel(channelId) && (storeMessageAck$Ack = allInternal.get(Long.valueOf(channelId))) != null && storeMessageAck$Ack.getMessageId() <= lastMessageId) {
                Long lValueOf = Long.valueOf(channelId);
                Integer num = (Integer) map.get(Long.valueOf(channelId));
                if (num == null) {
                    num = 0;
                }
                map.put(lValueOf, Integer.valueOf(num.intValue() + mentionCount));
            }
        }
        for (Message message : this.mentionedMessages.values()) {
            long channelId2 = message.getChannelId();
            User author = message.getAuthor();
            if (!ModelUserRelationship.isType(this.storeUserRelationships.getRelationships().get(author != null ? Long.valueOf(author.getId()) : null), 2) && isMentionableChannel(channelId2)) {
                StoreMessageAck$Ack storeMessageAck$Ack2 = allInternal.get(Long.valueOf(channelId2));
                if (storeMessageAck$Ack2 == null || storeMessageAck$Ack2.getMessageId() < message.getId()) {
                    Long lValueOf2 = Long.valueOf(channelId2);
                    Integer num2 = (Integer) map.get(Long.valueOf(channelId2));
                    if (num2 == null) {
                        num2 = 0;
                    }
                    map.put(lValueOf2, Integer.valueOf(num2.intValue() + 1));
                }
            }
        }
        return map;
    }

    @StoreThread
    private final boolean hasMention(long channelId, User author, UtcDateTime editedTimestamp, List<User> mentions, List<Long> mentionRoles, Boolean mentionEveryone) {
        List<Long> list;
        boolean z2;
        ModelNotificationSettings modelNotificationSettings;
        ModelNotificationSettings$ChannelOverride channelOverride;
        Long l = this.channelGuildIds.get(Long.valueOf(channelId));
        if (l == null) {
            l = 0L;
        }
        m.checkNotNullExpressionValue(l, "channelGuildIds[channelId] ?: 0");
        long jLongValue = l.longValue();
        if (author == null || author.getId() != this.myId) {
            if ((editedTimestamp != null ? editedTimestamp.getDateTimeMillis() : 0L) <= 0) {
                Channel channel = this.storeChannels.getChannel(channelId);
                if (channel != null && ChannelUtils.H(channel) && !this.storeThreadsJoined.hasJoined(channelId)) {
                    return false;
                }
                Map<Long, ModelNotificationSettings> guildSettingsInternal$app_productionGoogleRelease = this.storeUserGuildSettings.getGuildSettingsInternal$app_productionGoogleRelease();
                if (this.privateChannels.contains(Long.valueOf(channelId)) && ((modelNotificationSettings = guildSettingsInternal$app_productionGoogleRelease.get(0L)) == null || (channelOverride = modelNotificationSettings.getChannelOverride(channelId)) == null || !channelOverride.isMuted())) {
                    return true;
                }
                if (mentions != null) {
                    if (!mentions.isEmpty()) {
                        Iterator<T> it = mentions.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            if (((User) it.next()).getId() == this.myId) {
                                z2 = true;
                                break;
                            }
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                    if (z2) {
                        return true;
                    }
                }
                ModelNotificationSettings modelNotificationSettings2 = guildSettingsInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue));
                if ((modelNotificationSettings2 == null || !modelNotificationSettings2.isSuppressRoles()) && (list = this.myRoleIds.get(Long.valueOf(jLongValue))) != null && mentionRoles != null) {
                    Iterator<T> it2 = mentionRoles.iterator();
                    if (it2.hasNext()) {
                        return list.contains(Long.valueOf(((Number) it2.next()).longValue()));
                    }
                }
                if (!m.areEqual(mentionEveryone, Boolean.TRUE)) {
                    return false;
                }
                ModelNotificationSettings modelNotificationSettings3 = guildSettingsInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue));
                return modelNotificationSettings3 == null || !modelNotificationSettings3.isSuppressEveryone();
            }
        }
        return false;
    }

    @StoreThread
    private final boolean isMentionableChannel(long channelId) {
        StoreMessageAck$Ack storeMessageAck$Ack = this.storeMessageAck.getAllInternal().get(Long.valueOf(channelId));
        boolean zIsLockedAck = storeMessageAck$Ack != null ? storeMessageAck$Ack.isLockedAck() : false;
        if (channelId == this.selectedChannelId && !zIsLockedAck) {
            return false;
        }
        return this.privateChannels.contains(Long.valueOf(channelId)) || PermissionUtils.can(Permission.VIEW_CHANNEL, this.storePermissions.getPermissionsByChannel().get(Long.valueOf(channelId)));
    }

    @StoreThread
    private final void removeAllMessagesForChannel(long channelId) {
        HashMap<Long, Message> map = this.mentionedMessages;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Message> map$Entry : map.entrySet()) {
            if (map$Entry.getValue().getChannelId() == channelId) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            this.mentionedMessages.remove(Long.valueOf(((Number) it.next()).longValue()));
            markChanged();
        }
    }

    public final Map<Long, Integer> getMentionCounts() {
        return this.countsSnapshot;
    }

    @StoreThread
    public final void handleChannelOrThreadCreateOrUpdate(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        this.channelGuildIds.put(Long.valueOf(channel.getId()), Long.valueOf(channel.getGuildId()));
        if (!ChannelUtils.B(channel) || ChannelUtils.y(channel)) {
            return;
        }
        this.privateChannels.add(Long.valueOf(channel.getId()));
    }

    @StoreThread
    public final void handleChannelOrThreadDelete(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        this.channelGuildIds.remove(Long.valueOf(channel.getId()));
        this.privateChannels.remove(Long.valueOf(channel.getId()));
        removeAllMessagesForChannel(channel.getId());
    }

    @StoreThread
    public final void handleChannelSelected(long selectedChannelId) {
        this.selectedChannelId = selectedChannelId;
        markChanged();
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.privateChannels.clear();
        this.mentionedMessages.clear();
        this.channelGuildIds.clear();
        this.myRoleIds.clear();
        this.myId = payload.getMe().getId();
        for (Guild guild : payload.getGuilds()) {
            m.checkNotNullExpressionValue(guild, "guild");
            handleGuildAdd(guild);
        }
        HashSet<Long> hashSet = this.privateChannels;
        List<Channel> privateChannels = payload.getPrivateChannels();
        ArrayList arrayListA0 = a.a0(privateChannels, "payload.privateChannels");
        for (Object obj : privateChannels) {
            Channel channel = (Channel) obj;
            m.checkNotNullExpressionValue(channel, "it");
            if (!ChannelUtils.y(channel)) {
                arrayListA0.add(obj);
            }
        }
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(arrayListA0, 10));
        Iterator it = arrayListA0.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Channel) it.next()).getId()));
        }
        hashSet.addAll(arrayList);
        ModelPayload$VersionedReadStates readState = payload.getReadState();
        m.checkNotNullExpressionValue(readState, "payload.readState");
        if (readState.isPartial()) {
            ModelPayload$VersionedReadStates readState2 = payload.getReadState();
            m.checkNotNullExpressionValue(readState2, "payload.readState");
            List<ModelReadState> entries = readState2.getEntries();
            m.checkNotNullExpressionValue(entries, "payload.readState.entries");
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(entries, 10));
            Iterator<T> it2 = entries.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Long.valueOf(((ModelReadState) it2.next()).getChannelId()));
            }
            r.removeAll((List) this.serverInitReadStates, (Function1) new StoreMentions$handleConnectionOpen$3(u.toHashSet(arrayList2)));
        } else {
            this.serverInitReadStates.clear();
        }
        ArrayList<ModelReadState> arrayList3 = this.serverInitReadStates;
        ModelPayload$VersionedReadStates readState3 = payload.getReadState();
        m.checkNotNullExpressionValue(readState3, "payload.readState");
        List<ModelReadState> entries2 = readState3.getEntries();
        m.checkNotNullExpressionValue(entries2, "payload.readState.entries");
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : entries2) {
            if (((ModelReadState) obj2).isMentioned()) {
                arrayList4.add(obj2);
            }
        }
        arrayList3.addAll(arrayList4);
        r.removeAll((List) this.serverInitReadStates, (Function1) new StoreMentions$handleConnectionOpen$5(this));
        markChanged();
    }

    @StoreThread
    public final void handleGuildAdd(Guild guild) {
        Object next;
        m.checkNotNullParameter(guild, "guild");
        List<GuildMember> listV = guild.v();
        if (listV != null) {
            Iterator<T> it = listV.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((GuildMember) next).getUser().getId() == this.myId));
            GuildMember guildMember = (GuildMember) next;
            if (guildMember != null) {
                this.myRoleIds.put(Long.valueOf(guild.getId()), guildMember.l());
            }
        }
        List<Channel> listG = guild.g();
        if (listG != null) {
            Iterator<T> it2 = listG.iterator();
            while (it2.hasNext()) {
                this.channelGuildIds.put(Long.valueOf(((Channel) it2.next()).getId()), Long.valueOf(guild.getId()));
            }
        }
        List<Channel> listN = guild.N();
        if (listN != null) {
            Iterator<T> it3 = listN.iterator();
            while (it3.hasNext()) {
                this.channelGuildIds.put(Long.valueOf(((Channel) it3.next()).getId()), Long.valueOf(guild.getId()));
            }
        }
    }

    @StoreThread
    public final void handleGuildMemberAdd(GuildMember member) {
        m.checkNotNullParameter(member, "member");
        long id2 = member.getUser().getId();
        if (id2 == this.myId) {
            this.myRoleIds.put(Long.valueOf(id2), member.l());
        }
    }

    @StoreThread
    public final void handleMessageAck(ModelReadState readState) {
        m.checkNotNullParameter(readState, "readState");
        r.removeAll((List) this.serverInitReadStates, (Function1) new StoreMentions$handleMessageAck$1(readState));
        this.serverInitReadStates.add(readState);
        markChanged();
    }

    @StoreThread
    public final void handleMessageCreateOrUpdate(com.discord.api.message.Message message) {
        m.checkNotNullParameter(message, "message");
        if (hasMention(message)) {
            this.mentionedMessages.put(Long.valueOf(message.getId()), new Message(message));
            markChanged();
        }
    }

    @StoreThread
    public final void handleMessageDeleted(ModelMessageDelete messageDeleteBulk) {
        m.checkNotNullParameter(messageDeleteBulk, "messageDeleteBulk");
        if (this.privateChannels.contains(Long.valueOf(messageDeleteBulk.getChannelId()))) {
            List<Long> messageIds = messageDeleteBulk.getMessageIds();
            m.checkNotNullExpressionValue(messageIds, "messageDeleteBulk.messageIds");
            for (Long l : messageIds) {
                HashMap<Long, Message> map = this.mentionedMessages;
                m.checkNotNullExpressionValue(l, "it");
                map.remove(l);
            }
            markChanged();
        }
    }

    @StoreThread
    public final void handleThreadListSync(ModelThreadListSync payload) {
        m.checkNotNullParameter(payload, "payload");
        Iterator<Channel> it = payload.getThreads().iterator();
        while (it.hasNext()) {
            this.channelGuildIds.put(Long.valueOf(it.next().getId()), Long.valueOf(payload.getGuildId()));
        }
    }

    @StoreThread
    public final void handleThreadMembersUpdate(ThreadMembersUpdate payload) {
        m.checkNotNullParameter(payload, "payload");
        List<Long> listD = payload.d();
        if (listD == null || !listD.contains(Long.valueOf(this.myId))) {
            return;
        }
        removeAllMessagesForChannel(payload.getId());
    }

    public final Observable<Map<Long, Integer>> observeMentionCounts() {
        Observable<Map<Long, Integer>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreMentions$observeMentionCounts$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Integer> observeTotalMentions() {
        Observable observableG = observeMentionCounts().G(StoreMentions$observeTotalMentions$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "observeMentionCounts()\n … .map { it.values.sum() }");
        return observableG;
    }

    @StoreThread
    public final int processMarkUnread$app_productionGoogleRelease(long channelId, List<Message> messagesAfter) {
        m.checkNotNullParameter(messagesAfter, "messagesAfter");
        int i = 0;
        for (Message message : messagesAfter) {
            if (!this.mentionedMessages.containsKey(Long.valueOf(message.getId())) && hasMention(message)) {
                this.mentionedMessages.put(Long.valueOf(message.getId()), message);
                i++;
            }
        }
        r.removeAll((List) this.serverInitReadStates, (Function1) new StoreMentions$processMarkUnread$1(channelId));
        markChanged();
        return i;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        Map<Long, Integer> mapComputeMentionCounts = computeMentionCounts();
        Persister.set$default(this.countsCache, mapComputeMentionCounts, false, 2, null);
        this.countsSnapshot = mapComputeMentionCounts;
    }

    public StoreMentions(StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreMessageAck storeMessageAck, StoreUserGuildSettings storeUserGuildSettings, StoreChannels storeChannels, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(storeMessageAck, "storeMessageAck");
        m.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeUserRelationships = storeUserRelationships;
        this.storePermissions = storePermissions;
        this.storeMessageAck = storeMessageAck;
        this.storeUserGuildSettings = storeUserGuildSettings;
        this.storeChannels = storeChannels;
        this.storeThreadsJoined = storeThreadsJoined;
        this.observationDeck = observationDeck;
        HashMap map = new HashMap();
        this.countsEmpty = map;
        this.countsCache = new Persister<>("CHANNEL_MENTION_COUNTS_V6", map);
        this.countsSnapshot = h0.emptyMap();
        this.serverInitReadStates = new ArrayList<>();
        this.mentionedMessages = new HashMap<>();
        this.privateChannels = new HashSet<>();
        this.myRoleIds = new HashMap<>();
        this.channelGuildIds = new HashMap<>();
    }

    @StoreThread
    private final boolean hasMention(Message message) {
        return hasMention(message.getChannelId(), message.getAuthor(), message.getEditedTimestamp(), message.getMentions(), message.getMentionRoles(), message.getMentionEveryone());
    }

    @StoreThread
    private final boolean hasMention(com.discord.api.message.Message message) {
        return hasMention(message.getChannelId(), message.getAuthor(), message.getEditedTimestamp(), message.t(), message.s(), message.getMentionEveryone());
    }
}
