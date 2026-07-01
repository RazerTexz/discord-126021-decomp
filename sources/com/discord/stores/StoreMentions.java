package com.discord.stores;

import b.d.b.a.outline;
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
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.message.Message;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MutableCollections;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreMentions$handleConnectionOpen$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMentions.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<ModelReadState, Boolean> {
        public final /* synthetic */ HashSet $newReadStateChannelIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(HashSet hashSet) {
            super(1);
            this.$newReadStateChannelIds = hashSet;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ModelReadState modelReadState) {
            return Boolean.valueOf(invoke2(modelReadState));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ModelReadState modelReadState) {
            Intrinsics3.checkNotNullParameter(modelReadState, "readState");
            return this.$newReadStateChannelIds.contains(Long.valueOf(modelReadState.getChannelId()));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMentions$handleConnectionOpen$5, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMentions.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<ModelReadState, Boolean> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ModelReadState modelReadState) {
            return Boolean.valueOf(invoke2(modelReadState));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ModelReadState modelReadState) {
            Intrinsics3.checkNotNullParameter(modelReadState, "readState");
            return !StoreMentions.this.storeChannels.getChannelNamesInternal$app_productionGoogleRelease().containsKey(Long.valueOf(modelReadState.getChannelId()));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMentions$handleMessageAck$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMentions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelReadState, Boolean> {
        public final /* synthetic */ ModelReadState $readState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelReadState modelReadState) {
            super(1);
            this.$readState = modelReadState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ModelReadState modelReadState) {
            return Boolean.valueOf(invoke2(modelReadState));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ModelReadState modelReadState) {
            Intrinsics3.checkNotNullParameter(modelReadState, "it");
            return modelReadState.getChannelId() == this.$readState.getChannelId();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMentions$observeMentionCounts$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMentions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Integer>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Integer> invoke() {
            return StoreMentions.this.getMentionCounts();
        }
    }

    public /* synthetic */ StoreMentions(StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreMessageAck storeMessageAck, StoreUserGuildSettings storeUserGuildSettings, StoreChannels storeChannels, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeUserRelationships, storePermissions, storeMessageAck, storeUserGuildSettings, storeChannels, storeThreadsJoined, (i & 64) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    @Store3
    private final Map<Long, Integer> computeMentionCounts() {
        StoreMessageAck.Ack ack;
        if (this.serverInitReadStates.isEmpty() && this.mentionedMessages.isEmpty()) {
            return this.countsEmpty;
        }
        HashMap map = new HashMap();
        Map<Long, StoreMessageAck.Ack> allInternal = this.storeMessageAck.getAllInternal();
        for (ModelReadState modelReadState : this.serverInitReadStates) {
            long channelId = modelReadState.getChannelId();
            long lastMessageId = modelReadState.getLastMessageId();
            int mentionCount = modelReadState.getMentionCount();
            if (mentionCount >= 1 && isMentionableChannel(channelId) && (ack = allInternal.get(Long.valueOf(channelId))) != null && ack.getMessageId() <= lastMessageId) {
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
                StoreMessageAck.Ack ack2 = allInternal.get(Long.valueOf(channelId2));
                if (ack2 == null || ack2.getMessageId() < message.getId()) {
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

    @Store3
    private final boolean hasMention(long channelId, User author, UtcDateTime editedTimestamp, List<User> mentions, List<Long> mentionRoles, Boolean mentionEveryone) {
        List<Long> list;
        boolean z2;
        ModelNotificationSettings modelNotificationSettings;
        ModelNotificationSettings.ChannelOverride channelOverride;
        Long l = this.channelGuildIds.get(Long.valueOf(channelId));
        if (l == null) {
            l = 0L;
        }
        Intrinsics3.checkNotNullExpressionValue(l, "channelGuildIds[channelId] ?: 0");
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
                if (!Intrinsics3.areEqual(mentionEveryone, Boolean.TRUE)) {
                    return false;
                }
                ModelNotificationSettings modelNotificationSettings3 = guildSettingsInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue));
                return modelNotificationSettings3 == null || !modelNotificationSettings3.isSuppressEveryone();
            }
        }
        return false;
    }

    @Store3
    private final boolean isMentionableChannel(long channelId) {
        StoreMessageAck.Ack ack = this.storeMessageAck.getAllInternal().get(Long.valueOf(channelId));
        boolean zIsLockedAck = ack != null ? ack.isLockedAck() : false;
        if (channelId == this.selectedChannelId && !zIsLockedAck) {
            return false;
        }
        return this.privateChannels.contains(Long.valueOf(channelId)) || PermissionUtils.can(Permission.VIEW_CHANNEL, this.storePermissions.getPermissionsByChannel().get(Long.valueOf(channelId)));
    }

    @Store3
    private final void removeAllMessagesForChannel(long channelId) {
        HashMap<Long, Message> map = this.mentionedMessages;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Message> entry : map.entrySet()) {
            if (entry.getValue().getChannelId() == channelId) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
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

    @Store3
    public final void handleChannelOrThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channelGuildIds.put(Long.valueOf(channel.getId()), Long.valueOf(channel.getGuildId()));
        if (!ChannelUtils.B(channel) || ChannelUtils.y(channel)) {
            return;
        }
        this.privateChannels.add(Long.valueOf(channel.getId()));
    }

    @Store3
    public final void handleChannelOrThreadDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channelGuildIds.remove(Long.valueOf(channel.getId()));
        this.privateChannels.remove(Long.valueOf(channel.getId()));
        removeAllMessagesForChannel(channel.getId());
    }

    @Store3
    public final void handleChannelSelected(long selectedChannelId) {
        this.selectedChannelId = selectedChannelId;
        markChanged();
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.privateChannels.clear();
        this.mentionedMessages.clear();
        this.channelGuildIds.clear();
        this.myRoleIds.clear();
        this.myId = payload.getMe().getId();
        for (Guild guild : payload.getGuilds()) {
            Intrinsics3.checkNotNullExpressionValue(guild, "guild");
            handleGuildAdd(guild);
        }
        HashSet<Long> hashSet = this.privateChannels;
        List<Channel> privateChannels = payload.getPrivateChannels();
        ArrayList arrayListA0 = outline.a0(privateChannels, "payload.privateChannels");
        for (Object obj : privateChannels) {
            Channel channel = (Channel) obj;
            Intrinsics3.checkNotNullExpressionValue(channel, "it");
            if (!ChannelUtils.y(channel)) {
                arrayListA0.add(obj);
            }
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arrayListA0, 10));
        Iterator it = arrayListA0.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Channel) it.next()).getId()));
        }
        hashSet.addAll(arrayList);
        ModelPayload.VersionedReadStates readState = payload.getReadState();
        Intrinsics3.checkNotNullExpressionValue(readState, "payload.readState");
        if (readState.isPartial()) {
            ModelPayload.VersionedReadStates readState2 = payload.getReadState();
            Intrinsics3.checkNotNullExpressionValue(readState2, "payload.readState");
            List<ModelReadState> entries = readState2.getEntries();
            Intrinsics3.checkNotNullExpressionValue(entries, "payload.readState.entries");
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(entries, 10));
            Iterator<T> it2 = entries.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Long.valueOf(((ModelReadState) it2.next()).getChannelId()));
            }
            MutableCollections.removeAll((List) this.serverInitReadStates, (Function1) new AnonymousClass3(_Collections.toHashSet(arrayList2)));
        } else {
            this.serverInitReadStates.clear();
        }
        ArrayList<ModelReadState> arrayList3 = this.serverInitReadStates;
        ModelPayload.VersionedReadStates readState3 = payload.getReadState();
        Intrinsics3.checkNotNullExpressionValue(readState3, "payload.readState");
        List<ModelReadState> entries2 = readState3.getEntries();
        Intrinsics3.checkNotNullExpressionValue(entries2, "payload.readState.entries");
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : entries2) {
            if (((ModelReadState) obj2).isMentioned()) {
                arrayList4.add(obj2);
            }
        }
        arrayList3.addAll(arrayList4);
        MutableCollections.removeAll((List) this.serverInitReadStates, (Function1) new AnonymousClass5());
        markChanged();
    }

    @Store3
    public final void handleGuildAdd(Guild guild) {
        Object next;
        Intrinsics3.checkNotNullParameter(guild, "guild");
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

    @Store3
    public final void handleGuildMemberAdd(GuildMember member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        long id2 = member.getUser().getId();
        if (id2 == this.myId) {
            this.myRoleIds.put(Long.valueOf(id2), member.l());
        }
    }

    @Store3
    public final void handleMessageAck(ModelReadState readState) {
        Intrinsics3.checkNotNullParameter(readState, "readState");
        MutableCollections.removeAll((List) this.serverInitReadStates, (Function1) new AnonymousClass1(readState));
        this.serverInitReadStates.add(readState);
        markChanged();
    }

    @Store3
    public final void handleMessageCreateOrUpdate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        if (hasMention(message)) {
            this.mentionedMessages.put(Long.valueOf(message.getId()), new Message(message));
            markChanged();
        }
    }

    @Store3
    public final void handleMessageDeleted(ModelMessageDelete messageDeleteBulk) {
        Intrinsics3.checkNotNullParameter(messageDeleteBulk, "messageDeleteBulk");
        if (this.privateChannels.contains(Long.valueOf(messageDeleteBulk.getChannelId()))) {
            List<Long> messageIds = messageDeleteBulk.getMessageIds();
            Intrinsics3.checkNotNullExpressionValue(messageIds, "messageDeleteBulk.messageIds");
            for (Long l : messageIds) {
                HashMap<Long, Message> map = this.mentionedMessages;
                Intrinsics3.checkNotNullExpressionValue(l, "it");
                map.remove(l);
            }
            markChanged();
        }
    }

    @Store3
    public final void handleThreadListSync(ModelThreadListSync payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        Iterator<Channel> it = payload.getThreads().iterator();
        while (it.hasNext()) {
            this.channelGuildIds.put(Long.valueOf(it.next().getId()), Long.valueOf(payload.getGuildId()));
        }
    }

    @Store3
    public final void handleThreadMembersUpdate(ThreadMembersUpdate payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<Long> listD = payload.d();
        if (listD == null || !listD.contains(Long.valueOf(this.myId))) {
            return;
        }
        removeAllMessagesForChannel(payload.getId());
    }

    public final Observable<Map<Long, Integer>> observeMentionCounts() {
        Observable<Map<Long, Integer>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Integer> observeTotalMentions() {
        Observable observableG = observeMentionCounts().G(new Func1<Map<Long, ? extends Integer>, Integer>() { // from class: com.discord.stores.StoreMentions.observeTotalMentions.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Integer call(Map<Long, ? extends Integer> map) {
                return call2((Map<Long, Integer>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Integer call2(Map<Long, Integer> map) {
                return Integer.valueOf(_Collections.sumOfInt(map.values()));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "observeMentionCounts()\n … .map { it.values.sum() }");
        return observableG;
    }

    @Store3
    public final int processMarkUnread$app_productionGoogleRelease(long channelId, List<Message> messagesAfter) {
        Intrinsics3.checkNotNullParameter(messagesAfter, "messagesAfter");
        int i = 0;
        for (Message message : messagesAfter) {
            if (!this.mentionedMessages.containsKey(Long.valueOf(message.getId())) && hasMention(message)) {
                this.mentionedMessages.put(Long.valueOf(message.getId()), message);
                i++;
            }
        }
        MutableCollections.removeAll((List) this.serverInitReadStates, (Function1) new StoreMentions2(channelId));
        markChanged();
        return i;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        Map<Long, Integer> mapComputeMentionCounts = computeMentionCounts();
        Persister.set$default(this.countsCache, mapComputeMentionCounts, false, 2, null);
        this.countsSnapshot = mapComputeMentionCounts;
    }

    public StoreMentions(StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreMessageAck storeMessageAck, StoreUserGuildSettings storeUserGuildSettings, StoreChannels storeChannels, StoreThreadsJoined storeThreadsJoined, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeMessageAck, "storeMessageAck");
        Intrinsics3.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeThreadsJoined, "storeThreadsJoined");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
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
        this.countsSnapshot = Maps6.emptyMap();
        this.serverInitReadStates = new ArrayList<>();
        this.mentionedMessages = new HashMap<>();
        this.privateChannels = new HashSet<>();
        this.myRoleIds = new HashMap<>();
        this.channelGuildIds = new HashMap<>();
    }

    @Store3
    private final boolean hasMention(Message message) {
        return hasMention(message.getChannelId(), message.getAuthor(), message.getEditedTimestamp(), message.getMentions(), message.getMentionRoles(), message.getMentionEveryone());
    }

    @Store3
    private final boolean hasMention(com.discord.api.message.Message message) {
        return hasMention(message.getChannelId(), message.getAuthor(), message.getEditedTimestamp(), message.t(), message.s(), message.getMentionEveryone());
    }
}
